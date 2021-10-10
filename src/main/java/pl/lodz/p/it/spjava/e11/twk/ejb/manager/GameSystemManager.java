/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.e11.twk.ejb.manager;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.SessionSynchronization;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import pl.lodz.p.it.spjava.e11.twk.ejb.facade.GameSystemFacade;
import pl.lodz.p.it.spjava.e11.twk.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.e11.twk.exception.AppBaseException;
import pl.lodz.p.it.spjava.e11.twk.model.GameSystem;


/**
 *
 * @author Adam
 */
@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Interceptors(LoggingInterceptor.class)
public class GameSystemManager extends AbstractManager implements SessionSynchronization {
    
    @Inject
    private GameSystemFacade gameSystemFacade;
    
    @RolesAllowed({"Administrator"})
    public void createGameSystem (GameSystem gameSystem)throws AppBaseException,EJBException {
        gameSystemFacade.create(gameSystem);
    }
    
    @RolesAllowed({"Administrator"})
    public void updateGameSystem (Long id)throws AppBaseException {
        GameSystem gameSystem = gameSystemFacade.find(id);
        gameSystemFacade.edit(gameSystem);
    }
    
    @RolesAllowed({"Administrator"})
    public void deleteGameSystem(Long id)throws AppBaseException {
        GameSystem gameSystem = gameSystemFacade.find(id);
        gameSystemFacade.remove(gameSystem);
    }
}
