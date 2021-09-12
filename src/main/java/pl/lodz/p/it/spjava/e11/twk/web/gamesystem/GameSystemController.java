/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Accounts | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import pl.lodz.p.it.spjava.e11.twk.dto.LeagueDTO;


/**
 *
 * @author student
 */
@Named(value = "LeagueController")
@SessionScoped
public class LeagueController implements Serializable {

    private LeagueDTO selectedLeagueDTO;

    public LeagueDTO getSelectedLeagueDTO() {
        return selectedLeagueDTO;
    }

    public void setSelectedLeagueDTO(LeagueDTO selectedLeagueDTO ) {
        this.selectedLeagueDTO = selectedLeagueDTO;
    }
    
    /**
     * Creates a new instance of AccountController
     */
    public LeagueController() {
    }
    
    
}
