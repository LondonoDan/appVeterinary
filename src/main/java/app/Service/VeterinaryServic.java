package app.Service;

import app.dtos.OwnerDto;
import app.dtos.PetDto;
import app.dtos.clinicalHistoryDto;


public interface VeterinaryServic {
   public void createOwner(OwnerDto ownerDto) throws Exception;
   public void petCreate(PetDto petDto) throws Exception; 
   public void create(clinicalHistoryDto clinicalHistoryDto) throws Exception;

    
}
