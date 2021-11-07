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
import pl.lodz.p.it.spjava.e11.twk.dto.LeagueDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.LeagueEndpoint;




@Named(value = "showGameSystemDetailsPageBean")
@RequestScoped
public class ShowSystemDetailsPageBean {

    @EJB
    private LeagueEndpoint leagueEndpoint;  
    private GameSystemDTO gameSystemDTO; 
    private List<LeagueDTO> listLeagueDTO;

    @Inject
    private GameSystemController gameSystemController;
    

    public ShowSystemDetailsPageBean() {
    }

    public GameSystemDTO getGameSystemDTO() {
        gameSystemDTO = gameSystemController.getSelectedGameSystemDTO();
        return gameSystemDTO;
    }


    public List<LeagueDTO> listLeaguesDTO(){
        listLeagueDTO = leagueEndpoint.listLeaguesByGameSystemDTO(gameSystemController.getSelectedGameSystemDTO());
        return listLeagueDTO;
    }
    
    @PostConstruct
    private void init(){
        gameSystemDTO = gameSystemController.getSelectedGameSystemDTO();
        listLeagueDTO = leagueEndpoint.listLeaguesByGameSystemDTO(gameSystemDTO);
    }
}
