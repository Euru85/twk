/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.dto;
import pl.lodz.p.it.spjava.e11.twk.model.Account;

/**
 *
 * @author Adam
 */
public class PlayerDTO {
    private Long id;
    private String nick;
    private String gameClub;
    private Account accountId;

    public PlayerDTO() {
    }

    public PlayerDTO(Long id, String nick, String gameClub, Account accountId) {
        this.id = id;
        this.nick = nick;
        this.gameClub = gameClub;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getGameClub() {
        return gameClub;
    }

    public void setGameClub(String gameClub) {
        this.gameClub = gameClub;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }
    
    
    
}
