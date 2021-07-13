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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Adam
 */
@Entity
@Table(name = "T_PARTICIPANT")
@NamedQueries({
    @NamedQuery(name = "TParticipant.findAll", query = "SELECT t FROM TParticipant t"),
    @NamedQuery(name = "TParticipant.findById", query = "SELECT t FROM TParticipant t WHERE t.id = :id"),
    @NamedQuery(name = "TParticipant.findByVer", query = "SELECT t FROM TParticipant t WHERE t.ver = :ver")})
public class TParticipant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "ver")
    private BigInteger ver;
    @OneToMany(mappedBy = "participantId")
    private List<Tournament> tournamentList;
    @OneToMany(mappedBy = "playerA")
    private List<TGame> tGameList;
    @OneToMany(mappedBy = "playerB")
    private List<TGame> tGameList1;
    @JoinColumn(name = "army_id", referencedColumnName = "id")
    @ManyToOne
    private Army armyId;
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    @ManyToOne
    private Player playerId;
    @JoinColumn(name = "tournament_id", referencedColumnName = "id")
    @ManyToOne
    private Tournament tournamentId;
    @OneToMany(mappedBy = "participantId")
    private List<TExtraPoints> tExtraPointsList;

    public TParticipant() {
    }

    public TParticipant(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getVer() {
        return ver;
    }

    public void setVer(BigInteger ver) {
        this.ver = ver;
    }

    public List<Tournament> getTournamentList() {
        return tournamentList;
    }

    public void setTournamentList(List<Tournament> tournamentList) {
        this.tournamentList = tournamentList;
    }

    public List<TGame> getTGameList() {
        return tGameList;
    }

    public void setTGameList(List<TGame> tGameList) {
        this.tGameList = tGameList;
    }

    public List<TGame> getTGameList1() {
        return tGameList1;
    }

    public void setTGameList1(List<TGame> tGameList1) {
        this.tGameList1 = tGameList1;
    }

    public Army getArmyId() {
        return armyId;
    }

    public void setArmyId(Army armyId) {
        this.armyId = armyId;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    public Tournament getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Tournament tournamentId) {
        this.tournamentId = tournamentId;
    }

    public List<TExtraPoints> getTExtraPointsList() {
        return tExtraPointsList;
    }

    public void setTExtraPointsList(List<TExtraPoints> tExtraPointsList) {
        this.tExtraPointsList = tExtraPointsList;
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
        if (!(object instanceof TParticipant)) {
            return false;
        }
        TParticipant other = (TParticipant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.e11.twk.model.TParticipant[ id=" + id + " ]";
    }
    
}
