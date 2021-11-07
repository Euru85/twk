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
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import org.eclipse.persistence.exceptions.DatabaseException;
import pl.lodz.p.it.spjava.e11.twk.dto.GameSystemDTO;
import pl.lodz.p.it.spjava.e11.twk.dto.LeagueDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.GameSystemFacade;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.LeagueFacade;
import pl.lodz.p.it.spjava.e11.twk.ejb.manager.LeagueManager;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;
import pl.lodz.p.it.spjava.e11.twk.exception.LeagueException;


import pl.lodz.p.it.spjava.e11.twk.model.League;

/**
 *
 * @author Adam
 */
@Stateful
public class LeagueEndpoint {
    
    @EJB
    LeagueFacade leagueFacade;
    @EJB
    GameSystemFacade gameSystemFacade;
    @Inject 
    LeagueManager leagueManager;
    
    League league;
    
    private League leagueEdit;
    private League leagueDelete;
    
    @Resource(name = "txRetryLimit")
    private int txRetryLimit;

    public List<LeagueDTO> listAllLeagues(){
        List<LeagueDTO> listLeaguesDTO = new ArrayList<>();
        List<League> listLeagues = leagueFacade.findAll();
        for (League league : listLeagues){
            LeagueDTO leagueDTO = new LeagueDTO(league.getId(), league.getLeagueName(), league.getGameSystemId(), league.getTournamentList());
            listLeaguesDTO.add(leagueDTO);
        }
        
        return listLeaguesDTO;
    }
   
     public List<LeagueDTO> listLeaguesByGameSystemDTO(GameSystemDTO gameSystemDTO){
        List<LeagueDTO> listLeaguesDTO = new ArrayList<>();
        for (League league : gameSystemDTO.getLeagueList()){
            LeagueDTO leagueDTO = new LeagueDTO(league.getId(), league.getLeagueName(), league.getGameSystemId(), league.getTournamentList());
            listLeaguesDTO.add(leagueDTO);
        }
        return listLeaguesDTO;
    }
     
    @RolesAllowed({"Administrator"})
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void deleteLeague(LeagueDTO leagueDTO) throws AppBaseException {
        leagueDelete = leagueFacade.find(leagueDTO.getId());
        boolean rollbackTX;
        int retryTXCounter = txRetryLimit;

        do {
            try {   
                leagueManager.deleteLeague(leagueDelete);
                rollbackTX = leagueManager.isLastTransactionRollback();
            } catch(LeagueException le){
                throw le;
            } catch (AppBaseException | EJBTransactionRolledbackException ex) {
                Logger.getGlobal().log(Level.SEVERE, "Próba " + retryTXCounter
                        + " wykonania metody biznesowej zakończona wyjątkiem klasy:"
                        + ex.getClass().getName());
                rollbackTX = true;
            }

        } while (rollbackTX && --retryTXCounter > 0);

        if (rollbackTX && retryTXCounter == 0) {
            throw LeagueException.createLeagueExceptionWithTxRetryRollback();
        }
    }
    
    @RolesAllowed({"Administrator"})
    public void editLeague(LeagueDTO leagueDTO, GameSystemDTO gameSystemDTO) throws AppBaseException {
        leagueEdit=leagueFacade.find(leagueDTO.getId());
        leagueFacade.refresh(leagueEdit);
        leagueEdit.setLeagueName(leagueDTO.getLeagueName());
        leagueEdit.setGameSystemId(gameSystemFacade.find(gameSystemDTO.getId()));
        System.out.println("++++++++++++++++++++++++SYSTEM NAME PRZY EDICIE++++++++++++++++");
        System.out.println(leagueEdit.getGameSystemId().getSystemName());
        
        boolean rollbackTX;
        int retryTXCounter = txRetryLimit;
        try{
            do {
                try {
     
                leagueManager.editLeague(leagueEdit);
                leagueFacade.refresh(leagueEdit);
                leagueEdit=null;
                rollbackTX = leagueManager.isLastTransactionRollback();
                } catch(LeagueException le){
                    throw le;
                } catch (AppBaseException | EJBTransactionRolledbackException ex) {
                    Logger.getGlobal().log(Level.SEVERE, "Próba " + retryTXCounter
                        + " wykonania metody biznesowej zakończona wyjątkiem klasy:"
                        + ex.getClass().getName());
                rollbackTX = true;
                }
            } while (rollbackTX && --retryTXCounter > 0);
        } catch (DatabaseException ex){
            throw LeagueException.createWithDbCheckConstraintKey(league, ex);
        }

        if (rollbackTX && retryTXCounter == 0) {
            throw LeagueException.createLeagueExceptionWithTxRetryRollback();
        }
       league=null;
    }
    
    @RolesAllowed({"Administrator"})
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void createLeague(LeagueDTO leagueDTO, GameSystemDTO gameSystemDTO) throws AppBaseException {
        League newLeague = new League();
        newLeague.setLeagueName(leagueDTO.getLeagueName());
        newLeague.setGameSystemId(gameSystemFacade.find(gameSystemDTO.getId()));
        boolean rollbackTX;
        int retryTXCounter = txRetryLimit;
        try{
            do {
                try {
     
                    leagueManager.createLeague(newLeague);
                    rollbackTX = leagueManager.isLastTransactionRollback();
                } catch(LeagueException le){
                    throw le;
                } catch (AppBaseException | EJBTransactionRolledbackException ex) {
                    Logger.getGlobal().log(Level.SEVERE, "Próba " + retryTXCounter
                        + " wykonania metody biznesowej zakończona wyjątkiem klasy:"
                        + ex.getClass().getName());
                    rollbackTX = true;
                }
            } while (rollbackTX && --retryTXCounter > 0);
        } catch (DatabaseException ex){
            throw LeagueException.createWithDbCheckConstraintKey(league, ex);
        }
        if (rollbackTX && retryTXCounter == 0) {
            throw LeagueException.createLeagueExceptionWithTxRetryRollback();
        }
       league=null;
    }
}
