package pl.lodz.p.it.spjava.e11.twk.ejb.endpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import pl.lodz.p.it.spjava.e11.twk.dto.AccountDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.AccountFacade;
import pl.lodz.p.it.spjava.e11.twk.model.Account;
import pl.lodz.p.it.spjava.e11.twk.dto.AccountDataDTO;
import pl.lodz.p.it.spjava.e11.twk.dto.AccountProfileDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.AccountDataFacade;
import pl.lodz.p.it.spjava.e11.twk.model.AccountData;
import pl.lodz.p.it.spjava.e11.twk.dto.PlayerDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.PlayerFacade;
import pl.lodz.p.it.spjava.e11.twk.model.Player;
import pl.lodz.p.it.spjava.e11.twk.model.Administrator;
import pl.lodz.p.it.spjava.e11.twk.dto.AdministratorDTO;
import pl.lodz.p.it.spjava.e11.twk.dto.LeagueDTO;
import pl.lodz.p.it.spjava.e11.twk.dto.TournamentDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.AdministratorFacade;
import pl.lodz.p.it.spjava.e11.twk.model.Tournament;

@Stateful
public class AccountProfileEndpoint {
    @EJB
    AccountDataFacade accountDataFacade;
    @EJB
    AccountFacade accountFacade;
    @EJB
    PlayerFacade playerFacade;
    @EJB
    AdministratorFacade adminFacade;
    
    public List<AccountProfileDTO> listAllAccountProfiles(){
        List<AccountProfileDTO> listAccountProfilesDTO = new ArrayList<>();
        List<Account> listAccounts = accountFacade.findAll();
        for (Account account : listAccounts){
            AccountProfileDTO accountProfileDTO = new AccountProfileDTO(account.getId(),  account.getActive(), account.getLogin(), account.getTournamentList(),account.getAdministratorList(),account.getPlayerList(), account.getOrganizatorList(), account.getAccountDataList());
            listAccountProfilesDTO.add(accountProfileDTO);
        }
        
        return listAccountProfilesDTO;
    }
    
    public List<TournamentDTO> listTournamentsByAccountProfileDTO(AccountProfileDTO accountProfileDTO){
        List<TournamentDTO> listTournamentsDTO = new ArrayList<>();
        for (Tournament tournament : accountProfileDTO.getTournamentList()){
            TournamentDTO tournamentDTO = new TournamentDTO(tournament.getId(),tournament.getClosed(), tournament.getCurrentRound(),tournament.getDescription(),tournament.getRounds(), tournament.getTournamentName(), tournament.getGameSystemId(),tournament.getLeagueId(),tournament.getOrganizatorId(),tournament.getTRoundList(), tournament.getTParticipantList());
            listTournamentsDTO.add(tournamentDTO);
        }
        return listTournamentsDTO;
    }
    
}
