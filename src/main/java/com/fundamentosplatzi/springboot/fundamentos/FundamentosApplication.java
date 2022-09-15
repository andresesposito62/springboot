package com.fundamentosplatzi.springboot.fundamentos;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{

private ComponentDependency componentDependency;
private MyBean myBean;
private MyBeanWithDependency myBeanWithDependency;
private MyBeanWithProperties myBeanWithProperties;
private UserPojo userPojo;

private final Log logger = LogFactory.getLog(FundamentosApplication.class);

//Cuando tenemos multiples implementaciones de una
//dependencia, se usa la etiqueta Qualifier para indicar
//cual dependencia se desea inyectar
public FundamentosApplication(MyBean myBeanInyected, @Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){
	this.componentDependency = componentDependency;
	this.myBean = myBeanInyected;
	this.myBeanWithDependency = myBeanWithDependency;
	this.myBeanWithProperties = myBeanWithProperties;
	this.userPojo = userPojo;
}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//componentDependency.saludar();
		//myBean.print();
		//myBeanWithDependency.printWithDependency();
		//System.out.println(myBeanWithProperties.function());
		//System.out.println(userPojo.getEmail());
		//logger.error("Esto es un error");
		//logger.info("mensaje de info");
		try{
			int numero = 14/0;
		}catch(Exception e){
			logger.error(e.getStackTrace());
		}
	}

}
