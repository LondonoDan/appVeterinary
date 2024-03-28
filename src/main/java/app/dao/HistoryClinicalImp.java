package app.dao;

import app.Config.MYSQLConnection;
import app.dtos.clinicalHistoryDto;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class HistoryClinicalImp implements clinicalHistoryDao{
    
     public Connection connection = MYSQLConnection.getConnection();

    @Override
    public void create(clinicalHistoryDto clinicalHistoryDto) throws Exception {
        String query = "INSERT INTO HISTORIA(FECHA,MASCOTA,MEDICO,MOTIVO,SINTOMATOLOGIA,PROCEDIMIENTO,MEDICAMENTO,"
                + "ORDEN,VACUNACION,"
                + "ALERGIA,DETAlLES_PROCEDIMIENTO,"
                + "DIAGNOSIS,MEDICATIONDOSAGE,ORDERCANCELATION) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
                preparedStatement.setLong(i++, clinicalHistoryDto.getAdmissionDate());
                preparedStatement.setLong(i++, clinicalHistoryDto.getId().getcedula());
                preparedStatement.setLong(i++, clinicalHistoryDto.getCedula().getcedula());
                preparedStatement.setString(i++, clinicalHistoryDto.getMotive());
                preparedStatement.setString(i++, clinicalHistoryDto.getSymptomatology());
                preparedStatement.setString(i++, clinicalHistoryDto.getProcedure());
                preparedStatement.setString(i++, clinicalHistoryDto.getMedicines());
                preparedStatement.setInt(i++, clinicalHistoryDto.getOrder());
                preparedStatement.setString(i++, clinicalHistoryDto.getVaccines());
                preparedStatement.setString(i++, clinicalHistoryDto.getAllergy());
                preparedStatement.setString(i++, clinicalHistoryDto.getDetailProcedure());
                preparedStatement.setString(i++, clinicalHistoryDto.getDiagnosis());
                preparedStatement.setString(i++, clinicalHistoryDto.getMedicationDosage());
                preparedStatement.setInt(i++, clinicalHistoryDto.getOrdercancelation());
                preparedStatement.execute();
		preparedStatement.close();
    }
    
}
