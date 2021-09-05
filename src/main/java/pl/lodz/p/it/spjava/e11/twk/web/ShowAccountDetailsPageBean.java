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
import pl.lodz.p.it.spjava.e11.twk.dto.TournamentDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.AccountProfileEndpoint;

@Named(value = "showAccountDetailsPageBean")
@RequestScoped
public class ShowAccountDetailsPageBean {
    @EJB
    private AccountProfileEndpoint accountProfileEndpoint;
    private AccountProfileDTO accountProfileDTO;
    private List<TournamentDTO> listTournamentDTO;
    
    @Inject
    private AccountController accountController;

    public ShowAccountDetailsPageBean() {
    }

    public AccountProfileDTO getAccountProfileDTO() {
        accountProfileDTO = accountController.getSelectedAccountProfileDTO();
        return accountProfileDTO;
    }
    
    public List<TournamentDTO> listTournamentsDTO(){
        listTournamentDTO = accountProfileEndpoint.listTournamentsByAccountProfileDTO(accountController.getSelectedAccountProfileDTO());
        return listTournamentDTO;
    }
  
   @PostConstruct
    private void init(){
        accountProfileDTO = accountController.getSelectedAccountProfileDTO();
        listTournamentDTO = accountProfileEndpoint.listTournamentsByAccountProfileDTO(accountController.getSelectedAccountProfileDTO());
    }
    
}
