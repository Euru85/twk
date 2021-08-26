/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.AccountDTO;
import pl.lodz.p.it.spjava.e11.twk.dto.AccountDataDTO;
import pl.lodz.p.it.spjava.e11.twk.dto.AdministratorDTO;
import pl.lodz.p.it.spjava.e11.twk.dto.PlayerDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.AccountProfileEndpoint;

@Named(value = "showAccountDetailsPageBean")
@RequestScoped
public class ShowAccountDetailsPageBean {
    @EJB
    private AccountProfileEndpoint accountProfileEndpoint;
    private AccountDTO accountDTO;
    private AccountDataDTO accountDataDTO;
    private PlayerDTO playerDTO;
    private AdministratorDTO adminDTO;
    
    @Inject
    private AccountController accountController;

    public ShowAccountDetailsPageBean() {
    }
    
    public AccountDTO getAccountDTO(){
        accountDTO = accountProfileEndpoint.getAccountById(accountController.getSelectedAccountId());
        return accountDTO;
    }
    
    public AccountDataDTO getAccountDataDTO(){
        accountDataDTO = accountProfileEndpoint.listDataByAccountId(accountController.getSelectedAccountId());
        return accountDataDTO;
    }
    
    public boolean isAdmin(){
       return accountProfileEndpoint.isAdmin(accountController.getSelectedAccountId());
    }
    
   @PostConstruct
    private void init(){
        accountDTO = accountProfileEndpoint.getAccountById(accountController.getSelectedAccountId());
        accountDataDTO = accountProfileEndpoint.listDataByAccountId(accountController.getSelectedAccountId());

    }
    
}
