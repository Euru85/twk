/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.ejb.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import pl.lodz.p.it.spjava.e11.twk.dto.ArmyDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.ArmyFacade;
import pl.lodz.p.it.spjava.e11.twk.model.Army;

/**
 *
 * @author Adam
 */
@Stateful
public class ArmyEndpoint {

    @EJB     
    ArmyFacade armyFacade;

    public List<ArmyDTO> listAllArmys(){
        List<ArmyDTO> listArmysDTO = new ArrayList<>();
        List<Army> listArmys = armyFacade.findAll();
        for (Army army : listArmys){
            ArmyDTO armyDTO = new ArmyDTO(army.getId(), army.getArmyName());
            listArmysDTO.add(armyDTO);
        }
        
        return listArmysDTO;
    }
}
