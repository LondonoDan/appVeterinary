package app.Service;

import app.dtos.OwnerDto;
import app.dtos.PetDto;


public interface VeterinaryServic {
   public void createOwner(OwnerDto ownerDto) throws Exception;
   public void petCreate(PetDto petDto) throws Exception; 
    
}
