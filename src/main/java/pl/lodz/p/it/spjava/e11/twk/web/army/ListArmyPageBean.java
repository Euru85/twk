/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.web.army;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import pl.lodz.p.it.spjava.e11.twk.dto.ArmyDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.endpoint.ArmyEndpoint;


@Named(value = "listArmyPageBean")
@RequestScoped
public class ListArmyPageBean {

    @EJB
    private ArmyEndpoint leagueEndpoint;
    private List<ArmyDTO> listtArmyDTO;
    
    public ListArmyPageBean() {
    }

    public List<ArmyDTO> getListtArmyDTO() {
        return listtArmyDTO;
    }

    public void setListtArmyDTO(List<ArmyDTO> listtArmyDTO) {
        this.listtArmyDTO = listtArmyDTO;
    }
    
    @PostConstruct
    private void init(){
        listtArmyDTO = leagueEndpoint.listAllArmys();
    }
    
}
