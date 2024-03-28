package app.Service;


import app.dtos.PersonDto;
import app.dtos.PetDto;
import app.dtos.clinicalHistoryDto;


public interface VeterinaryServic {
   public void createUser(PersonDto personDto) throws Exception;
   public void petCreate(PetDto petDto) throws Exception; 
   public void create(clinicalHistoryDto clinicalHistoryDto) throws Exception;

    
}
