/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.league;


import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.GameSystemDTO;
import pl.lodz.p.it.spjava.e11.twk.dto.LeagueDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.GameSystemEndpoint;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.GameSystemFacade;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;


@Named(value = "addLeaguePageBean")
@RequestScoped
public class AddLeaguePagePean {
    
    private LeagueDTO leagueDTO = new LeagueDTO();
    
    @Inject
    private LeagueController leagueController;
    @Inject
    private GameSystemEndpoint gameSystemEndpoint;
    
    @EJB
    private GameSystemFacade gameSystemFacade;
    
    private GameSystemDTO gameSystemDTO;
    private List<GameSystemDTO> listGameSystemDTO;

    
    @PostConstruct
    private void init() {
        listGameSystemDTO = gameSystemEndpoint.listAllGameSystems();
    }   

    public List<GameSystemDTO> getListGameSystemDTO() {
        return listGameSystemDTO;
    }

    public void setListGameSystemDTO(List<GameSystemDTO> listGameSystemDTO) {
        this.listGameSystemDTO = listGameSystemDTO;
    }

    public GameSystemDTO getGameSystemDTO() {
        return gameSystemDTO;
    }

    public void setGameSystemDTO(GameSystemDTO gameSystemDTO) {
        this.gameSystemDTO = gameSystemDTO;
    }


    public AddLeaguePagePean() {
    }

    public LeagueDTO getLeagueDTO() {
        return leagueDTO;
    }
    
    public String createLeague(boolean decision)throws AppBaseException{
        if (decision) return leagueController.createLeague(leagueDTO, gameSystemDTO);
        return "goToLeagues";
    }
    
}
