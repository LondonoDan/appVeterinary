package app.service;

import app.Service.LoginService;
import app.dao.LoginDao;
import app.dao.LonginDaolmp;
import app.dao.PersonDao;
import app.dao.PersonDaoImp;
import app.dtos.PersonDto;
import app.dtos.SessionDto;
import java.util.Arrays;
import java.util.List;

public class AdminService implements AdministratorService,LoginService {
    List<String> roles = Arrays.asList("veterinario", "Administrativo", "Vendedor");
    private static long sessionId = 0L;

    @Override
   public void createUser(PersonDto personDto) throws Exception {
		if (!roles.contains(personDto.getRol())) {
			throw new Exception("el rol no es valido");
		}
		PersonDao personDao = new PersonDaoImp();
		if (personDao.findUserExist(personDto)) {
			throw new Exception("ya existe un usuario con esa cedula");
		}
		if (personDao.existUserByUserName(personDto)) {
			throw new Exception("ya existe el usuario");
		}
		personDao.createPerson(personDto);
		System.out.println("se ha creado el usuario");
	}
   
   
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
		System.out.println("¡Bienvenido! se inicia la sesion " + sessionId );

    
}
        
    @Override
        public void logout() throws Exception {
	LoginDao loginDao = new LonginDaolmp();
	loginDao.logout(sessionId);
	setSesionID(0);
	}

}
