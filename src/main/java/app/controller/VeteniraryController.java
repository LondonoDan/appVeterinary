
package app.controller;

import app.Service.VeterinaryServic;
import app.Service.veterinaryService;
import app.dao.OwnerDao;
import app.dao.OwnerDaoImp;
import app.dtos.OwnerDto;
import app.dtos.PersonDto;
import app.dtos.PetDto;
import app.validators.OwnerValidator;
import app.validators.PetInputsValidator;
import java.util.Scanner;


public class VeteniraryController {
    
    //Este es el menú del veterinario, en este menú el veterinario puede, consultar ordenes
    //crear usuarios, consultar el historial clinico, tambien puede editar el historial clinico y eliminar 
    
    
    private static PetInputsValidator petInputsValidator = new PetInputsValidator();
    private static VeterinaryServic veterinaryService = new veterinaryService();
    private static OwnerValidator ownerValidator = new OwnerValidator();
    private static Scanner reader = new Scanner(System.in);
    
    private static final String MENU = "Ingresaste al perfil de Veterinario "
            + "\n" 
            
            + "\n1. Ingresar un propietario"
            + "\n2. Agregar una mascota "
            + "\n3. Consultar historial clinico"
            + "\n4. Consulta de ordenes"
            + "\n5. Para cerrar Sesion";
    
    
    
    private void createPet() throws Exception {
        System.out.println("ingrese la cedula del usuario");
	Long id = petInputsValidator.idValidator(reader.nextLine());
        OwnerDto ownerDto = new OwnerDto(id);
        
       OwnerDao OwnerDao = new OwnerDaoImp();
		if (!OwnerDao.findUserExist(ownerDto)) {
			throw new Exception("no existe un usuario con esa cedula");
		}
       
        
        System.out.println("ingrese el nombre de la mascota");
        String name = reader.nextLine();
        petInputsValidator.nameValidator(name);
        
        System.out.println("ingrese la edad de la mascota");
        int age = petInputsValidator.ageValidator(reader.nextLine());
        
        System.out.println("ingrese la especie de la mascota");
        String specie   = reader.nextLine();
        petInputsValidator.speciesValidator(specie);
        
        System.out.println("ingrese la raza de la mascota");
        String breed   = reader.nextLine();
        petInputsValidator.breedValidator(breed);
        
        System.out.println("ingrese caracteristica de la mascota");
        String characteristics = reader.nextLine();
        petInputsValidator.characteristicsValidator(characteristics);
        
        System.out.println("ingrese el peso de la mascota");
        double weight = petInputsValidator.weightValidator(reader.nextLine());
        
        System.out.println("se cumplieron todas las validaciones");        
        PetDto petDto = new PetDto(name, ownerDto, age, specie, breed, characteristics, weight);
        veterinaryService.petCreate(petDto);
        
        
    }
    
    
    private void createPropietary() throws Exception {
		System.out.println("ingrese el nombre completo del propietario");
		String fullName = reader.nextLine();
		ownerValidator.FullNameValidator(fullName);
		System.out.println("ingrese la cedula del usuario");
		Long id = ownerValidator.idValidator(reader.nextLine());
                System.out.println("ingrese la edad del usuario");
                int age = petInputsValidator.ageValidator(reader.nextLine());
		OwnerDto ownerDto = new OwnerDto(id, fullName,age);
		System.out.println("se cumplieron todas las validaciones");
                veterinaryService.createOwner(ownerDto);
		
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
			createPropietary();
			return true;
		}
		case "2": {
			createPet();
			return true;
		}
                case "3": {
			
			return true;
		}
                
                case "4": {
			return false;
		}
		case "5": {
			return false;
		}
		default :{
			System.out.println("ingrese una opcion valida");
			return true;
		}
            }
	}
}
