package javaBasedCofig.javaBaseConfiguration;

import javaBasedCofig.pojo.AccountRepository;
import javaBasedCofig.pojo.AccountRepositoryImpl;
import javaBasedCofig.pojo.AccountService;
import javaBasedCofig.pojo.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public AccountService accountService(){
        AccountServiceImpl bean= new AccountServiceImpl();
        bean.setAccountRepository(accountDao());
        return bean;
    }

    @Bean
    public AccountRepository accountDao(){
        AccountRepositoryImpl bean=new AccountRepositoryImpl();
        return bean;
    }
}
