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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Adam
 */
@Entity
@Table(name = "ORGANIZATOR")
@NamedQueries({
    @NamedQuery(name = "Organizator.findAll", query = "SELECT o FROM Organizator o"),
    @NamedQuery(name = "Organizator.findById", query = "SELECT o FROM Organizator o WHERE o.id = :id"),
    @NamedQuery(name = "Organizator.findByVer", query = "SELECT o FROM Organizator o WHERE o.ver = :ver")})
public class Organizator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "VER")
    @Version
    private Long ver;
    @OneToMany(mappedBy = "organizatorId")
    private List<Tournament> tournamentList;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    @OneToOne
    private Account accountId;

    public Organizator() {
    }

    public Organizator(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tournament> getTournamentList() {
        return tournamentList;
    }

    public void setTournamentList(List<Tournament> tournamentList) {
        this.tournamentList = tournamentList;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
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
        if (!(object instanceof Organizator)) {
            return false;
        }
        Organizator other = (Organizator) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.e11.twk.model.Organizator[ id=" + id + " ]";
    }
    
}
