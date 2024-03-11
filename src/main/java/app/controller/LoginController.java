package app.controller;

import app.Service.LoginService;
import app.Service.veterinaryService;
import app.dtos.PersonDto;
import app.validators.PersonInputsValidator;
import java.util.Scanner;

public class LoginController {
    
    private static Scanner reader = new Scanner(System.in);
	private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
        private static LoginService loginService = new veterinaryService();
        private static VeteniraryController veteniraryController = new VeteniraryController();
        private static AdminController adminController = new AdminController();
        
	
                 

	public void login() throws Exception {
                System.out.println("            LOGIN "
                        + "\n");
                
		System.out.println("Ingrese su nombre de usuario ");
		String userName = reader.nextLine();
		personInputValidator.userNameValidator(userName);
		System.out.println("Ingrese su contraseña ");
		String password = reader.nextLine();
		personInputValidator.passwordValidator(password);
		PersonDto personDto = new PersonDto(userName, password);
		loginService.login(personDto);
                loginRouter(personDto);
		loginService.logout();
                
	}
        
        
        
        private void loginRouter(PersonDto personDto) {
		if (personDto.getRol().equals("Veterinaria")) {
			veteniraryController.session();
		} if (personDto.getRol().equals("Administrativo")) {
			adminController.session();
		} 
	}
        
        

	
    
}
