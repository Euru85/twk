/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.ejb.facade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import org.eclipse.persistence.exceptions.DatabaseException;
import pl.lodz.p.it.spjava.e11.twk.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;
import pl.lodz.p.it.spjava.e11.twk.exception.GameSystemException;
import pl.lodz.p.it.spjava.e11.twk.model.GameSystem;

/**
 *
 * @author Adam
 */
@Stateless
@LocalBean
@Interceptors(LoggingInterceptor.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class GameSystemFacade extends AbstractFacade<GameSystem> {
    
    private static final String DB_UNIQUE_CONSTRAINT_FOR_GAME_SYSTEM_NAME = "SQL210823204352190";

    @PersistenceContext(unitName = "pl.lodz.p.it.spjava.e11_TabletopWargamesKeeperPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GameSystemFacade() {
        super(GameSystem.class);
    }

    @Override
    public void create(GameSystem entity) throws AppBaseException {
        try{
            super.create(entity); //To change body of generated methods, choose Tools | Templates.
            em.flush();
        } catch ( PersistenceException|DatabaseException ex){
            final Throwable cause = ex.getCause();
            final Throwable causeCause = ex.getCause().getCause();
            System.out.println("-----------------------GAME SYSTEM facade - create ------------------------");
            System.out.println("cause "+cause);
            System.out.println("cause "+cause.getMessage());
            System.out.println("causeCause "+causeCause);
            System.out.println("causeCause "+causeCause.getMessage());
            
            if (cause instanceof DatabaseException
                    && causeCause.getMessage().contains(DB_UNIQUE_CONSTRAINT_FOR_GAME_SYSTEM_NAME)){ 
                throw GameSystemException.createWithDbCheckConstraintKey(entity, cause);
            }
        }
    }
    
    @Override
    public void edit(GameSystem entity) throws AppBaseException {
        try{
            super.edit(entity); //To change body of generated methods, choose Tools | Templates.
            em.flush();
        } catch (OptimisticLockException oe) {
            throw GameSystemException.createGameSystemWithOptimisticLockKey(entity, oe);
        } catch ( PersistenceException|DatabaseException ex){
            final Throwable cause = ex.getCause();
            final Throwable causeCause = ex.getCause().getCause();
            System.out.println("-----------------------GAME SYSTEM facade -edit ------------------------");
            System.out.println("cause "+cause);
            System.out.println("cause "+cause.getMessage());
            System.out.println("causeCause "+causeCause);
            System.out.println("causeCause "+causeCause.getMessage());
            
            if (cause instanceof DatabaseException
                    && causeCause.getMessage().contains(DB_UNIQUE_CONSTRAINT_FOR_GAME_SYSTEM_NAME)){ 
                throw GameSystemException.createWithDbCheckConstraintKey(entity, cause);
            }
        }
    }
    
    @Override
    public void remove(GameSystem entity) throws AppBaseException {
        try {
            super.remove(entity);
            em.flush();
        } catch (OptimisticLockException oe) {
            throw GameSystemException.createGameSystemWithOptimisticLockKey(entity, oe);
        }
    }
    
    
}
