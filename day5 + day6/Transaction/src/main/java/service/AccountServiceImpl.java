package service;

import error.DontEnoughMoney;
import jdk.jfr.internal.JVM;
import models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AccountRepos;

import java.io.Console;

@Service
public class AccountServiceImpl{
    @Autowired
    AccountRepos accountRepository;

    @Autowired
// muc dich de dung trong ham main:
    private JpaTransactionManager transactionManager;

    // Dependency injection via constructor
//    public AccountServiceImpl(JpaTransactionManager transactionManager){
//        this.transactionManager = transactionManager;
//    }
//    public AccountServiceImpl(){
//    }
//
//    @Transactional
//    public void transferMoney(Long sourceId, Long targetId, Double amount){
//        Account source = accountRepository.findById(sourceId).get();
//        Account target = accountRepository.findById(targetId).get();
//
//        source.setBalance(source.getBalance()-amount);
//        accountRepository.save(source);
//
//        target.setBalance(target.getBalance()+amount);
//        accountRepository.save(target);
//    }

    @Transactional
    public void transferMoney(Long sourceId, Long targetId, Double amount){
        Account source = accountRepository.findById(sourceId).get();
        Account target = accountRepository.findById(targetId).get();

            source.setBalance(source.getBalance()-amount);
            accountRepository.save(source);
            if (source.getBalance()<0) throw new DontEnoughMoney("amount to transfer more than balance");
            target.setBalance(target.getBalance()+amount);
            accountRepository.save(target);
    }
}
