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
import pl.lodz.p.it.spjava.e11.twk.dto.PlayerDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.PlayerEndpoint;



@Named(value = "listPlayerPageBean")
@RequestScoped
public class ListPlayerPageBean {

    @EJB
    private PlayerEndpoint playerEndpoint;
    private List<PlayerDTO> listPlayerDTO;
    
    public ListPlayerPageBean() {
    }

    public List<PlayerDTO> getListPlayerDTO() {
        return listPlayerDTO;
    }

    public void setListPlayerDTO(List<PlayerDTO> listPlayerDTO) {
        this.listPlayerDTO = listPlayerDTO;
    }
    
    
    
    @PostConstruct
    private void init(){
        listPlayerDTO = playerEndpoint.listAllPlayers();
    }
    
}
