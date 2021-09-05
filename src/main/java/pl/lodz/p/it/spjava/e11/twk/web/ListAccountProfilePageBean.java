/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import pl.lodz.p.it.spjava.e11.twk.dto.AccountProfileDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.AccountProfileEndpoint;



@Named(value = "listAccountProfilePageBean")
@RequestScoped
public class ListAccountProfilePageBean {

    @EJB
    private AccountProfileEndpoint accountProfileEndpoint;
    private List<AccountProfileDTO> listAccountProfilesDTO;
    @Inject
    private AccountController accountController;

    public ListAccountProfilePageBean() {
    }

    public String showAccountDetailsAction(final AccountProfileDTO accountProfileDTO){
       accountController.setSelectedAccountProfileDTO(accountProfileDTO);
        return "goToAccountDetails";
    }
       
    @PostConstruct
    private void init(){
        listAccountProfilesDTO = accountProfileEndpoint.listAllAccountProfiles();
    }
    
}
