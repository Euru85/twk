/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.tournament;

import pl.lodz.p.it.spjava.e11.twk.web.tournament.TournamentController;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.TournamentDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.TournamentEndpoint;


@Named(value = "listTournamentPageBean")
@RequestScoped
public class ListTournamentsPageBean {

    @EJB
    private TournamentEndpoint tournamentEndpoint;
    private List<TournamentDTO> listTournamentDTO;
    @Inject
    private TournamentController tournamentController;
    
    public ListTournamentsPageBean() {
    }

    public List<TournamentDTO> getListTournamentDTO() {
        return listTournamentDTO;
    }

    public void setListTournamentDTO(List<TournamentDTO> listtTournamentDTO) {
        this.listTournamentDTO = listtTournamentDTO;
    }
    
    public String showTournamentDetailsAction(TournamentDTO tournamentDTO){
        tournamentController.setSelectedTournamentDTO(tournamentDTO);
        return "goToTournamentDetails";
    }
    
    
    @PostConstruct
    private void init(){
        listTournamentDTO = tournamentEndpoint.listAllTournaments();
    }
    
}
