/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.gamesystem;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.GameSystemDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.GameSystemEndpoint;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;



@Named(value = "editGameSystemPageBean")
@RequestScoped
public class EditGameSystemPagePean {
    
    @EJB
    private GameSystemEndpoint gameSystemEndpoint;
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
        if (decision) gameSystemEndpoint.updateGameSystem(gameSystemDTO);
        return "goToSystems";
    }
    
}
