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
import pl.lodz.p.it.spjava.e11.twk.dto.GameSystemDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.GameSystemEndpoint;



@Named(value = "listGameSystemPageBean")
@RequestScoped
public class ListGameSystemPageBean {

    @EJB
    private GameSystemEndpoint gameSystemEndpoint;
    private List<GameSystemDTO> listGameSystemDTO;
    
    public ListGameSystemPageBean() {
    }

    public List<GameSystemDTO> getListGameSystemDTO() {
        return listGameSystemDTO;
    }

    public void setListGameSystemDTO(List<GameSystemDTO> listGameSystemDTO) {
        this.listGameSystemDTO = listGameSystemDTO;
    }
    
    
    
    @PostConstruct
    private void init(){
        listGameSystemDTO = gameSystemEndpoint.listAllGameSystems();
    }
    
}
