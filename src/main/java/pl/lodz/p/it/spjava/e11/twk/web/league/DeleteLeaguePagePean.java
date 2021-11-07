/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.league;

import pl.lodz.p.it.spjava.e11.twk.web.gamesystem.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.LeagueDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.LeagueEndpoint;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;



@Named(value = "deleteLeaguePageBean")
@RequestScoped
public class DeleteLeaguePagePean {
    
    @EJB
    private LeagueEndpoint leagueEndpoint;
    private LeagueDTO leagueDTO;
    
    @Inject
    private LeagueController leagueController;

    public DeleteLeaguePagePean() {
    }
    
    public LeagueDTO getLeagueDTO() {
        leagueDTO = leagueController.getSelectedLeagueDTO();
        return leagueDTO;
    }
    
    public String deleteLeague(boolean decision)throws AppBaseException{
        if (decision)return leagueController.deleteLeague(leagueDTO);
        return "goToLeagues";
    }
    
    @PostConstruct
    private void init(){
        leagueDTO = leagueController.getSelectedLeagueDTO();
    }
}
