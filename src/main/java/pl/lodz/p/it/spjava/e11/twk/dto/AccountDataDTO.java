/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.dto;

import pl.lodz.p.it.spjava.e11.twk.model.Account;


/**
 *
 * @author Adam
 */
public class AccountDataDTO {

    private Long id;
    private String acoountName;
    private String surname;
    private Account accountId;

    public AccountDataDTO() {
    }

    public AccountDataDTO(Long id, String acoountName, String surname, Account accountId) {
        this.id = id;
        this.acoountName = acoountName;
        this.surname = surname;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcoountName() {
        return acoountName;
    }

    public void setAcoountName(String acoountName) {
        this.acoountName = acoountName;
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
    
}
