/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Accounts | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import pl.lodz.p.it.spjava.e11.twk.dto.AccountDTO;


/**
 *
 * @author student
 */
@Named(value = "AccountController")
@SessionScoped
public class AccountController implements Serializable {

    private Long selectedAccountId;

    public Long getSelectedAccountId() {
        return selectedAccountId;
    }

    public void setSelectedAccountId(Long selectedAccountId) {
        this.selectedAccountId = selectedAccountId;
    }
    
    /**
     * Creates a new instance of AccountController
     */
    public AccountController() {
    }
    
    
}
