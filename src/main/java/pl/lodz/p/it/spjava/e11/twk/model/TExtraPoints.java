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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "T_EXTRA_POINTS")
@NamedQueries({
    @NamedQuery(name = "TExtraPoints.findAll", query = "SELECT t FROM TExtraPoints t"),
    @NamedQuery(name = "TExtraPoints.findById", query = "SELECT t FROM TExtraPoints t WHERE t.id = :id"),
    @NamedQuery(name = "TExtraPoints.findByVer", query = "SELECT t FROM TExtraPoints t WHERE t.ver = :ver")})
public class TExtraPoints implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "VER")
    @Version
    private Long ver;
    @JoinColumn(name = "PARTICIPANT_ID", referencedColumnName = "ID")
    @ManyToOne
    private TParticipant participantId;

    public TExtraPoints() {
    }

    public TExtraPoints(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TParticipant getParticipantId() {
        return participantId;
    }

    public void setParticipantId(TParticipant participantId) {
        this.participantId = participantId;
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
        if (!(object instanceof TExtraPoints)) {
            return false;
        }
        TExtraPoints other = (TExtraPoints) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.e11.twk.model.TExtraPoints[ id=" + id + " ]";
    }
    
}
