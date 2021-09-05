/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.dto;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    private List<Administrator> administratorList;
    private List<Player> playerList;
    private List<Organizator> organizatorList;
    private List<AccountData> accountDataList;

    public AccountProfileDTO(Long id, Boolean active, String login, List<Tournament> tournamentList, List<Administrator> administratorList, List<Player> playerList, List<Organizator> organizatorList, List<AccountData> accountDataList) {
        this.id = id;
        this.active = active;
        this.login = login;
        this.tournamentList = tournamentList;
        this.administratorList = administratorList;
        this.playerList = playerList;
        this.organizatorList = organizatorList;
        this.accountDataList = accountDataList;
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

    public List<Administrator> getAdministratorList() {
        return administratorList;
    }

    public void setAdministratorList(List<Administrator> administratorList) {
        this.administratorList = administratorList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Organizator> getOrganizatorList() {
        return organizatorList;
    }

    public void setOrganizatorList(List<Organizator> organizatorList) {
        this.organizatorList = organizatorList;
    }

    public List<AccountData> getAccountDataList() {
        return accountDataList;
    }

    public void setAccountDataList(List<AccountData> accountDataList) {
        this.accountDataList = accountDataList;
    }

    public boolean isAdmin(){
        return Objects.nonNull(getAdministratorList());
    }
    
    public boolean isPlayer(){
        return Objects.nonNull(getPlayerList());
    }
    
    public boolean isOgranizator(){
        return Objects.nonNull(getOrganizatorList());
    } 
}
