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
    
    /**
     * Creates a new instance of AccountController
     */
    public GameSystemController() {
    }
    
    public String createGameSystem(GameSystemDTO gameSystemDTO) {
        try {
            createGameSystemDTO = gameSystemDTO;
            gameSystemEndpoint.createGameSystem(createGameSystemDTO);
            createGameSystemDTO  = null;
            return "success";
        } catch (GameSystemException ke) {
            if (GameSystemException.KEY_DB_CONSTRAINT.equals(ke.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null, GameSystemException.KEY_DB_CONSTRAINT); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            } else {
                Logger.getLogger(GameSystemController.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzPracownika wyjatku: ", ke);
            }
            return null;
        } catch (AppBaseException abe) {
            Logger.getLogger(GameSystemController.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzPracownika wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null, abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            }
            return null;
        }
    }
    
    
    
}
