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
@Table(name = "ARMY")
@NamedQueries({
    @NamedQuery(name = "Army.findAll", query = "SELECT a FROM Army a"),
    @NamedQuery(name = "Army.findById", query = "SELECT a FROM Army a WHERE a.id = :id"),
    @NamedQuery(name = "Army.findByArmyName", query = "SELECT a FROM Army a WHERE a.armyName = :armyName"),
    @NamedQuery(name = "Army.findByVer", query = "SELECT a FROM Army a WHERE a.ver = :ver")})
public class Army implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ARMY_NAME")
    private String armyName;
    @Column(name = "VER")
    @Version
    private Long ver;
    @OneToMany(mappedBy = "armyId")
    private List<TParticipant> tParticipantList;

    public Army() {
    }

    public Army(Long id) {
        this.id = id;
    }

    public Army(Long id, String armyName) {
        this.id = id;
        this.armyName = armyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArmyName() {
        return armyName;
    }

    public void setArmyName(String armyName) {
        this.armyName = armyName;
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
        if (!(object instanceof Army)) {
            return false;
        }
        Army other = (Army) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.e11.twk.model.Army[ id=" + id + " ]";
    }
    
}
