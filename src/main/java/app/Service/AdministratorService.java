package app.service;


import app.dtos.PersonDto;


public interface AdministratorService {
   public void createUser(PersonDto personDto) throws Exception;
    
}
