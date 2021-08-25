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
import pl.lodz.p.it.spjava.e11.twk.dto.AccountDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.AccountProfileEndpoint;
import pl.lodz.p.it.spjava.e11.twk.dto.AccountDataDTO;
import pl.lodz.p.it.spjava.e11.twk.dto.AdministratorDTO;
import pl.lodz.p.it.spjava.e11.twk.dto.PlayerDTO;



@Named(value = "listAccountProfilePageBean")
@RequestScoped
public class ListAccountProfilePageBean {

    @EJB
    private AccountProfileEndpoint accountProfileEndpoint;
    private List<AccountDTO> listAccountDTO;
    private List<AccountDataDTO> listAccountDataDTO;
    private List<PlayerDTO> listPlayerDTO;
    private List<AdministratorDTO> listAdminDTO;

    public ListAccountProfilePageBean() {
    }

    public List<AccountDTO> getListAccountDTO() {
        return listAccountDTO;
    }

    public void setListAccountDTO(List<AccountDTO> listAccountDTO) {
        this.listAccountDTO = listAccountDTO;
    }
    
    public List<AccountDataDTO> getListAccountDataDTO() {
        return listAccountDataDTO;
    }

    public void setListAccountDataDTO(List<AccountDataDTO> listAccountDataDTO) {
        this.listAccountDataDTO = listAccountDataDTO;
    }
    
    public List<PlayerDTO> getListPlayerDTO() {
        return listPlayerDTO;
    }

    public void setListPlayerDTO(List<PlayerDTO> listPlayerDTO) {
        this.listPlayerDTO = listPlayerDTO;
    }
    
    public List<AdministratorDTO> getListAdminDTO() {
        return listAdminDTO;
    }

    public void setListAdminDTO(List<AdministratorDTO> listAdminDTO) {
        this.listAdminDTO = listAdminDTO;
    }
    
    public boolean isAdmin(Long id){
        return accountProfileEndpoint.isAdmin(id);
    } 
    
    
    @PostConstruct
    private void init(){
        listAccountDTO = accountProfileEndpoint.listAllAccounts();
        listAccountDataDTO = accountProfileEndpoint.listAllAccountDatas();
        listPlayerDTO = accountProfileEndpoint.listAllPlayers();
        listAdminDTO = accountProfileEndpoint.listAllAdmins();
    }
    
}
