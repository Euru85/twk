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
import pl.lodz.p.it.spjava.e11.twk.dto.PlayerDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.PlayerFacade;
import pl.lodz.p.it.spjava.e11.twk.model.Player;

/**
 *
 * @author Adam
 */
@Stateful
public class PlayerEndpoint {
    
    @EJB
    PlayerFacade aplayerFacade;

    public List<PlayerDTO> listAllPlayers(){
        List<PlayerDTO> listPlayersDTO = new ArrayList<>();
        List<Player> listPlayers = aplayerFacade.findAll();
        for (Player player : listPlayers){
            PlayerDTO playerDTO = new PlayerDTO(player.getId(), player.getNick(), player.getGameClub() , player.getAccountId() );
            listPlayersDTO.add(playerDTO);
        }
        
        return listPlayersDTO;
    }
}
