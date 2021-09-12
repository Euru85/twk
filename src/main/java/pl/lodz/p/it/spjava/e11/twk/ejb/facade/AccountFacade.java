/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.ejb.facade;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import pl.lodz.p.it.spjava.e11.twk.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.e11.twk.model.Account;
import pl.lodz.p.it.spjava.e11.twk.model.Account_;

/**
 *
 * @author Adam
 */
@Stateless
@LocalBean
@RolesAllowed({"Klient", "Pracownik", "Administrator"})
@Interceptors(LoggingInterceptor.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class AccountFacade extends AbstractFacade<Account> {

    private static final Logger LOG = Logger.getLogger(AccountFacade.class.getName());
    
    @PersistenceContext(unitName = "pl.lodz.p.it.spjava.e11_TabletopWargamesKeeperPU")
    private EntityManager em;
   

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }
    
    @RolesAllowed({"Player", "Organizator", "Administrator"})
    public Account findLogin(String login) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Account> query = cb.createQuery(Account.class);
        Root<Account> from = query.from(Account.class);
        query = query.select(from);
        query = query.where(cb.equal(from.get(Account_.login), login)); //Przykład wskazania atrybutu encji poprzez klasę metamodelu
        TypedQuery<Account> tq = em.createQuery(query);

        return tq.getSingleResult();
    }
    
    
    @ExcludeClassInterceptors //Nie chcemy ujawniać w dziennikach skrótu hasła
    @RolesAllowed("AUTHENTICATOR") //"Zwykłe" role nie mają tu dostępu. Musi pośredniczyć odpowiedni endpoint opisany jako @RunAs("AUTHENTICATOR").
    public Account findLoginAndHash(String login, String hash){
                if (null == login || null == hash || login.isEmpty() || hash.isEmpty()) {
            return null;
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Account> query = cb.createQuery(Account.class);
        Root<Account> from = query.from(Account.class);
        Predicate criteria = cb.conjunction();
        criteria = cb.and(criteria, cb.equal(from.get(Account_.login),login ));
        criteria = cb.and(criteria, cb.equal(from.get(Account_.password), hash));
        criteria = cb.and(criteria, cb.isTrue(from.get(Account_.active)));
        query = query.select(from);
        query = query.where(criteria);
        TypedQuery<Account> tq = em.createQuery(query);

        try {
            return tq.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Authentication for login: {0} failed with: {1}", new Object[]{login, ex});
        }
        return null;
    }
    
}
