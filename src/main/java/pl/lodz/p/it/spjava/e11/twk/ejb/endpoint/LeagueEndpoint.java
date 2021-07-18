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
import pl.lodz.p.it.spjava.e11.twk.dto.LeagueDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.LeagueFacade;
import pl.lodz.p.it.spjava.e11.twk.model.League;

/**
 *
 * @author Adam
 */
@Stateful
public class LeagueEndpoint {
    
    @EJB
    LeagueFacade leagueFacade;

    public List<LeagueDTO> listAllLeagues(){
        List<LeagueDTO> listLeaguesDTO = new ArrayList<>();
        List<League> listLeagues = leagueFacade.findAll();
        for (League league : listLeagues){
            LeagueDTO leagueDTO = new LeagueDTO(league.getId(), league.getLeagueName());
            listLeaguesDTO.add(leagueDTO);
        }
        
        return listLeaguesDTO;
    }
}
