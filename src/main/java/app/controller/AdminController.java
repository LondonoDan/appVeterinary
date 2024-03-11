package app.controller;

import app.dtos.PersonDto;
import app.service.AdminService;
import app.service.AdministratorService;
import app.validators.PersonInputsValidator;
import java.util.Scanner;

public class AdminController {
    
    private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
    private static Scanner reader = new Scanner(System.in);
	private static  AdministratorService administratorService = new AdminService();
	private static final String MENU = "Bienvenido! ingresaste al perfil Administrativo"
                + "\n"
                
                + "\n1.Crear usuario"
                + "\n2.Para cerrar Sesion";
        
    
        
        
        private void createUser() throws Exception {
                System.out.println("\n");
		System.out.println("ingrese el nombre completo del usuario");
		String fullName = reader.nextLine();
		personInputValidator.fullNameValidator(fullName);
                System.out.println("ingrese la edad del usuario");
                int age = personInputValidator.ageValidator(reader.nextLine());
		System.out.println("ingrese la cedula del usuario");
		Long id = personInputValidator.idValidator(reader.nextLine());
		System.out.println("ingrese el rol completo: Administrativo, Veterinario, Vendedor");
		String rol = reader.nextLine();
		personInputValidator.fullNameValidator(rol);
		System.out.println("ingrese nombre de login");
		String userName = reader.nextLine();
		personInputValidator.fullNameValidator(userName);
		System.out.println("ingrese la contraseña");
		String password = reader.nextLine();
		personInputValidator.fullNameValidator(password);
		PersonDto personDto = new PersonDto(id, fullName, rol,age, userName, password);
		System.out.println("se cumplieron todas las validaciones");
		administratorService.createUser(personDto);
	}
        
        
        public void session() {
		boolean runApp = true;
		while (runApp) {
			try {
				System.out.println(MENU);
				String option = reader.nextLine();
				runApp=menu(option);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
	
	private boolean menu(String option) throws Exception{
		switch (option) {
		case "1":{
			createUser();
			return true;
		}
	
		case "2": {
			return false;
		}
		default :{
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}
        
        
}



