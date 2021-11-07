/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.gamesystem;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.GameSystemDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.GameSystemEndpoint;
import pl.lodz.p.it.spjava.e11.twk.model.GameSystem;



@Named(value = "listGameSystemPageBean")
@RequestScoped
public class ListGameSystemPageBean {

    @EJB
    private GameSystemEndpoint gameSystemEndpoint;
    private List<GameSystemDTO> listGameSystemDTO;
    @Inject
    private GameSystemController gameSystemController;
    
    public ListGameSystemPageBean() {
    }

    public List<GameSystemDTO> getListGameSystemDTO() {
        return listGameSystemDTO;
    }

    public String editGameSystemAction(GameSystemDTO gameSystemDTO){
        gameSystemController.setSelectedGameSystemDTO(gameSystemDTO);
        return "goToEditGameSystem";
    }
    
    public String deleteGameSystemAction(GameSystemDTO gameSystemDTO){
        gameSystemController.setSelectedGameSystemDTO(gameSystemDTO);
        return "goToDeleteGameSystem";
    }
    
    public String createGameSystemAction(){
        return "goToAddGameSystem";
    }
    
    public String showGameSystemDetailsAction(GameSystemDTO gameSystemDTO){
        gameSystemController.setSelectedGameSystemDTO(gameSystemDTO);
        return "goToSystemDetails";
    }
    
    public String showGameSystemDetailsAction(GameSystem gameSystem){
        gameSystemController.setSelectedGameSystemDTO(new GameSystemDTO(gameSystem.getId(), gameSystem.getSystemName(),gameSystem.getTournamentList(),gameSystem.getLeagueList()));
        return "goToSystemDetails";
    }
    
    
    
    @PostConstruct
    private void init(){
        listGameSystemDTO = gameSystemEndpoint.listAllGameSystems();
    }
    
}
