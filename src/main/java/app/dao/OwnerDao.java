package app.dao;

import app.dtos.OwnerDto;



public interface OwnerDao {
    public void createPropietary(OwnerDto ownerDto) throws Exception;
    public boolean findUserExist(OwnerDto ownerDto)throws Exception;
    
    
    
    
}
