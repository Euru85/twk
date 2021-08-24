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
public class AccountDTO {

    private Long id;
    private String login;
    private Boolean active;

    public AccountDTO() {
    }
    
    public AccountDTO(Long id, String login, Boolean active) {
        this.id = id;
        this.login = login;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
