/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.ejb.endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import org.eclipse.persistence.exceptions.DatabaseException;
import pl.lodz.p.it.spjava.e11.twk.dto.GameSystemDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.GameSystemFacade;
import pl.lodz.p.it.spjava.e11.twk.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.e11.twk.ejb.manager.GameSystemManager;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;
import pl.lodz.p.it.spjava.e11.twk.exception.GameSystemException;
import pl.lodz.p.it.spjava.e11.twk.model.GameSystem;


/**
 *
 * @author Adam
 */
@Stateful
@LocalBean
@Interceptors(LoggingInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class GameSystemEndpoint {
    
    @Inject
    GameSystemFacade gameSystemFacade;
    @Inject
    GameSystemManager gameSystemManager;
    
    GameSystem gameSystem;
    
    @Resource(name = "txRetryLimit")
    private int txRetryLimit;

    public List<GameSystemDTO> listAllGameSystems(){
        List<GameSystemDTO> listGameSystemsDTO = new ArrayList<>();
        List<GameSystem> listGameSystems = gameSystemFacade.findAll();
        for (GameSystem gameSystem : listGameSystems){
            GameSystemDTO gameSystemDTO = new GameSystemDTO(gameSystem.getId(), gameSystem.getSystemName(),gameSystem.getTournamentList(),gameSystem.getLeagueList());
            listGameSystemsDTO.add(gameSystemDTO);
        }
        
        return listGameSystemsDTO;
    }
    
    @RolesAllowed({"Administrator"})
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void deleteGameSystem(GameSystemDTO gameSystemDTO) throws AppBaseException {
       
        boolean rollbackTX;
        int retryTXCounter = txRetryLimit;

        do {
            try {   
                gameSystemManager.deleteGameSystem(gameSystemDTO.getId());
                rollbackTX = gameSystemManager.isLastTransactionRollback();
            } catch (AppBaseException | EJBTransactionRolledbackException ex) {
                Logger.getGlobal().log(Level.SEVERE, "Próba " + retryTXCounter
                        + " wykonania metody biznesowej zakończona wyjątkiem klasy:"
                        + ex.getClass().getName());
                rollbackTX = true;
            }

        } while (rollbackTX && --retryTXCounter > 0);

        if (rollbackTX && retryTXCounter == 0) {
            throw GameSystemException.createGameSystemExceptionWithTxRetryRollback();
        }
    }
    
    @RolesAllowed({"Administrator"})
    public void updateGameSystem(GameSystemDTO gameSystemDTO) throws AppBaseException {
        gameSystem=gameSystemFacade.find(gameSystemDTO.getId());
        gameSystem.setSystemName(gameSystemDTO.getGameSystemName());
        
        boolean rollbackTX;
        int retryTXCounter = txRetryLimit;

        do {
            try {
     
                gameSystemManager.updateGameSystem(gameSystem.getId());
                rollbackTX = gameSystemManager.isLastTransactionRollback();
            } catch (AppBaseException | EJBTransactionRolledbackException ex) {
                Logger.getGlobal().log(Level.SEVERE, "Próba " + retryTXCounter
                        + " wykonania metody biznesowej zakończona wyjątkiem klasy:"
                        + ex.getClass().getName());
                rollbackTX = true;
            }

        } while (rollbackTX && --retryTXCounter > 0);

        if (rollbackTX && retryTXCounter == 0) {
            throw GameSystemException.createGameSystemExceptionWithTxRetryRollback();
        }
       gameSystem=null;
    }
    
    @RolesAllowed({"Administrator"})
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void createGameSystem(GameSystemDTO gameSystemDTO) throws AppBaseException {
        GameSystem newGameSystem = new GameSystem();
        newGameSystem.setSystemName(gameSystemDTO.getGameSystemName());
        boolean rollbackTX;
        int retryTXCounter = txRetryLimit;

        do {
            try {
     
                gameSystemManager.createGameSystem(newGameSystem);
                rollbackTX = gameSystemManager.isLastTransactionRollback();
            } catch (AppBaseException | EJBException ex) {
                Logger.getGlobal().log(Level.SEVERE, "Próba " + retryTXCounter
                        + " wykonania metody biznesowej zakończona wyjątkiem klasy:"
                        + ex.getClass().getName());
                rollbackTX = true;
                throw GameSystemException.createWithDbCheckConstraintKey(gameSystem, ex);
            }

        } while (rollbackTX && --retryTXCounter > 0);

        if (rollbackTX && retryTXCounter == 0) {
            throw GameSystemException.createGameSystemExceptionWithTxRetryRollback();
        }
       gameSystem=null;
    }
    
}
