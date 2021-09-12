/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.ejb.manager;

import javax.ejb.LocalBean;
import javax.ejb.SessionSynchronization;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.AccountDataFacade;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.AccountFacade;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.AdministratorFacade;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.OrganizatorFacade;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.PlayerFacade;
import pl.lodz.p.it.spjava.e11.twk.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;
import pl.lodz.p.it.spjava.e11.twk.model.Account;


/**
 *
 * @author Adam
 */
@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Interceptors(LoggingInterceptor.class)
public class AccountProfileManager extends AbstractManager implements SessionSynchronization {
    
    @Inject
    private AccountFacade accountFacade;
    private AccountDataFacade accountDataFacade;
    private AdministratorFacade administratorFacade;
    private PlayerFacade playerFacade;
    private OrganizatorFacade organizatorFacade;
    
    public void createAccount (Account account)throws AppBaseException {
        accountFacade.create(account);
    }    
}
