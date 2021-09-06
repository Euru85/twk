package pl.lodz.p.it.spjava.e11.twk.ejb.endpoint;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.AccountFacade;
import pl.lodz.p.it.spjava.e11.twk.model.Account;
import pl.lodz.p.it.spjava.e11.twk.dto.AccountProfileDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.AccountDataFacade;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.PlayerFacade;
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
            AccountProfileDTO accountProfileDTO = new AccountProfileDTO(account.getId(),  account.getActive(), account.getLogin(), account.getTournamentList(),account.getAdministrator(),account.getPlayer(), account.getOrganizator(), account.getAccountData());
            listAccountProfilesDTO.add(accountProfileDTO);
        }
        
        return listAccountProfilesDTO;
    }
    
    public List<AccountProfileDTO> listAllAccountPlayers(){
        List<AccountProfileDTO> listAccountProfilesDTO = new ArrayList<>();
        List<Account> listAccounts = accountFacade.findAll();
        for (Account account : listAccounts){
            AccountProfileDTO accountProfileDTO = new AccountProfileDTO(account.getId(),  account.getActive(), account.getLogin(), account.getTournamentList(),account.getAdministrator(),account.getPlayer(), account.getOrganizator(), account.getAccountData());
            if(accountProfileDTO.isPlayer()) listAccountProfilesDTO.add(accountProfileDTO);
        }       
        return listAccountProfilesDTO;
    }
    
    public List<AccountProfileDTO> listAllAccountAdministrators(){
        List<AccountProfileDTO> listAccountProfilesDTO = new ArrayList<>();
        List<Account> listAccounts = accountFacade.findAll();
        for (Account account : listAccounts){
            AccountProfileDTO accountProfileDTO = new AccountProfileDTO(account.getId(),  account.getActive(), account.getLogin(), account.getTournamentList(),account.getAdministrator(),account.getPlayer(), account.getOrganizator(), account.getAccountData());
            if(accountProfileDTO.isAdmin()) listAccountProfilesDTO.add(accountProfileDTO);
        }
        
        return listAccountProfilesDTO;
    }
    
    
    public List<TournamentDTO> listTournamentsByAccountProfileDTO(AccountProfileDTO accountProfileDTO){
        List<TournamentDTO> listTournamentsDTO = new ArrayList<>();
        for (Tournament tournament : accountProfileDTO.getTournamentList()){
            TournamentDTO tournamentDTO = new TournamentDTO(tournament.getId(),tournament.getClosed(), tournament.getCurrentRound(),tournament.getDescription(),tournament.getRounds(), tournament.getTournamentName(), tournament.getGameSystemId(),tournament.getLeagueId(),tournament.getOrganizatorId(),tournament.getTRoundList(), tournament.getTParticipantList(),tournament.getTDate());
            listTournamentsDTO.add(tournamentDTO);
        }
        return listTournamentsDTO;
    }
   
}
