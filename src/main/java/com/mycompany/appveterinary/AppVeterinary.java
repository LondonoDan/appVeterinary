package com.mycompany.appveterinary;


import app.controller.LoginController;
import app.dtos.PetDto;
import java.util.Scanner;

public class AppVeterinary {

    private static Scanner reader = new Scanner(System.in);
	private static LoginController loginController = new LoginController();
        
        
        
	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			try {
                            run = runApplication();
                            //Connection con = MYSQLConnection.getConnection();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.print("deteniendo la aplicacion");
	}

	public static boolean runApplication() throws Exception {
		String menu = "!Bienvenido a la veterinaria PetCare!"
                        + "\n"
                        
                        + "\n 1. Para iniciar sesion "
                        + "\n 2. Para cerrar la aplicación ";
		System.out.println(menu);
		String option = reader.nextLine();
		switch (option) {
		case "1": {
			loginController.login();
			return true;
		}
		case "2": {
			return false;
		}
		default: {
			System.out.print("ingrese una opcion valida");
			return true;
		}

		}

	}
    
}
