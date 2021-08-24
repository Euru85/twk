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
import pl.lodz.p.it.spjava.e11.twk.dto.AccountDataDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.AccountDataEndpoint;



@Named(value = "listAccountDataPageBean")
@RequestScoped
public class ListAccountDataPageBean {

    @EJB
    private AccountDataEndpoint accountDataEndpoint;
    private List<AccountDataDTO> listAccountDataDTO;
    
    public ListAccountDataPageBean() {
    }

    public List<AccountDataDTO> getListAccountDataDTO() {
        return listAccountDataDTO;
    }

    public void setListAccountDataDTO(List<AccountDataDTO> listAccountDataDTO) {
        this.listAccountDataDTO = listAccountDataDTO;
    }
    
    
    
    @PostConstruct
    private void init(){
        listAccountDataDTO = accountDataEndpoint.listAllAccountDatas();
    }
    
}
