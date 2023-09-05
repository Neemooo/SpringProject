package anonotation.pojo.repository.AccountRepository;

import createXML.pojo.model.Account;

public interface AccountRepository {
    void insert(Account account);
    void update(Account account);
    Account find(long accountId);
}
