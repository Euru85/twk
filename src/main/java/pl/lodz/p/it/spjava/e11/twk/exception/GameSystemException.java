package pl.lodz.p.it.spjava.e11.twk.exception;

import javax.persistence.OptimisticLockException;
import pl.lodz.p.it.spjava.e11.twk.model.GameSystem;


/**
 *
 */
public class GameSystemException extends AppBaseException {


    static final public String KEY_OPTIMISTIC_LOCK = "error.gameSystem.optimisticlock";
    static final public String KEY_DB_CONSTRAINT = "error.gameSystem.db.constraint";
    static final public String KEY_APROVE_OF_APROVED = "error.gameSystem.aprove.of.aproved";
    static final public String KEY_NO_STATE_IN_EJB_ENDPOINT = "error.gameSystem.no.state.in.ejb.endpoint";
    static final public String KEY_NOT_FOUND = "error.gameSystem.not.found";
    static final public String KEY_PRODUCT_NOT_FOUND = "error.product.not.found";

    private GameSystemException(String message) {
        super(message);
    }

    private GameSystemException(String message, Throwable cause) {
        super(message, cause);
    }
    private GameSystem gameSystem;

    public GameSystem getGameSystem() {
        return gameSystem;
    }

    public void setGameSystem(GameSystem gameSystem) {
        this.gameSystem = gameSystem;
    }
    
    static public GameSystemException createGameSystemExceptionWithTxRetryRollback() {
        GameSystemException ze = new GameSystemException(KEY_TX_RETRY_ROLLBACK);
        return ze;
    }
    
    static public GameSystemException createGameSystemExceptionWithOptimisticLockKey(GameSystem gameSystem, OptimisticLockException cause) {
        GameSystemException ze = new GameSystemException(KEY_OPTIMISTIC_LOCK, cause);
        ze.setGameSystem(gameSystem);
        return ze;
    }

    static public GameSystemException createGameSystemExceptionWithDbCheckConstraintKey(GameSystem gameSystem, Throwable cause) {
        GameSystemException ze = new GameSystemException(KEY_DB_CONSTRAINT, cause);
        ze.setGameSystem(gameSystem);
        return ze;
    }


    static public GameSystemException createGameSystemExceptionWithAproveOfAproved(GameSystem gameSystem) {
        GameSystemException ze = new GameSystemException(KEY_APROVE_OF_APROVED);
        ze.setGameSystem(gameSystem);
        return ze;
    }

    static public GameSystemException createGameSystemExceptionWithRemoveOfAproved() {
        GameSystemException ze = new GameSystemException(KEY_APROVE_OF_APROVED);
        return ze;
    }

    static public GameSystemException createGameSystemExceptionWithNotFound() {
        GameSystemException ze = new GameSystemException(KEY_NOT_FOUND);
        return ze;
    }

    static public GameSystemException createGameSystemExceptionWithProductNotFound() {
        GameSystemException ze = new GameSystemException(KEY_PRODUCT_NOT_FOUND);
        return ze;
    }

}
