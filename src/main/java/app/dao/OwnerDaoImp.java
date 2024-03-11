package app.dao;

import app.Config.MYSQLConnection;
import app.dtos.OwnerDto;
import app.dtos.PersonDto;
import app.dtos.PetDto;
import appModels.Owner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class OwnerDaoImp implements OwnerDao{
    
    public Connection connection = MYSQLConnection.getConnection();


    @Override
    public void createPropietary(OwnerDto ownerDto) throws Exception {
        
        String query = "INSERT INTO PROPIETARIO(CEDULA,NOMBRE,EDAD) VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setLong(i++, ownerDto.getId());
		preparedStatement.setString(i++, ownerDto.getFullName());
		preparedStatement.setInt(i++, ownerDto.getAge());
		preparedStatement.execute();
		preparedStatement.close();
                
    }
    
    @Override
	public boolean findUserExist(OwnerDto ownerDto) throws Exception {
		String query = "SELECT 1 FROM PERSONA WHERE CEDULA = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, ownerDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean userExists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return userExists;
	}
        
        @Override
	public OwnerDto findUserById(OwnerDto ownerDto) throws Exception {
		String query = "SELECT CEDULA,NOMBRE,EDAD, FROM PROPIETARIO WHERE ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, ownerDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		if(resulSet.next()) {
			Owner owner = new Owner();
			ownerDto.setId(resulSet.getLong("CEDULA"));
			ownerDto.setFullName(resulSet.getString("NOMBRE"));
			ownerDto.setAge(resulSet.getInt("EDAD"));
			
			resulSet.close();
			preparedStatement.close();
			return new OwnerDto(owner);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}
    
    
    
    
    
    
   
    
    
    
}
