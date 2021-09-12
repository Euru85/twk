/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.tournament;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.TournamentDTO;




@Named(value = "showTournamentDetailsPageBean")
@RequestScoped
public class ShowTournamentDetailsPageBean {

    private TournamentDTO TournamentDTO; 

    @Inject
    private TournamentController TournamentController;
    

    public ShowTournamentDetailsPageBean() {
    }

    public TournamentDTO getTournamentDTO() {
        TournamentDTO = TournamentController.getSelectedTournamentDTO();
        return TournamentDTO;
    }

    @PostConstruct
    private void init(){
        TournamentDTO = TournamentController.getSelectedTournamentDTO();
    }
}
