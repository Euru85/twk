/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Adam
 */
public class GameSystemDTO {

    private Long id;
    @NotNull(message="{javax.validation.constraints.NotNull.message}")
    @Size(min=3,max=32,message="{constraint.string.length.notinrange}")
    private String gameSystemName;

    public GameSystemDTO() {
    }
    
    public GameSystemDTO(Long id, String systemName) {
        this.id = id;
        this.gameSystemName = systemName;
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

}
