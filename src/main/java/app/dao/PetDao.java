package app.dao;

import app.dtos.PetDto;


public interface PetDao {
    public void createPet(PetDto petDto) throws Exception;
    
}
