package pl.lodz.p.it.spjava.e11.twk.exception;

import javax.persistence.OptimisticLockException;
import pl.lodz.p.it.spjava.e11.twk.model.League;


/**
 *
 */
public class LeagueException extends AppBaseException {

    static final public String KEY_DB_CONSTRAINT = "error.db.constraint.uniq.name";
    static final public String KEY_LEAGUE_OPTIMISTIC_LOCK = "error.league.optimisticlock";
    static final public String KEY_LEAGUE_NOT_FOUND ="error.league.notFound";
    static final public String KEY_LEAGUE_ALREADY_CHANGED ="error.league.alreadyChanged";

    private LeagueException(String message) {
        super(message);
    }

    private LeagueException(String message, Throwable cause) {
        super(message, cause);
    }

    private League league;

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
    
    static public LeagueException createLeagueWithOptimisticLockKey(League league, OptimisticLockException cause) {
        LeagueException gse = new LeagueException(KEY_LEAGUE_OPTIMISTIC_LOCK, cause);
        gse.setLeague(league);
        return gse;
    }

    static public LeagueException createLeagueExceptionWithTxRetryRollback() {
        LeagueException gse = new LeagueException(KEY_TX_RETRY_ROLLBACK);
        return gse;
    }

    static public LeagueException createWithDbCheckConstraintKey(League league, Throwable cause) {
        LeagueException gse = new LeagueException(KEY_DB_CONSTRAINT, cause);
        gse.league = league;
        return gse;
    }
}
