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
public class AdministratorDTO {
    private Long id;
    private Account accountId;

    public AdministratorDTO() {
    }

    public AdministratorDTO(Long id, Account accountId) {
        this.id = id;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }
   
}
