package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;   
    private final Log logger = LogFactory.getLog(MyBeanWithDependencyImplement.class); 

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        logger.info("Pasando por printWithDependency");
        logger.debug("Pasando por printWithDependency por debug *******************");
        System.out.println(myOperation.sum(10));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
        
    }
    
}
