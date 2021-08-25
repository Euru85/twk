package pl.lodz.p.it.spjava.e11.twk.ejb.endpoint;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import pl.lodz.p.it.spjava.e11.twk.dto.AccountDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.AccountFacade;
import pl.lodz.p.it.spjava.e11.twk.model.Account;
import pl.lodz.p.it.spjava.e11.twk.dto.AccountDataDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.AccountDataFacade;
import pl.lodz.p.it.spjava.e11.twk.model.AccountData;
import pl.lodz.p.it.spjava.e11.twk.dto.PlayerDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.PlayerFacade;
import pl.lodz.p.it.spjava.e11.twk.model.Player;

@Stateful
public class AccountProfileEndpoint {
    @EJB
    AccountDataFacade accountDataFacade;
    @EJB
    AccountFacade accountFacade;
    @EJB
    PlayerFacade aplayerFacade;
    
    public List<AccountDataDTO> listAllAccountDatas(){
        List<AccountDataDTO> listAccountDatasDTO = new ArrayList<>();
        List<AccountData> listAccountDatas = accountDataFacade.findAll();
        for (AccountData accountData : listAccountDatas){
            AccountDataDTO accountDataDTO = new AccountDataDTO(accountData.getId(), accountData.getAcoountName(), accountData.getSurname() , accountData.getAccountId() );
            listAccountDatasDTO.add(accountDataDTO);
        }
        
        return listAccountDatasDTO;
    }

    public List<AccountDTO> listAllAccounts(){
        List<AccountDTO> listAccountsDTO = new ArrayList<>();
        List<Account> listAccounts = accountFacade.findAll();
        for (Account account : listAccounts){
            AccountDTO accountDTO = new AccountDTO(account.getId(), account.getLogin(), account.getActive() );
            listAccountsDTO.add(accountDTO);
        }
        
        return listAccountsDTO;
    }
    
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
