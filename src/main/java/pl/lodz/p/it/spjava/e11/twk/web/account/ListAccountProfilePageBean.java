/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.account;

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
    private List<AccountProfileDTO> listAccountPlayersDTO;
    private List<AccountProfileDTO> listAccountAdministratorsDTO;
    
    @Inject
    private AccountController accountController;

    public ListAccountProfilePageBean() {
    }

    public List<AccountProfileDTO> getListAccountProfilesDTO() {
        return listAccountProfilesDTO;
    }

    public void setListAccountProfilesDTO(List<AccountProfileDTO> listAccountProfilesDTO) {
        this.listAccountProfilesDTO = listAccountProfilesDTO;
    }
    

    public String showAccountDetailsAction(final AccountProfileDTO accountProfileDTO){
       accountController.setSelectedAccountProfileDTO(accountProfileDTO);
        return "goToAccountDetails";
    }

    public List<AccountProfileDTO> getListAccountPlayersDTO() {
        return listAccountPlayersDTO;
    }

    public void setListAccountPlayersDTO(List<AccountProfileDTO> listAccountPlayersDTO) {
        this.listAccountPlayersDTO = listAccountPlayersDTO;
    }

    public List<AccountProfileDTO> getListAccountAdministratorsDTO() {
        return listAccountAdministratorsDTO;
    }

    public void setListAccountAdministratorsDTO(List<AccountProfileDTO> listAccountAdministratorsDTO) {
        this.listAccountAdministratorsDTO = listAccountAdministratorsDTO;
    }
    
    
       
    @PostConstruct
    private void init(){
        listAccountProfilesDTO = accountProfileEndpoint.listAllAccountProfiles();
        listAccountPlayersDTO = accountProfileEndpoint.listAllAccountAdministrators();
        listAccountAdministratorsDTO = accountProfileEndpoint.listAllAccountPlayers();
    }
    
}
