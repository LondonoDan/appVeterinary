package app.dao;

import app.Config.MYSQLConnection;
import app.dtos.PetDto;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PetDaoImp implements PetDao{
    public Connection connection = MYSQLConnection.getConnection();
    
     @Override
    public void createPet(PetDto petDto) throws Exception {
        
        String query = "INSERT INTO MASCOTA(NOMBRE,EDAD,PROPIETARIO,RAZA,CARACTERISTICAS,ESPECIE,PESO) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setString(i++, petDto.getName());
                preparedStatement.setInt(i++, petDto.getAge());
                preparedStatement.setLong(i++,petDto.getCedula().getcedula());
                preparedStatement.setString(i++, petDto.getBreed());
                preparedStatement.setString(i++, petDto.getCharacteristics());
                preparedStatement.setString(i++, petDto.getSpecies());
                preparedStatement.setDouble(i++, petDto.getWeight());
                
		preparedStatement.execute();
		preparedStatement.close();
    }
    
    
    
    
}
