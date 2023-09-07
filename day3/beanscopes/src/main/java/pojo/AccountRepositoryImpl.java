package pojo;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRepositoryImpl implements AccountRepository {

    private Map<Long, Account> accountsMap=new HashMap<Long, Account>();
    {
       Account account1= Account.builder()
                .id(1L)
                .ownerName("John")
                .balance(10.0)
                .build();

       Account account2= Account.builder()
                .id(2L)
                .ownerName("Mary")
                .balance(20.0)
                .build();
        accountsMap.put(account1.getId(), account1);
        accountsMap.put(account2.getId(), account2);
    }

    public void insert(Account account) {
        accountsMap.put(account.getId(), account);
    }

    public void update(Account account) {
        accountsMap.put(account.getId(), account);

    }

    public Account find(long accountId) {
        return accountsMap.get(accountId);
    }
}
