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
import pl.lodz.p.it.spjava.e11.twk.dto.AccountDataDTO;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.AccountDataFacade;
import pl.lodz.p.it.spjava.e11.twk.model.AccountData;

/**
 *
 * @author Adam
 */
@Stateful
public class AccountDataEndpoint {
    
    @EJB
    AccountDataFacade accountDataFacade;

    public List<AccountDataDTO> listAllAccountDatas(){
        List<AccountDataDTO> listAccountDatasDTO = new ArrayList<>();
        List<AccountData> listAccountDatas = accountDataFacade.findAll();
        for (AccountData accountData : listAccountDatas){
            AccountDataDTO accountDataDTO = new AccountDataDTO(accountData.getId(), accountData.getAcoountName(), accountData.getSurname() , accountData.getAccountId() );
            listAccountDatasDTO.add(accountDataDTO);
        }
        
        return listAccountDatasDTO;
    }
}
