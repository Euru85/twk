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
@Table(name = "T_GAME")
@NamedQueries({
    @NamedQuery(name = "TGame.findAll", query = "SELECT t FROM TGame t"),
    @NamedQuery(name = "TGame.findById", query = "SELECT t FROM TGame t WHERE t.id = :id"),
    @NamedQuery(name = "TGame.findByVer", query = "SELECT t FROM TGame t WHERE t.ver = :ver"),
    @NamedQuery(name = "TGame.findByScoreAbig", query = "SELECT t FROM TGame t WHERE t.scoreAbig = :scoreAbig"),
    @NamedQuery(name = "TGame.findByScoreAsmall", query = "SELECT t FROM TGame t WHERE t.scoreAsmall = :scoreAsmall"),
    @NamedQuery(name = "TGame.findByScoreBbig", query = "SELECT t FROM TGame t WHERE t.scoreBbig = :scoreBbig"),
    @NamedQuery(name = "TGame.findByScoreBsmall", query = "SELECT t FROM TGame t WHERE t.scoreBsmall = :scoreBsmall"),
    @NamedQuery(name = "TGame.findByPenatlyA", query = "SELECT t FROM TGame t WHERE t.penatlyA = :penatlyA"),
    @NamedQuery(name = "TGame.findByPenaltyB", query = "SELECT t FROM TGame t WHERE t.penaltyB = :penaltyB")})
public class TGame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "ver")
    private BigInteger ver;
    @Column(name = "score_A_big")
    private Integer scoreAbig;
    @Column(name = "score_A_small")
    private Integer scoreAsmall;
    @Column(name = "score_B_big")
    private Integer scoreBbig;
    @Column(name = "score_B_small")
    private Integer scoreBsmall;
    @Column(name = "penatly_A")
    private Integer penatlyA;
    @Column(name = "penalty_B")
    private Integer penaltyB;
    @JoinColumn(name = "playerA", referencedColumnName = "id")
    @ManyToOne
    private TParticipant playerA;
    @JoinColumn(name = "playerB", referencedColumnName = "id")
    @ManyToOne
    private TParticipant playerB;
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    @ManyToOne
    private TRound roundId;
    @OneToMany(mappedBy = "gameId")
    private List<TRound> tRoundList;

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

    public BigInteger getVer() {
        return ver;
    }

    public void setVer(BigInteger ver) {
        this.ver = ver;
    }

    public Integer getScoreAbig() {
        return scoreAbig;
    }

    public void setScoreAbig(Integer scoreAbig) {
        this.scoreAbig = scoreAbig;
    }

    public Integer getScoreAsmall() {
        return scoreAsmall;
    }

    public void setScoreAsmall(Integer scoreAsmall) {
        this.scoreAsmall = scoreAsmall;
    }

    public Integer getScoreBbig() {
        return scoreBbig;
    }

    public void setScoreBbig(Integer scoreBbig) {
        this.scoreBbig = scoreBbig;
    }

    public Integer getScoreBsmall() {
        return scoreBsmall;
    }

    public void setScoreBsmall(Integer scoreBsmall) {
        this.scoreBsmall = scoreBsmall;
    }

    public Integer getPenatlyA() {
        return penatlyA;
    }

    public void setPenatlyA(Integer penatlyA) {
        this.penatlyA = penatlyA;
    }

    public Integer getPenaltyB() {
        return penaltyB;
    }

    public void setPenaltyB(Integer penaltyB) {
        this.penaltyB = penaltyB;
    }

    public TParticipant getPlayerA() {
        return playerA;
    }

    public void setPlayerA(TParticipant playerA) {
        this.playerA = playerA;
    }

    public TParticipant getPlayerB() {
        return playerB;
    }

    public void setPlayerB(TParticipant playerB) {
        this.playerB = playerB;
    }

    public TRound getRoundId() {
        return roundId;
    }

    public void setRoundId(TRound roundId) {
        this.roundId = roundId;
    }

    public List<TRound> getTRoundList() {
        return tRoundList;
    }

    public void setTRoundList(List<TRound> tRoundList) {
        this.tRoundList = tRoundList;
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
