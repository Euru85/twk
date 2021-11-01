/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Accounts | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.gamesystem;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.GameSystemDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.GameSystemEndpoint;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;
import pl.lodz.p.it.spjava.e11.twk.exception.GameSystemException;
import pl.lodz.p.it.spjava.e11.twk.utils.ContextUtils;


/**
 *
 * @author student
 */
@Named(value = "GameSystemController")
@SessionScoped
public class GameSystemController implements Serializable {
    
    @Inject 
    private GameSystemEndpoint gameSystemEndpoint;
    
    private GameSystemDTO selectedGameSystemDTO;
    private GameSystemDTO createGameSystemDTO;

    public GameSystemDTO getSelectedGameSystemDTO() {
        return selectedGameSystemDTO;
    }

    public void setSelectedGameSystemDTO(GameSystemDTO selectedGameSystemDTO ) {
        this.selectedGameSystemDTO = selectedGameSystemDTO;
    }
    
    public GameSystemController() {
    }
    
    public String createGameSystem(GameSystemDTO gameSystemDTO) {
        try {
            createGameSystemDTO = gameSystemDTO;
            gameSystemEndpoint.createGameSystem(createGameSystemDTO);
            createGameSystemDTO  = null;
            return "goToSystems";
        } catch (GameSystemException gse) {
            if (GameSystemException.KEY_DB_CONSTRAINT.equals(gse.getMessage())) {
                ContextUtils.emitInternationalizedMessage("createGameSystem:name", GameSystemException.KEY_DB_CONSTRAINT); 
            } else {
                Logger.getLogger(GameSystemController.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji createGameSystem wyjatku: ", gse);
            }
            return null;
        } catch (AppBaseException abe) {
            Logger.getLogger(GameSystemController.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji createGameSystem wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null, abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            }
            return null;
        }
    }
    
    public String editGameSystem(GameSystemDTO gameSystemDTO) {
        try {
            gameSystemEndpoint.editGameSystem(gameSystemDTO);
            return "goToSystems";
        } catch (GameSystemException gse) {
            if (GameSystemException.KEY_DB_CONSTRAINT.equals(gse.getMessage())) {
                ContextUtils.emitInternationalizedMessage("editGameSystem:name", GameSystemException.KEY_DB_CONSTRAINT); 
            } else {
                Logger.getLogger(GameSystemController.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji editGameSystem wyjatku: ", gse);
            }
            return null;
        } catch (AppBaseException abe) {
            Logger.getLogger(GameSystemController.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji editGameSystem wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null, abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            }
            return null;
        }
    }
    
    public String deleteGameSystem(GameSystemDTO gameSystemDTO) throws AppBaseException {
        try {
            gameSystemEndpoint.deleteGameSystem(gameSystemDTO);
            return "goToSystems";
        } catch (GameSystemException ce) {
            if (GameSystemException.KEY_GAME_SYSTEM_ALREADY_CHANGED.equals(ce.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null, GameSystemException.KEY_GAME_SYSTEM_ALREADY_CHANGED);
            } else if (GameSystemException.KEY_GAME_SYSTEM_NOT_FOUND.equals(ce.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null, GameSystemException.KEY_GAME_SYSTEM_NOT_FOUND);
            } else if (GameSystemException.KEY_GAME_SYSTEM_OPTIMISTIC_LOCK.equals(ce.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null, GameSystemException.KEY_GAME_SYSTEM_OPTIMISTIC_LOCK);
            } else {
                Logger.getLogger(GameSystemController.class.getName()).log(Level.SEVERE,
                        "Zgłoszenie w metodzie akcji deleteGameSystem wyjatku: ", ce);
            }
            return null;
        } catch (AppBaseException abe) {
            Logger.getLogger(GameSystemController.class.getName()).log(Level.SEVERE,
                    "Zgłoszenie w metodzie akcji deleteGameSystem wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null, abe.getMessage());
            }
            return null;
        }
    }    
    
}
