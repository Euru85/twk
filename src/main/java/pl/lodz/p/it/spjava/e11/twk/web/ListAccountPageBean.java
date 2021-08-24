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
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.AccountEndpoint;



@Named(value = "listAccountPageBean")
@RequestScoped
public class ListAccountPageBean {

    @EJB
    private AccountEndpoint accountEndpoint;
    private List<AccountDTO> listAccountDTO;
    
    public ListAccountPageBean() {
    }

    public List<AccountDTO> getListAccountDTO() {
        return listAccountDTO;
    }

    public void setListAccountDTO(List<AccountDTO> listAccountDTO) {
        this.listAccountDTO = listAccountDTO;
    }
    
    
    
    @PostConstruct
    private void init(){
        listAccountDTO = accountEndpoint.listAllAccounts();
    }
    
}
