package pl.lodz.p.it.spjava.e11.twk.exception;

import javax.persistence.OptimisticLockException;
import pl.lodz.p.it.spjava.e11.twk.model.GameSystem;


/**
 *
 */
public class GameSystemException extends AppBaseException {

    static final public String KEY_DB_CONSTRAINT = "error.db.constraint.uniq.name";
    static final public String KEY_GAME_SYSTEM_OPTIMISTIC_LOCK = "error.gameSystem.optimisticlock";
    static final public String KEY_GAME_SYSTEM_NOT_FOUND ="error.gameSystem.notFound";
    static final public String KEY_GAME_SYSTEM_ALREADY_CHANGED ="error.gameSystem.alreadyChanged";

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
    
    static public GameSystemException createGameSystemWithOptimisticLockKey(GameSystem gameSystem, OptimisticLockException cause) {
        GameSystemException gse = new GameSystemException(KEY_GAME_SYSTEM_OPTIMISTIC_LOCK, cause);
        gse.setGameSystem(gameSystem);
        return gse;
    }

    static public GameSystemException createGameSystemExceptionWithTxRetryRollback() {
        GameSystemException gse = new GameSystemException(KEY_TX_RETRY_ROLLBACK);
        return gse;
    }

    static public GameSystemException createWithDbCheckConstraintKey(GameSystem gameSystem, Throwable cause) {
        GameSystemException gse = new GameSystemException(KEY_DB_CONSTRAINT, cause);
        gse.gameSystem = gameSystem;
        return gse;
    }
}
