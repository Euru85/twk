/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Adam
 */
@Entity
@Table(name = "PLAYER")
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findById", query = "SELECT p FROM Player p WHERE p.id = :id"),
    @NamedQuery(name = "Player.findByGameClub", query = "SELECT p FROM Player p WHERE p.gameClub = :gameClub"),
    @NamedQuery(name = "Player.findByNick", query = "SELECT p FROM Player p WHERE p.nick = :nick"),
    @NamedQuery(name = "Player.findByVer", query = "SELECT p FROM Player p WHERE p.ver = :ver")})
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "GAME_CLUB")
    private String gameClub;
    @Size(max = 255)
    @Column(name = "NICK")
    private String nick;
    @Column(name = "VER")
    private BigInteger ver;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    @OneToOne
    private Account accountId;
    @OneToMany(mappedBy = "playerId")
    private List<TParticipant> tParticipantList;

    public Player() {
    }

    public Player(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameClub() {
        return gameClub;
    }

    public void setGameClub(String gameClub) {
        this.gameClub = gameClub;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public BigInteger getVer() {
        return ver;
    }

    public void setVer(BigInteger ver) {
        this.ver = ver;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public List<TParticipant> getTParticipantList() {
        return tParticipantList;
    }

    public void setTParticipantList(List<TParticipant> tParticipantList) {
        this.tParticipantList = tParticipantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.e11.twk.model.Player[ id=" + id + " ]";
    }
    
}
