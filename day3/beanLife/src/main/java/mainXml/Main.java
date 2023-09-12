package mainXml;

import beanLifeXML.Beans;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context =new ClassPathXmlApplicationContext("BeanXML.xml");
        Beans beans= (Beans) context.getBean("beans");
        beans.destroy();
    }
}
