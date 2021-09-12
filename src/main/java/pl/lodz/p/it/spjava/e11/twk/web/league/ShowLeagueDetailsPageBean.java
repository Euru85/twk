/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.league;

import pl.lodz.p.it.spjava.e11.twk.web.league.LeagueController;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.LeagueDTO;
import pl.lodz.p.it.spjava.e11.twk.dto.TournamentDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.TournamentEndpoint;




@Named(value = "showLeagueDetailsPageBean")
@RequestScoped
public class ShowLeagueDetailsPageBean {

    @EJB
    private TournamentEndpoint tournamentEndpoint;  
    private LeagueDTO leagueDTO; 
    private List<TournamentDTO> listTournamentDTO;

    @Inject
    private LeagueController leagueController;
    

    public ShowLeagueDetailsPageBean() {
    }

    public LeagueDTO getLeagueDTO() {
        leagueDTO = leagueController.getSelectedLeagueDTO();
        return leagueDTO;
    }


    public List<TournamentDTO> listTournamentsDTO(){
        listTournamentDTO = tournamentEndpoint.listTournamentsByLeagueDTO(leagueController.getSelectedLeagueDTO());
        return listTournamentDTO;
    }
    
    @PostConstruct
    private void init(){
        leagueDTO = leagueController.getSelectedLeagueDTO();
        listTournamentDTO = tournamentEndpoint.listTournamentsByLeagueDTO(leagueDTO);
    }
}
