package app.dao;

import app.Config.MYSQLConnection;
import app.dtos.PersonDto;
import appModels.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PersonDaoImp implements  PersonDao{
    
    public Connection connection = MYSQLConnection.getConnection();


	@Override
	public void createPerson(PersonDto personDto) throws Exception {
		String query = "INSERT INTO PERSONA(CEDULA,NOMBRE,ROLE,EDAD,USERNAME,PASSWORD) VALUES (?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setLong(i++, personDto.getId());
		preparedStatement.setString(i++, personDto.getFullName());
		preparedStatement.setString(i++, personDto.getRol());
                preparedStatement.setInt(i++, personDto.getAge());
		preparedStatement.setString(i++, personDto.getUserName());
		preparedStatement.setString(i++, personDto.getPassword());
		preparedStatement.execute();
		preparedStatement.close();
	}

	@Override
	public boolean findUserExist(PersonDto personDto) throws Exception {
		String query = "SELECT 1 FROM PERSONA WHERE CEDULA = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, personDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean userExists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return userExists;
	}

	@Override
	public PersonDto findUserById(PersonDto personDto) throws Exception {
		String query = "SELECT CEDULA,FULLNAME,USERNAME,PASSWORD,ROL FROM PERSONA WHERE ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, personDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		if(resulSet.next()) {
			Person person = new Person();
			person.setId(resulSet.getLong("CEDULA"));
			person.setFullName(resulSet.getString("NOMBRE"));
			person.setRol(resulSet.getString("ROLE"));
			person.setUserName(resulSet.getString("USERNAME"));
			person.setPassword(resulSet.getString("PASSWORD"));
			resulSet.close();
			preparedStatement.close();
			return new PersonDto(person);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}

	@Override
	public boolean existUserByUserName(PersonDto personDto) throws Exception {
		String query = "SELECT 1 FROM PERSONA WHERE USERNAME = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, personDto.getUserName());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean userExists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return userExists;
	}

	@Override
	public PersonDto findUserByUserName(PersonDto personDto) throws Exception {
		String query = "SELECT CEDULA,NOMBRE, ROLE,USERNAME,PASSWORD,EDAD FROM PERSONA WHERE USERNAME = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, personDto.getUserName());
		ResultSet resulSet = preparedStatement.executeQuery();
		if(resulSet.next()) {
			Person person = new Person();
			person.setId(resulSet.getLong("CEDULA"));
			person.setFullName(resulSet.getString("NOMBRE"));
			person.setRol(resulSet.getString("ROLE"));
			person.setUserName(resulSet.getString("USERNAME"));
			person.setPassword(resulSet.getString("PASSWORD"));
			resulSet.close();
			preparedStatement.close();
			return new PersonDto(person);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}
}
