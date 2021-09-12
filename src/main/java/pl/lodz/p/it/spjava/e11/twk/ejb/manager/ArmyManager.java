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
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.ArmyFacade;
import pl.lodz.p.it.spjava.e11.twk.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;
import pl.lodz.p.it.spjava.e11.twk.model.Army;


/**
 *
 * @author Adam
 */
@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Interceptors(LoggingInterceptor.class)
public class ArmyManager extends AbstractManager implements SessionSynchronization {
    
    @Inject
    private ArmyFacade armyFacade;
    
    public void createArmy (Army army)throws AppBaseException {
        armyFacade.create(army);
    }
    
    public void deleteArmy(Army army)throws AppBaseException {
        armyFacade.remove(army);
    }
        
}
