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
public class ArmyDTO {

    private Long id;
    private String armyName;


    public ArmyDTO() {
    }

    public ArmyDTO(Long id, String armyName) {
        this.id = id;
        this.armyName = armyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArmyName() {
        return armyName;
    }

    public void setArmyName(String armyName) {
        this.armyName = armyName;
    }
    
}
