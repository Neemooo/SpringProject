package annotation.xmlConfig;


import annotation.pojo.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("xmlAnnotation/beans2.xml");

        AccountService accountService=applicationContext.getBean("accountService", AccountService.class);
        System.out.println("Before money transfer");
        System.out.println("Account 1 balance :"+ accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance :"+ accountService.getAccount(2).getBalance());


        accountService.transferMoney(1,2,5);
        System.out.println("========================");
        System.out.println("After money transfer");
        System.out.println("Account 1 balance :"+ accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance :"+ accountService.getAccount(2).getBalance());
    }
}
