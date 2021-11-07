/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.ejb.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import org.eclipse.persistence.exceptions.DatabaseException;
import static pl.lodz.p.it.spjava.e11.twk.ejb.facade.AbstractFacade.DB_UNIQUE_CONSTRAINT_FOR_LEAGUE_NAME;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;
import pl.lodz.p.it.spjava.e11.twk.exception.LeagueException;
import pl.lodz.p.it.spjava.e11.twk.model.League;

/**
 *
 * @author Adam
 */
@Stateless
public class LeagueFacade extends AbstractFacade<League> {

    @PersistenceContext(unitName = "pl.lodz.p.it.spjava.e11_TabletopWargamesKeeperPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LeagueFacade() {
        super(League.class);
    }
    @Override
    public void create(League entity) throws AppBaseException {
        try{
            super.create(entity); //To change body of generated methods, choose Tools | Templates.
            em.flush();
        } catch ( PersistenceException|DatabaseException ex){
            final Throwable cause = ex.getCause();
            final Throwable causeCause = ex.getCause().getCause();
            
            if (cause instanceof DatabaseException
                    && causeCause.getMessage().contains(DB_UNIQUE_CONSTRAINT_FOR_LEAGUE_NAME)){ 
                throw LeagueException.createWithDbCheckConstraintKey(entity, cause);
            }
        }
    }
    
    @Override
    public void edit(League entity) throws AppBaseException {
        try{
            super.edit(entity); //To change body of generated methods, choose Tools | Templates.
            em.flush();
        } catch (OptimisticLockException oe) {
            throw LeagueException.createLeagueWithOptimisticLockKey(entity, oe);
        } catch ( PersistenceException|DatabaseException ex){
            final Throwable cause = ex.getCause();
            final Throwable causeCause = ex.getCause().getCause();
            
            if (cause instanceof DatabaseException
                    && causeCause.getMessage().contains(DB_UNIQUE_CONSTRAINT_FOR_LEAGUE_NAME)){ 
                throw LeagueException.createWithDbCheckConstraintKey(entity, cause);
            }
        }
    }
    
    @Override
    public void remove(League entity) throws AppBaseException {
        try {
            super.remove(entity);
            em.flush();
        } catch (OptimisticLockException oe) {
            throw LeagueException.createLeagueWithOptimisticLockKey(entity, oe);
        }
    }
}
