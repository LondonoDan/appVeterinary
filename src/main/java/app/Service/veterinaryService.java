package app.Service;


import app.dao.LoginDao;
import app.dao.LonginDaolmp;
import app.dao.OwnerDaoImp;
import app.dao.PersonDao;
import app.dao.PersonDaoImp;
import app.dtos.OwnerDto;
import app.dtos.PersonDto;
import app.dtos.PetDto;
import app.dtos.SessionDto;
import java.util.Arrays;
import java.util.List;
import app.dao.OwnerDao;
import app.dao.PetDao;
import app.dao.PetDaoImp;

public class veterinaryService implements VeterinaryServic, LoginService {
   
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
			throw new Exception("usuario no valido");
		}
		if (!personDto.getPassword().equals(personDtoValidate.getPassword())) {
			throw new Exception("usuario o contraseña incorrectos");
		} 
		personDto.setRol(personDtoValidate.getRol());
		LoginDao loginDao = new LonginDaolmp();
		SessionDto sesionDto = loginDao.login(personDtoValidate);
		setSesionID(sesionDto.getId());
		System.out.println("se inicia la sesion " + sessionId);
	}
        
        
        @Override
            public void petCreate(PetDto petDto) throws Exception {
            PetDao petDao = new PetDaoImp();
            petDao.createPet(petDto);
            System.out.println("se ha insertado una mascota");
    }
        
         @Override
                public void createOwner(OwnerDto ownerDto) throws Exception {
                OwnerDao OwnerDao = new OwnerDaoImp();
		OwnerDao.createPropietary(ownerDto);
		System.out.println("se ha insertado un propietario de mascota");
    }
        


    @Override
	public void logout() throws Exception {
		LoginDao loginDao = new LonginDaolmp();
		loginDao.logout(sessionId);
		setSesionID(0);
	}

    

   

    

}
