package app.Service;

import app.dtos.PersonDto;



public interface LoginService {
	public void setSesionID(long sesionId);
	public void login(PersonDto personDto)throws Exception;	
	public void logout() throws Exception;
}
