/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.gamesystem;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.GameSystemDTO;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;



@Named(value = "editGameSystemPageBean")
@RequestScoped
public class EditGameSystemPagePean {
    

    private GameSystemDTO gameSystemDTO;
    
    @Inject
    private GameSystemController gameSystemController;

    public EditGameSystemPagePean() {
    }
    
    public GameSystemDTO getGameSystemDTO() {
        gameSystemDTO = gameSystemController.getSelectedGameSystemDTO();
        return gameSystemDTO;
    }
    
    public String saveGameSystem(boolean decision)throws AppBaseException{
        if (decision) return gameSystemController.editGameSystem(gameSystemDTO);
        return "goToSystems";
    }
    
}
