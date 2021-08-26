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
import javax.validation.constraints.Size;

/**
 *
 * @author Adam
 */
@Entity
@Table(name = "ACCOUNT_DATA")
@NamedQueries({
    @NamedQuery(name = "AccountData.findAll", query = "SELECT a FROM AccountData a"),
    @NamedQuery(name = "AccountData.findById", query = "SELECT a FROM AccountData a WHERE a.id = :id"),
    @NamedQuery(name = "AccountData.findByVer", query = "SELECT a FROM AccountData a WHERE a.ver = :ver"),
    @NamedQuery(name = "AccountData.findByAccountName", query = "SELECT a FROM AccountData a WHERE a.accountName = :accountName"),
    @NamedQuery(name = "AccountData.findBySurname", query = "SELECT a FROM AccountData a WHERE a.surname = :surname")})
public class AccountData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id",unique = true, nullable = false, updatable = false)
    private Long id;
    @Column(name = "ver")
    @Version
    private Long ver;
    @Size(max = 64)
    @Column(name = "account_name", nullable = false)
    private String accountName;
    @Size(max = 64)
    @Column(name = "surname")
    private String surname;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne
    private Account accountId;

    public AccountData() {
    }

    public AccountData(Long id) {
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
        if (!(object instanceof AccountData)) {
            return false;
        }
        AccountData other = (AccountData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.e11.twk.model.AccountData[ id=" + id + " ]";
    }
    
}
