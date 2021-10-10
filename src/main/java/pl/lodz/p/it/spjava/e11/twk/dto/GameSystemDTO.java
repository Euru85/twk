/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import pl.lodz.p.it.spjava.e11.twk.model.League;
import pl.lodz.p.it.spjava.e11.twk.model.Tournament;

/**
 *
 * @author Adam
 */
public class GameSystemDTO {

    private Long id;
    @NotNull(message="{javax.validation.constraints.NotNull.message}")
    @Size(min=3,max=32,message="{constraint.string.length.notinrange}")
    private String gameSystemName;
    private List<Tournament> tournamentList;  
    private List<League> leagueList;

    public GameSystemDTO() {
    }

    public GameSystemDTO(Long id, String gameSystemName, List<Tournament> tournamentList, List<League> leagueList) {
        this.id = id;
        this.gameSystemName = gameSystemName;
        this.tournamentList = tournamentList;
        this.leagueList = leagueList;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameSystemName() {
        return gameSystemName;
    }

    public void setGameSystemName(String gameSystemName) {
        this.gameSystemName = gameSystemName;
    }

    public List<Tournament> getTournamentList() {
        return tournamentList;
    }

    public List<League> getLeagueList() {
        return leagueList;
    }
    
    public boolean isRemovable(){
        if (!getLeagueList().isEmpty()) return false;
        return getTournamentList().isEmpty();
    }
    
}
