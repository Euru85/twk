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
import pl.lodz.p.it.spjava.e11.twk.dto.AccountDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.AccountFacade;
import pl.lodz.p.it.spjava.e11.twk.model.Account;

/**
 *
 * @author Adam
 */
@Stateful
public class AccountEndpoint {
    
    @EJB
    AccountFacade accountFacade;

    public List<AccountDTO> listAllAccounts(){
        List<AccountDTO> listAccountsDTO = new ArrayList<>();
        List<Account> listAccounts = accountFacade.findAll();
        for (Account account : listAccounts){
            AccountDTO accountDTO = new AccountDTO(account.getId(), account.getLogin(), account.getActive() );
            listAccountsDTO.add(accountDTO);
        }
        
        return listAccountsDTO;
    }
}
