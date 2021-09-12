/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Accounts | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.gamesystem;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import pl.lodz.p.it.spjava.e11.twk.dto.GameSystemDTO;


/**
 *
 * @author student
 */
@Named(value = "GameSystemController")
@SessionScoped
public class GameSystemController implements Serializable {

    private GameSystemDTO selectedGameSystemDTO;

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
    
    
    
    
}
