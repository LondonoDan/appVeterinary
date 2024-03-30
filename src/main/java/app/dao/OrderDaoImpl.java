package app.dao;

import app.Config.MYSQLConnection;
import app.dtos.OrderDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class OrderDaoImpl implements OrderDao {
        public Connection connection = MYSQLConnection.getConnection();

    @Override
    public long createOrder(OrderDto orderDto) throws Exception {
        String query = "INSERT INTO ORDEN(MASCOTA,PROPIETARIO,MEDICO,MEDICAMENTO,FECHA) VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setLong(i++, orderDto.getPetId());
		preparedStatement.setLong(i++, orderDto.getOwnerID().getCedula());
		preparedStatement.setLong(i++, orderDto.getVeterinarianID().getCedula());
		preparedStatement.setString(i++, orderDto.getDosage());
		preparedStatement.setDate(i++, orderDto.getGenerationDate());
		preparedStatement.execute();
                query = "SELECT ID FROM ORDEN WHERE FECHA = ? AND MEDICAMENTO = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setDate(1, orderDto.getGenerationDate());
		preparedStatement.setString(2, orderDto.getDosage());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			long id = resulSet.getLong("ID");
			resulSet.close();
			preparedStatement.close();
			return id;
		}
		resulSet.close();
		preparedStatement.close();
		return (Long) null;
    }
}
