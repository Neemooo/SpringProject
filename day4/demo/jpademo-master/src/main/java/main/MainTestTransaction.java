package main;

import configuration.JPAConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.AccountRepository;
import service.impl.AccountService;

public class MainTestTransaction {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static AccountRepository accountRepository = applicationContext.getBean("accountRepository", AccountRepository.class);
    static AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
    public static void main(String[] args) throws Exception {

    }
}
