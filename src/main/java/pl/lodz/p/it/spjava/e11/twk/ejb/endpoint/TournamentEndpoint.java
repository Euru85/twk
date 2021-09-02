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
import pl.lodz.p.it.spjava.e11.twk.dto.TournamentDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.GameSystemFacade;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.TournamentFacade;
import pl.lodz.p.it.spjava.e11.twk.model.Tournament;

/**
 *
 * @author Adam
 */
@Stateful
public class TournamentEndpoint {
    
    @EJB
    TournamentFacade tournamentFacade;
    GameSystemFacade gameSystem;

    public List<TournamentDTO> listAllTournaments(){
        List<TournamentDTO> listTournamentsDTO = new ArrayList<>();
        List<Tournament> listTournaments = tournamentFacade.findAll();
        for (Tournament tournament : listTournaments){
            TournamentDTO tournamentDTO = new TournamentDTO(tournament.getId(),tournament.getClosed(), tournament.getCurrentRound(),tournament.getDescription(),tournament.getRounds(), tournament.getTournamentName(), tournament.getGameSystemId(),tournament.getLeagueId(),tournament.getOrganizatorId(),tournament.getTRoundList(), tournament.getTParticipantList());
            listTournamentsDTO.add(tournamentDTO);
        }
        return listTournamentsDTO;
    }
    
    public List<TournamentDTO> listTournamentsByLeagueDTO(LeagueDTO leagueDTO){
        List<TournamentDTO> listTournamentsDTO = new ArrayList<>();
        for (Tournament tournament : leagueDTO.getTournamentList()){
            TournamentDTO tournamentDTO = new TournamentDTO(tournament.getId(),tournament.getClosed(), tournament.getCurrentRound(),tournament.getDescription(),tournament.getRounds(), tournament.getTournamentName(), tournament.getGameSystemId(),tournament.getLeagueId(),tournament.getOrganizatorId(),tournament.getTRoundList(), tournament.getTParticipantList());
            listTournamentsDTO.add(tournamentDTO);
        }
        return listTournamentsDTO;
    }

}
