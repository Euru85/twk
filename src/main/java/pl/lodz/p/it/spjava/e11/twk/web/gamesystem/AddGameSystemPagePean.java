/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.gamesystem;


import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.GameSystemDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.GameSystemEndpoint;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;


@Named(value = "addGameSystemPageBean")
@RequestScoped
public class AddGameSystemPagePean {
    
    private GameSystemDTO gameSystemDTO = new GameSystemDTO();
    
    @Inject
    private GameSystemController gameSystemController;

    public AddGameSystemPagePean() {
    }
    
    public GameSystemDTO getGameSystemDTO() {
        return gameSystemDTO;
    }
    
    public String createGameSystem(boolean decision)throws AppBaseException{
        if (decision) return gameSystemController.createGameSystem(gameSystemDTO);
        return "goToSystems";
    }
}
