
package app.controller;

import app.Service.VeterinaryServic;
import app.Service.veterinaryService;
import app.dao.PersonDao;
import app.dao.PersonDaoImp;
import app.dtos.OrderDto;
import app.dtos.PersonDto;
import app.dtos.PetDto;
import app.dtos.clinicalHistoryDto;
import app.validators.PersonInputsValidator;
import app.validators.PetInputsValidator;
import app.validators.historyClinicalValidator;
import static java.lang.System.currentTimeMillis;
import java.sql.Timestamp;
import java.util.Scanner;


public class VeteniraryController {
    
    //Este es el menú del veterinario, en este menú el veterinario puede, consultar ordenes
    //crear usuarios, consultar el historial clinico, tambien puede editar el historial clinico y eliminar 
    
    
    private static PetInputsValidator petInputsValidator = new PetInputsValidator();
    private static VeterinaryServic veterinaryService = new veterinaryService();
    private static PersonInputsValidator personInputValidator = new PersonInputsValidator();

    private static historyClinicalValidator historyClinicalValidator = new historyClinicalValidator();
    private static Scanner reader = new Scanner(System.in);
    private PersonDto personDto;
    
    private static final String MENU = "Ingresaste al perfil de Veterinario "
            + "\n" 
            
            + "\n1. Ingresar un propietario"
            + "\n2. Ingresar una mascota "
            + "\n3. Crear historia clinica"
            + "\n4. Crear orden"
            + "\n5. Para cerrar Sesion";
    
    
    
    private void createPet() throws Exception {
        System.out.println("ingrese la cedula del usuario");
        Long cedula = petInputsValidator.idValidator(reader.nextLine());
        PersonDto personDto = new PersonDto(cedula);
       
                
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
        PetDto petDto = new PetDto(name, personDto, age, specie, breed, characteristics, weight);
        veterinaryService.petCreate(petDto);
    }
    
    
    private void createPropietary() throws Exception {
        
        
                
		System.out.println("ingrese el nombre completo del usuario");
		String fullName = reader.nextLine();
		personInputValidator.fullNameValidator(fullName);
                System.out.println("ingrese la edad del usuario");
                int age = personInputValidator.ageValidator(reader.nextLine());
		System.out.println("ingrese la cedula del usuario");
		Long id = personInputValidator.cedulaValidator(reader.nextLine());
		System.out.println("ingrese el rol completo: Administrativo, Veterinario, Vendedor, Usuario");
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
                veterinaryService.createUser(personDto);
		
	}
    
    private void create()throws Exception {
       long currentTimeMillis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTimeMillis);
        System.out.println("Timestamp actual: " + timestamp);
        
        System.out.println("ingrese la cedula del usuario");
        Long id = historyClinicalValidator.idValidator(reader.nextLine());
        PersonDto PersonDto = new PersonDto(id);
        
        System.out.println("ingrese la cédula del profesional que atiende"); 
        Long cedula = historyClinicalValidator.cedulaValidator(reader.nextLine());
        PersonDto personDto = new PersonDto(cedula);
        
        System.out.println("Ingrese el motivo de la consulta ");
        String motive = reader.nextLine();
        historyClinicalValidator.motivedValidator(motive);
        
        System.out.println("Ingrese la sintomatologia que presenta la mascota ");
        String symptomatology = reader.nextLine();
        historyClinicalValidator.symptomatologyValidator(symptomatology);
        
        System.out.println("Ingrese el procedimiento a realizar ");
        String procedure = reader.nextLine();
        historyClinicalValidator.procedureValidator(procedure);
        
        System.out.println("Ingrese los medicamentos a aplicar ");
        String medicines = reader.nextLine();
        historyClinicalValidator.medicinesValidator(medicines);
        
        System.out.println("¿La mascota cuenta con vacunas? ");
        String vaccines = reader.nextLine();
        historyClinicalValidator.vaccinesValidator(vaccines);
        
        System.out.println("¿La mascota tiene alergias? ");
        String allergy = reader.nextLine();
        historyClinicalValidator.allergyValidator(allergy);
        
        System.out.println("Detallar el procedimiento a generar");
        String detailProcedure = reader.nextLine();
        historyClinicalValidator.detailProcedureValidator(detailProcedure);
        
        System.out.println("Ingrese el diagnostico de la mascota");
        String diagnosis = reader.nextLine();
        historyClinicalValidator.diagnosisValidator(diagnosis);
        
        System.out.println("Ingrese la dosis de medicación a aplicar");
        String medicationDosage = reader.nextLine();
        historyClinicalValidator.medicationDosageValidator(medicationDosage);
        System.out.println("se cumplieron todas las validaciones");
        clinicalHistoryDto clinicalHistoryDto = new clinicalHistoryDto(currentTimeMillis(), PersonDto, personDto, motive, symptomatology, procedure, medicines, 0, vaccines, allergy, detailProcedure, diagnosis, medicationDosage, 0);
        veterinaryService.create(clinicalHistoryDto);
        }
    
    private OrderDto createOrder()throws Exception {
                OrderDto orderDto = new OrderDto();
                
		veterinaryService.createOrder(orderDto);
                
                return orderDto;        
        
        
        
       
        
       
    
    }
    
        
    
    public void session(PersonDto personDto) {
                this.personDto = personDto;
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
			
			create();
                        
                        return true;
		}
                
                case "4": {
                    createOrder();
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
