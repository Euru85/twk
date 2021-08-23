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
import pl.lodz.p.it.spjava.e11.twk.dto.GameSystemDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.GameSystemFacade;
import pl.lodz.p.it.spjava.e11.twk.model.GameSystem;


/**
 *
 * @author Adam
 */
@Stateful
public class GameSystemEndpoint {
    
    @EJB
    GameSystemFacade gameSystemFacade;

    public List<GameSystemDTO> listAllGameSystems(){
        List<GameSystemDTO> listGameSystemsDTO = new ArrayList<>();
        List<GameSystem> listGameSystems = gameSystemFacade.findAll();
        for (GameSystem gameSystem : listGameSystems){
            GameSystemDTO gameSystemDTO = new GameSystemDTO(gameSystem.getId(), gameSystem.getSystemName());
            listGameSystemsDTO.add(gameSystemDTO);
        }
        
        return listGameSystemsDTO;
    }
}
