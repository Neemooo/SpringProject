package beanLifeAnnotation;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanLife {

    @PostConstruct
    public void doCreate(){
        System.out.println("Bean is created!");
    }

    @PreDestroy
    public void doClose(){
        System.out.println("Bean is closed!");
    }
}
