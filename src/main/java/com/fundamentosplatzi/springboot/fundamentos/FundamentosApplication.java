package com.fundamentosplatzi.springboot.fundamentos;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.Users;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;


@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;

	private final Log logger = LogFactory.getLog(FundamentosApplication.class);

	//Cuando tenemos multiples implementaciones de una
	//dependencia, se usa la etiqueta Qualifier para indicar
	//cual dependencia se desea inyectar
	public FundamentosApplication(
		MyBean myBeanInyected,
		 @Qualifier("componentTwoImplement") ComponentDependency componentDependency,
		 MyBeanWithDependency myBeanWithDependency,
		 MyBeanWithProperties myBeanWithProperties,
		 UserPojo userPojo,
		 UserRepository userRepository,
		 UserService userService
	){
		this.componentDependency = componentDependency;
		this.myBean = myBeanInyected;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
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
			/*try{
				int numero = 14/0;
			}catch(Exception e){
				logger.error(e.getStackTrace());
			}*/
			//saveUsersInDataBase();
			//getInformationJpqlFromUser();
			saveWithErrorTransactional();
		}

		private void saveUsersInDataBase(){
			Users user = new Users("Jhon", "jhon@gmail.com", LocalDate.of(2022, 9, 20));
			Users user2 = new Users("Andres", "Andres@gmail.com", LocalDate.of(2022, 4, 20));
			Users user3 = new Users("Daniela", "Daniela@gmail.com", LocalDate.of(2022, 12, 20));
			List<Users> list = Arrays.asList(user, user2, user3);
			userRepository.saveAll(list);
			//System.out.println("Datos de db" + userRepository.findAll());
		}

				
		private void saveWithErrorTransactional() {
			Users test1 = new Users("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
			Users test2 = new Users("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
			Users test3 = new Users("TestTransactional3", "TestTransactional3@domain.com", LocalDate.now());
			Users test4 = new Users("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());
		
			List<Users> users = Arrays.asList(test1, test2, test3, test4);
			userService.saveTransactional(users);
			userService.getAllUsers().stream()
			.forEach(user -> logger.info("Este es el usuario dentro del metodo transaccional: " + user));
		}

		private void getInformationJpqlFromUser(){
			//logger.error(userRepository.findByUserEmail("Andres@gmail.com")
			//	.orElseThrow(()->new RuntimeException("No se encontro el usuario")));
		
		
			//userRepository.findAndSort("Andres", Sort.by("id").descending())
			//		.stream()
			//		.forEach(user -> logger.error("Usuario con metodo sort:*************************************************" + user));
		
			//userRepository.findByName("Andres")
				//.stream()
				//.forEach(user -> logger.error("Usuario con metodo findByName:*************************************************" + user));
				
			//userRepository.findByEmailAndName("Andres@gmail.com", "Andres")
				//.stream()
				//.forEach(user -> logger.error("Usuario con metodo findByName:*************************************************" + user));
		

				//userRepository.findByName("Andres")
				//.stream()
				//.forEach(user -> logger.error("findByName:*************************************************" + user));
				
				//userRepository.findByNameOrEmail(null, "Andres@gmail.com")
				//.stream()
				//.forEach(user -> logger.error("findByName:*************************************************" + user));
		
				//userRepository.findByBirthDateBetween(LocalDate.of(2022, 9, 20), LocalDate.of(2022, 9, 20))
				//.stream()
				//.forEach(user -> logger.error("findByName:*************************************************" + user));


				
				logger.error(" getAllByBirthdayAndEmail findByName:"+ userRepository.getAllByBirthDateAndEmail(LocalDate.of(2022, 4, 20), "Andres@gmail.com") + "*************************************************" );
				//.stream()
				//.forEach(user -> logger.error(" getAllByBirthdayAndEmail findByName:*************************************************" + user));
		

			}

}
