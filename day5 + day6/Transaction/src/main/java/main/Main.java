package main;

import configuration.JPAConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.AccountRepos;
import service.AccountServiceImpl;

public class Main {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static AccountRepos repos=applicationContext.getBean("accountRepos", AccountRepos.class);
    static AccountServiceImpl service=applicationContext.getBean("accountServiceImpl", AccountServiceImpl.class);

    public static void main(String[] args) {
        service.transferMoney(1L,2L,100.0);
//        System.out.println(repos.findById(1L));
//        System.out.println(repos.findById(2L));
    }
}
