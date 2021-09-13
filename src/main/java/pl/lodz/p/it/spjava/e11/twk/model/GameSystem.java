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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Adam
 */
@Entity
@Table(name = "GAME_SYSTEM")
@NamedQueries({
    @NamedQuery(name = "GameSystem.findAll", query = "SELECT g FROM GameSystem g"),
    @NamedQuery(name = "GameSystem.findById", query = "SELECT g FROM GameSystem g WHERE g.id = :id"),
    @NamedQuery(name = "GameSystem.findBySystemName", query = "SELECT g FROM GameSystem g WHERE g.systemName = :systemName"),
    @NamedQuery(name = "GameSystem.findByVer", query = "SELECT g FROM GameSystem g WHERE g.ver = :ver")})
public class GameSystem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SYSTEM_NAME")
    private String systemName;
    @Column(name = "VER")
    @Version
    private Long ver;
    @OneToMany(mappedBy = "gameSystemId")
    private List<Tournament> tournamentList;
    @OneToMany(mappedBy = "gameSystemId")
    private List<League> leagueList;

    public GameSystem() {
    }

    public GameSystem(Long id) {
        this.id = id;
    }

    public GameSystem(Long id, String systemName) {
        this.id = id;
        this.systemName = systemName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public List<Tournament> getTournamentList() {
        return tournamentList;
    }

    public void setTournamentList(List<Tournament> tournamentList) {
        this.tournamentList = tournamentList;
    }

    public List<League> getLeagueList() {
        return leagueList;
    }

    public void setLeagueList(List<League> leagueList) {
        this.leagueList = leagueList;
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
        if (!(object instanceof GameSystem)) {
            return false;
        }
        GameSystem other = (GameSystem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.e11.twk.model.GameSystem[ id=" + id + " ]";
    }
    
}
