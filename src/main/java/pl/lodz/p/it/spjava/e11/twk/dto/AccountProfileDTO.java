/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.dto;

import java.util.List;
import java.util.Objects;
import pl.lodz.p.it.spjava.e11.twk.model.AccountData;
import pl.lodz.p.it.spjava.e11.twk.model.Administrator;
import pl.lodz.p.it.spjava.e11.twk.model.Organizator;
import pl.lodz.p.it.spjava.e11.twk.model.Player;
import pl.lodz.p.it.spjava.e11.twk.model.Tournament;

/**
 *
 * @author Adam
 */
public class AccountProfileDTO {
    
    private Long id;
    private Boolean active;
    private String login;
    private List<Tournament> tournamentList;
    private Administrator administrator;
    private Player player;
    private Organizator organizator;
    private AccountData accountData;

    public AccountProfileDTO(Long id, Boolean active, String login, List<Tournament> tournamentList, Administrator administrator, Player player, Organizator organizator, AccountData accountData) {
        this.id = id;
        this.active = active;
        this.login = login;
        this.tournamentList = tournamentList;
        this.administrator = administrator;
        this.player = player;
        this.organizator = organizator;
        this.accountData = accountData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Tournament> getTournamentList() {
        return tournamentList;
    }

    public void setTournamentList(List<Tournament> tournamentList) {
        this.tournamentList = tournamentList;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public AccountData getAccountData() {
        return accountData;
    }

    public void setAccountData(AccountData accountData) {
        this.accountData = accountData;
    }

    public Organizator getOrganizator() {
        return organizator;
    }

    public void setOrganizator(Organizator organizator) {
        this.organizator = organizator;
    }

    public boolean isAdmin(){
        return Objects.nonNull(getAdministrator());
    }
    
    public boolean isPlayer(){
        return Objects.nonNull(getPlayer());
    }
    
    public boolean isOgranizator(){
        return Objects.nonNull(getOrganizator());
    } 
}
