package by.epam.grodno.uladzimir_stsiatsko.my_web;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.epam.grodno.uladzimir_stsiatsko.my_service.AdministratorService;

public class AdministratorRegisterPage {
	
	public static void main(String args[]){
		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-context.xml");

		AdministratorService bean = aContext.getBean(AdministratorService.class);
		System.out.print(true);
	}

}
