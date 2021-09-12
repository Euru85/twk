/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Accounts | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.account;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import pl.lodz.p.it.spjava.e11.twk.dto.AccountProfileDTO;


/**
 *
 * @author student
 */
@Named(value = "AccountController")
@SessionScoped
public class AccountController implements Serializable {

    private AccountProfileDTO  selectedAccountProfileDTO;

    public AccountProfileDTO getSelectedAccountProfileDTO() {
        return selectedAccountProfileDTO;
    }

    public void setSelectedAccountProfileDTO(AccountProfileDTO accountProfileDTO) {
        this.selectedAccountProfileDTO = accountProfileDTO;
    }
    
    /**
     * Creates a new instance of AccountController
     */
    public AccountController() {
    }
    
    
}
