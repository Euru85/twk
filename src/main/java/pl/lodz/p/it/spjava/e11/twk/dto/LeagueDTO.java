/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.dto;

/**
 *
 * @author Adam
 */
public class LeagueDTO {

    private Long id;
    private String leagueName;

    public LeagueDTO() {
    }
    
    public LeagueDTO(Long id, String leagueName) {
        this.id = id;
        this.leagueName = leagueName;
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

}
