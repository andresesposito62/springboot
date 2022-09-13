package com.fundamentosplatzi.springboot.fundamentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{

private ComponentDependency componentDependency;
private MyBean myBean;
private MyBeanWithDependency myBeanWithDependency;


//Cuando tenemos multiples implementaciones de una
//dependencia, se usa la etiqueta Qualifier para indicar
//cual dependencia se desea inyectar
public FundamentosApplication(MyBean myBeanInyected, @Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBeanWithDependency myBeanWithDependency){
	this.componentDependency = componentDependency;
	this.myBean = myBeanInyected;
	this.myBeanWithDependency = myBeanWithDependency;
}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
	}

}
