package annotation.pojo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;

    public void transferMoney(long fromAccountId, long toAccountId, double amount) {
        Account sourceAccount= accountRepository.find(fromAccountId);
        Account targetAccount= accountRepository.find(toAccountId);
        sourceAccount.setBalance(sourceAccount.getBalance()-amount);
        targetAccount.setBalance(targetAccount.getBalance()+amount);
        accountRepository.update(sourceAccount);
        accountRepository.update(targetAccount);
    }

    public void depositMoney(long accountId, double amount) throws Exception {
        Account account=accountRepository.find(accountId);
        account.setBalance(account.getBalance()+amount);
        accountRepository.update(account);
    }

    public Account getAccount(long accountId) {
        return accountRepository.find(accountId);
    }
}
