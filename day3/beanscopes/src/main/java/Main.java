import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Account;
import pojo.AccountService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("Beans.xml");

        Account account=applicationContext.getBean("account1",Account.class);
        account.setOwnerName("XXXXXXXX");
        Account account1=applicationContext.getBean("account1",Account.class);
        System.out.println("account1: used singleton "+ account1.getOwnerName());

        Account account2=applicationContext.getBean("account2",Account.class);
        account2.setOwnerName("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
        Account account3=applicationContext.getBean("account2",Account.class);
        System.out.println("account2: used prototype "+ account3.getOwnerName());
        System.out.println(account2.getOwnerName());

    }
}
