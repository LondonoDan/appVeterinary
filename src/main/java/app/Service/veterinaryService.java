package app.Service;

import app.dao.HistoryClinicalImp;
import app.dao.LoginDao;
import app.dao.LonginDaolmp;
import app.dao.PersonDao;
import app.dao.PersonDaoImp;
import app.dtos.PersonDto;
import app.dtos.PetDto;
import app.dtos.SessionDto;
import java.util.Arrays;
import java.util.List;
import app.dao.PetDao;
import app.dao.PetDaoImp;
import app.dao.clinicalHistoryDao;
import app.dtos.clinicalHistoryDto;

public class veterinaryService implements VeterinaryServic, LoginService {
    List<String> roles = Arrays.asList("Veterinario", "Administrativo", "Vendedor","Usuario");
   
	private static long sessionId = 0L;
            
         @Override
            public void setSesionID(long sesionId) {
		sessionId = sesionId;
            }
    
        @Override
            public void login(PersonDto personDto) throws Exception {
		PersonDao personDao = new PersonDaoImp();
		PersonDto personDtoValidate = personDao.findUserByUserName(personDto);
		if (personDtoValidate == null) {
			throw new Exception("Usuario no valido");
		}
		if (!personDto.getPassword().equals(personDtoValidate.getPassword())) {
			throw new Exception("Usuario o contraseña incorrectos");
		} 
		personDto.setRol(personDtoValidate.getRol());
		LoginDao loginDao = new LonginDaolmp();
		SessionDto sesionDto = loginDao.login(personDtoValidate);
		setSesionID(sesionDto.getId());
		System.out.println("Se inicia la sesion " + sessionId);
            }
            
                @Override
                public void createUser(PersonDto personDto) throws Exception {
                    if (!roles.contains(personDto.getRol())) {
			throw new Exception("El rol no es valido");
                        }
                    PersonDao personDao = new PersonDaoImp();
                    if (personDao.findUserExist(personDto)) {
			throw new Exception("Ya existe un usuario con esa cedula");
                        }
                    if (personDao.existUserByUserName(personDto)) {
			throw new Exception("Ya existe el usuario");
                        }
                    personDao.createPerson(personDto);
                    System.out.println("Se ha creado el usuario con exito");
                }
        
        
        @Override
            public void petCreate(PetDto petDto) throws Exception {
            
		PersonDto personDto = new PersonDto(petDto.getCedula().getcedula());
                PersonDao personDao = new PersonDaoImp();
		if (!personDao.findUserExist(personDto)) {
                    throw new Exception("No existe un propietario con la cedula ingresada");
                } 
                PetDao petDao = new PetDaoImp();    
                petDao.createPet(petDto);
                System.out.println("Se ha creado una mascota con exito");
            }
      

        @Override
        public void create(clinicalHistoryDto clinicalHistoryDto) throws Exception {
            
            PersonDto personDto = new PersonDto(clinicalHistoryDto.getId().getcedula());
                PersonDao personDao = new PersonDaoImp();
		if (!personDao.findUserExist(personDto)) {
                    throw new Exception("No existe un propietario con la cedula ingresada");
                } 
            
            PersonDto PersonDto = new PersonDto(clinicalHistoryDto.getCedula().getcedula());
                PersonDao PersonDao = new PersonDaoImp();
		if (!PersonDao.findUserExist(PersonDto)) {
                    throw new Exception("No existe un veterinario con la cedula ingresada");
                } 
            clinicalHistoryDao clinicalHistoryDao = new HistoryClinicalImp();
            clinicalHistoryDao.create(clinicalHistoryDto);
            System.out.println("Se ha creado la historia clinica");    
        }

        @Override
	public void logout() throws Exception {
		LoginDao loginDao = new LonginDaolmp();
		loginDao.logout(sessionId);
		setSesionID(0);
	}
}
