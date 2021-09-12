package pl.lodz.p.it.spjava.e11.twk.exception;

import pl.lodz.p.it.spjava.e11.twk.model.Account;


/**
 *
 */
public class AccountException extends AppBaseException {

    static final public String KEY_DB_CONSTRAINT = "error.account.db.constraint.uniq.login";

    private AccountException(String message) {
        super(message);
    }

    private AccountException(String message, Throwable cause) {
        super(message, cause);
    }

    private Account account;

    public Account getAccount() {
        return account;
    }

    static public AccountException createAccountExceptionWithTxRetryRollback() {
        AccountException ke = new AccountException(KEY_TX_RETRY_ROLLBACK);
        return ke;
    }

    static public AccountException createWithDbCheckConstraintKey(Account account, Throwable cause) {
        AccountException ke = new AccountException(KEY_DB_CONSTRAINT, cause);
        ke.account = account;
        return ke;
    }
}
