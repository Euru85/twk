/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Accounts | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.tournament;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import pl.lodz.p.it.spjava.e11.twk.dto.TournamentDTO;


/**
 *
 * @author student
 */
@Named(value = "tournamentController")
@SessionScoped
public class TournamentController implements Serializable {

    private TournamentDTO selectedTournamentDTO;

    public TournamentDTO getSelectedTournamentDTO() {
        return selectedTournamentDTO;
    }

    public void setSelectedTournamentDTO(TournamentDTO selectedTournamentDTO ) {
        this.selectedTournamentDTO = selectedTournamentDTO;
    }
    
    /**
     * Creates a new instance of AccountController
     */
    public TournamentController() {
    }
    
    
}
