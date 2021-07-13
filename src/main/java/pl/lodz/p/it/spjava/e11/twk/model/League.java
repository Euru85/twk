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
import javax.validation.constraints.Size;

/**
 *
 * @author Adam
 */
@Entity
@Table(name = "LEAGUE")
@NamedQueries({
    @NamedQuery(name = "League.findAll", query = "SELECT l FROM League l"),
    @NamedQuery(name = "League.findById", query = "SELECT l FROM League l WHERE l.id = :id"),
    @NamedQuery(name = "League.findByLeagueName", query = "SELECT l FROM League l WHERE l.leagueName = :leagueName"),
    @NamedQuery(name = "League.findByVer", query = "SELECT l FROM League l WHERE l.ver = :ver")})
public class League implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 50)
    @Column(name = "league_name")
    private String leagueName;
    @Column(name = "ver")
    private BigInteger ver;
    @OneToMany(mappedBy = "leagueId")
    private List<Tournament> tournamentList;
    @JoinColumn(name = "game_system_id", referencedColumnName = "id")
    @ManyToOne
    private GameSystem gameSystemId;

    public League() {
    }

    public League(Long id) {
        this.id = id;
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

    public GameSystem getGameSystemId() {
        return gameSystemId;
    }

    public void setGameSystemId(GameSystem gameSystemId) {
        this.gameSystemId = gameSystemId;
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
        if (!(object instanceof League)) {
            return false;
        }
        League other = (League) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.e11.twk.model.League[ id=" + id + " ]";
    }
    
}
