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
    @NamedQuery(name = "Tournament.findByVer", query = "SELECT t FROM Tournament t WHERE t.ver = :ver"),
    @NamedQuery(name = "Tournament.findByDescription", query = "SELECT t FROM Tournament t WHERE t.description = :description"),
    @NamedQuery(name = "Tournament.findByClosed", query = "SELECT t FROM Tournament t WHERE t.closed = :closed"),
    @NamedQuery(name = "Tournament.findByRounds", query = "SELECT t FROM Tournament t WHERE t.rounds = :rounds"),
    @NamedQuery(name = "Tournament.findByCurrentRound", query = "SELECT t FROM Tournament t WHERE t.currentRound = :currentRound")})
public class Tournament implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "ver")
    @Version
    private Long ver;
    @Size(max = 2000)
    @Column(name = "tournament_name",nullable = false, updatable = true)
    private String tournamentName;
    @Size(max = 2000)
    @Column(name = "description")
    private String description;
    @Column(name = "closed",nullable = false, updatable = true)
    private Boolean closed;
    @Column(name = "rounds")
    private Integer rounds;
    @Column(name = "current_round")
    private Integer currentRound;
    @JoinColumn(name = "last_modified_by_id", referencedColumnName = "id")
    @ManyToOne
    private Account lastModifiedById;
    @JoinColumn(name = "game_system_id", referencedColumnName = "id")
    @ManyToOne
    private GameSystem gameSystemId;
    @JoinColumn(name = "league_id", referencedColumnName = "id")
    @ManyToOne
    private League leagueId;
    @JoinColumn(name = "organizator_id", referencedColumnName = "id")
    @ManyToOne
    private Organizator organizatorId;
    @JoinColumn(name = "participant_id", referencedColumnName = "id")
    @ManyToOne
    private TParticipant participantId;
    @OneToMany(mappedBy = "tournamentId")
    private List<TParticipant> tParticipantList;

    public Tournament() {
    }

    public Tournament(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVer() {
        return ver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Integer getRounds() {
        return rounds;
    }

    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    public Integer getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(Integer currentRound) {
        this.currentRound = currentRound;
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

    public TParticipant getParticipantId() {
        return participantId;
    }

    public void setParticipantId(TParticipant participantId) {
        this.participantId = participantId;
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
    
}
