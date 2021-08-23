/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.dto;

import pl.lodz.p.it.spjava.e11.twk.model.GameSystem;

/**
 *
 * @author Adam
 */
public class LeagueDTO {

    private Long id;
    private String leagueName;
    private GameSystem gameSystemId;

    public LeagueDTO() {
    }
    
    public LeagueDTO(Long id, String leagueName, GameSystem gameSystemId) {
        this.id = id;
        this.leagueName = leagueName;
        this.gameSystemId = gameSystemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
    
    public GameSystem getGameSystemId() {
        return gameSystemId;
    }

    public void setGameSystem(GameSystem gameSystemId) {
        this.gameSystemId = gameSystemId;
    }

}
