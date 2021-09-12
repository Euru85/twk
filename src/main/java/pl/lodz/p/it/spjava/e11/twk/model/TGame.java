/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Adam
 */
@Entity
@Table(name = "T_GAME")
@NamedQueries({
    @NamedQuery(name = "TGame.findAll", query = "SELECT t FROM TGame t"),
    @NamedQuery(name = "TGame.findById", query = "SELECT t FROM TGame t WHERE t.id = :id"),
    @NamedQuery(name = "TGame.findByPenaltyB", query = "SELECT t FROM TGame t WHERE t.penaltyB = :penaltyB"),
    @NamedQuery(name = "TGame.findByPenatlyA", query = "SELECT t FROM TGame t WHERE t.penatlyA = :penatlyA"),
    @NamedQuery(name = "TGame.findByScoreABig", query = "SELECT t FROM TGame t WHERE t.scoreABig = :scoreABig"),
    @NamedQuery(name = "TGame.findByScoreASmall", query = "SELECT t FROM TGame t WHERE t.scoreASmall = :scoreASmall"),
    @NamedQuery(name = "TGame.findByScoreBBig", query = "SELECT t FROM TGame t WHERE t.scoreBBig = :scoreBBig"),
    @NamedQuery(name = "TGame.findByScoreBSmall", query = "SELECT t FROM TGame t WHERE t.scoreBSmall = :scoreBSmall"),
    @NamedQuery(name = "TGame.findByVer", query = "SELECT t FROM TGame t WHERE t.ver = :ver")})
public class TGame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "PENALTY_B")
    private Integer penaltyB;
    @Column(name = "PENATLY_A")
    private Integer penatlyA;
    @Column(name = "SCORE_A_BIG")
    private Integer scoreABig;
    @Column(name = "SCORE_A_SMALL")
    private Integer scoreASmall;
    @Column(name = "SCORE_B_BIG")
    private Integer scoreBBig;
    @Column(name = "SCORE_B_SMALL")
    private Integer scoreBSmall;
    @Column(name = "VER")
    @Version
    private Long ver;
    @JoinColumn(name = "PLAYERB", referencedColumnName = "ID")
    @ManyToOne
    private TParticipant playerb;
    @JoinColumn(name = "PLAYERA", referencedColumnName = "ID")
    @ManyToOne
    private TParticipant playera;
    @JoinColumn(name = "ROUND_ID", referencedColumnName = "ID")
    @ManyToOne
    private TRound roundId;

    public TGame() {
    }

    public TGame(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPenaltyB() {
        return penaltyB;
    }

    public void setPenaltyB(Integer penaltyB) {
        this.penaltyB = penaltyB;
    }

    public Integer getPenatlyA() {
        return penatlyA;
    }

    public void setPenatlyA(Integer penatlyA) {
        this.penatlyA = penatlyA;
    }

    public Integer getScoreABig() {
        return scoreABig;
    }

    public void setScoreABig(Integer scoreABig) {
        this.scoreABig = scoreABig;
    }

    public Integer getScoreASmall() {
        return scoreASmall;
    }

    public void setScoreASmall(Integer scoreASmall) {
        this.scoreASmall = scoreASmall;
    }

    public Integer getScoreBBig() {
        return scoreBBig;
    }

    public void setScoreBBig(Integer scoreBBig) {
        this.scoreBBig = scoreBBig;
    }

    public Integer getScoreBSmall() {
        return scoreBSmall;
    }

    public void setScoreBSmall(Integer scoreBSmall) {
        this.scoreBSmall = scoreBSmall;
    }


    public TParticipant getPlayerb() {
        return playerb;
    }

    public void setPlayerb(TParticipant playerb) {
        this.playerb = playerb;
    }

    public TParticipant getPlayera() {
        return playera;
    }

    public void setPlayera(TParticipant playera) {
        this.playera = playera;
    }

    public TRound getRoundId() {
        return roundId;
    }

    public void setRoundId(TRound roundId) {
        this.roundId = roundId;
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
        if (!(object instanceof TGame)) {
            return false;
        }
        TGame other = (TGame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.e11.twk.model.TGame[ id=" + id + " ]";
    }
    
}
