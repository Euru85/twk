/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Adam
 */
@Entity
@Table(name = "TOURNAMENT")
@NamedQueries({
    @NamedQuery(name = "Tournament.findAll", query = "SELECT t FROM Tournament t"),
    @NamedQuery(name = "Tournament.findById", query = "SELECT t FROM Tournament t WHERE t.id = :id"),
    @NamedQuery(name = "Tournament.findByClosed", query = "SELECT t FROM Tournament t WHERE t.closed = :closed"),
    @NamedQuery(name = "Tournament.findByCurrentRound", query = "SELECT t FROM Tournament t WHERE t.currentRound = :currentRound"),
    @NamedQuery(name = "Tournament.findByDescription", query = "SELECT t FROM Tournament t WHERE t.description = :description"),
    @NamedQuery(name = "Tournament.findByRounds", query = "SELECT t FROM Tournament t WHERE t.rounds = :rounds"),
    @NamedQuery(name = "Tournament.findByTournamentName", query = "SELECT t FROM Tournament t WHERE t.tournamentName = :tournamentName"),
    @NamedQuery(name = "Tournament.findByVer", query = "SELECT t FROM Tournament t WHERE t.ver = :ver")})
public class Tournament implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CLOSED")
    private Boolean closed;
    @Column(name = "T_DATE")
    @Temporal(TemporalType.DATE)
    private Date tDate;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "CURRENT_ROUND")
    private Integer currentRound;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ROUNDS")
    private Integer rounds;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TOURNAMENT_NAME")
    private String tournamentName;
    @Column(name = "VER")
    private BigInteger ver;
    @JoinColumn(name = "LAST_MODIFIED_BY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Account lastModifiedById;
    @JoinColumn(name = "GAME_SYSTEM_ID", referencedColumnName = "ID")
    @ManyToOne
    private GameSystem gameSystemId;
    @JoinColumn(name = "LEAGUE_ID", referencedColumnName = "ID")
    @ManyToOne
    private League leagueId;
    @JoinColumn(name = "ORGANIZATOR_ID", referencedColumnName = "ID")
    @ManyToOne
    private Organizator organizatorId;
    @OneToMany(mappedBy = "tournamentId")
    private List<TRound> tRoundList;
    @OneToMany(mappedBy = "tournamentId")
    private List<TParticipant> tParticipantList;

    public Tournament() {
    }

    public Tournament(Long id) {
        this.id = id;
    }

    public Tournament(Long id, Boolean closed, String tournamentName) {
        this.id = id;
        this.closed = closed;
        this.tournamentName = tournamentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(Integer currentRound) {
        this.currentRound = currentRound;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRounds() {
        return rounds;
    }

    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public BigInteger getVer() {
        return ver;
    }

    public void setVer(BigInteger ver) {
        this.ver = ver;
    }

    public Account getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(Account lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public GameSystem getGameSystemId() {
        return gameSystemId;
    }

    public void setGameSystemId(GameSystem gameSystemId) {
        this.gameSystemId = gameSystemId;
    }

    public League getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(League leagueId) {
        this.leagueId = leagueId;
    }

    public Organizator getOrganizatorId() {
        return organizatorId;
    }

    public void setOrganizatorId(Organizator organizatorId) {
        this.organizatorId = organizatorId;
    }

    public List<TRound> getTRoundList() {
        return tRoundList;
    }

    public void setTRoundList(List<TRound> tRoundList) {
        this.tRoundList = tRoundList;
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
        if (!(object instanceof Tournament)) {
            return false;
        }
        Tournament other = (Tournament) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.e11.twk.model.Tournament[ id=" + id + " ]";
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Date getTDate() {
        return tDate;
    }

    public void setTDate(Date tDate) {
        this.tDate = tDate;
    }
    
}
