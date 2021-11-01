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



@Named(value = "deleteGameSystemPageBean")
@RequestScoped
public class DeleteGameSystemPagePean {
    
    @EJB
    private GameSystemEndpoint gameSystemEndpoint;
    private GameSystemDTO gameSystemDTO;
    
    @Inject
    private GameSystemController gameSystemController;

    public DeleteGameSystemPagePean() {
    }
    
    public GameSystemDTO getGameSystemDTO() {
        gameSystemDTO = gameSystemController.getSelectedGameSystemDTO();
        return gameSystemDTO;
    }
    
    public String deleteGameSystem(boolean decision)throws AppBaseException{
        if (decision)gameSystemController.deleteGameSystem(gameSystemDTO);
        return "goToSystems";
    }
    
    @PostConstruct
    private void init(){
        gameSystemDTO = gameSystemController.getSelectedGameSystemDTO();
    }
}
