/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Accounts | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.league;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.GameSystemDTO;
import pl.lodz.p.it.spjava.e11.twk.dto.LeagueDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.LeagueEndpoint;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;
import pl.lodz.p.it.spjava.e11.twk.exception.LeagueException;
import pl.lodz.p.it.spjava.e11.twk.utils.ContextUtils;


/**
 *
 * @author student
 */
@Named(value = "LeagueController")
@SessionScoped
public class LeagueController implements Serializable {

    private LeagueDTO selectedLeagueDTO;
    private LeagueDTO createLeagueDTO;
    
    @Inject
    private LeagueEndpoint leagueEndpoint;

    public LeagueDTO getSelectedLeagueDTO() {
        return selectedLeagueDTO;
    }

    public void setSelectedLeagueDTO(LeagueDTO selectedLeagueDTO ) {
        this.selectedLeagueDTO = selectedLeagueDTO;
    }
    
    /**
     * Creates a new instance of AccountController
     */
    public LeagueController() {
    }
    
    public String createLeague(LeagueDTO leagueDTO, GameSystemDTO gameSystemDTO) {
        try {
            createLeagueDTO = leagueDTO;
            leagueEndpoint.createLeague(createLeagueDTO, gameSystemDTO);
            createLeagueDTO  = null;
            return "goToLeagues";
        } catch (LeagueException gse) {
            if (LeagueException.KEY_DB_CONSTRAINT.equals(gse.getMessage())) {
                ContextUtils.emitInternationalizedMessage("createLeague:name", LeagueException.KEY_DB_CONSTRAINT); 
            } else {
                Logger.getLogger(LeagueController.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji createLeague wyjatku: ", gse);
            }
            return null;
        } catch (AppBaseException abe) {
            Logger.getLogger(LeagueController.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji createLeague wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage("createLeague:confirm", abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            }
            return null;
        }
    }
    
    public String editLeague(LeagueDTO leagueDTO,GameSystemDTO gameSystemDTO) {
        try {
            leagueEndpoint.editLeague(leagueDTO, gameSystemDTO);
            return "goToLeagues";
        } catch (LeagueException gse) {
            if (LeagueException.KEY_DB_CONSTRAINT.equals(gse.getMessage())) {
                System.out.println("-------------------------unique--------------------");
                System.out.println("key " + LeagueException.KEY_DB_CONSTRAINT);
                ContextUtils.emitInternationalizedMessage("editLeague:name", LeagueException.KEY_DB_CONSTRAINT); 
            } else {
                Logger.getLogger(LeagueController.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji editLeague wyjatku: ", gse);
            }
            return null;
        } catch (AppBaseException abe) {
            Logger.getLogger(LeagueController.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji editLeague wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage("editLeague:confirm", abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            }
            return null;
        }
    }
    
    public String deleteLeague(LeagueDTO leagueDTO) throws AppBaseException {
        try {
            leagueEndpoint.deleteLeague(leagueDTO);
            return "goToLeagues";
        } catch (LeagueException ce) {
            if (LeagueException.KEY_LEAGUE_ALREADY_CHANGED.equals(ce.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null, LeagueException.KEY_LEAGUE_ALREADY_CHANGED);
            } else if (LeagueException.KEY_LEAGUE_NOT_FOUND.equals(ce.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null, LeagueException.KEY_LEAGUE_NOT_FOUND);
            } else if (LeagueException.KEY_LEAGUE_OPTIMISTIC_LOCK.equals(ce.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null, LeagueException.KEY_LEAGUE_OPTIMISTIC_LOCK);
            } else {
                Logger.getLogger(LeagueController.class.getName()).log(Level.SEVERE,
                        "Zgłoszenie w metodzie akcji deleteLeague wyjatku: ", ce);
            }
            return null;
        } catch (AppBaseException abe) {
            Logger.getLogger(LeagueController.class.getName()).log(Level.SEVERE,
                    "Zgłoszenie w metodzie akcji deleteLeague wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage("deleteLeague:confirm", abe.getMessage());
            }
            return null;
        }
    }        
    
}
