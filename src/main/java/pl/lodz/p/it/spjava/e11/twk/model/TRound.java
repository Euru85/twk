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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Adam
 */
@Entity
@Table(name = "T_ROUND")
@NamedQueries({
    @NamedQuery(name = "TRound.findAll", query = "SELECT t FROM TRound t"),
    @NamedQuery(name = "TRound.findById", query = "SELECT t FROM TRound t WHERE t.id = :id"),
    @NamedQuery(name = "TRound.findByClosed", query = "SELECT t FROM TRound t WHERE t.closed = :closed"),
    @NamedQuery(name = "TRound.findByVer", query = "SELECT t FROM TRound t WHERE t.ver = :ver"),
    @NamedQuery(name = "TRound.findByRoundNumber", query = "SELECT t FROM TRound t WHERE t.roundNumber = :roundNumber")})
public class TRound implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CLOSED")
    private Short closed;
    @Column(name = "VER")
    @Version
    private Long ver;
    @Column(name = "ROUND_NUMBER")
    private BigInteger roundNumber;
    @OneToMany(mappedBy = "roundId")
    private List<TGame> tGameList;
    @JoinColumn(name = "TOURNAMENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Tournament tournamentId;

    public TRound() {
    }

    public TRound(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getClosed() {
        return closed;
    }

    public void setClosed(Short closed) {
        this.closed = closed;
    }

    public BigInteger getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(BigInteger roundNumber) {
        this.roundNumber = roundNumber;
    }

    public List<TGame> getTGameList() {
        return tGameList;
    }

    public void setTGameList(List<TGame> tGameList) {
        this.tGameList = tGameList;
    }

    public Tournament getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Tournament tournamentId) {
        this.tournamentId = tournamentId;
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
        if (!(object instanceof TRound)) {
            return false;
        }
        TRound other = (TRound) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.e11.twk.model.TRound[ id=" + id + " ]";
    }
    
}
