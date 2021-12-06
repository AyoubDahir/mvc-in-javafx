package Home.DAO;
import Home.model.*;
import Home.utilities.*;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Home.model.*;

import javax.swing.*;

public class cunsultationDAO
{
    Connection con=DBconnection.connect();
    PreparedStatement statement;
    String query;
    int check;

    public void createconsultation (cunsultation cunsultationobj) throws SQLException {
        query="INSERT INTO `cunsultation`( `patientid`, `Symptoms`, `diagnosis`, `treatment`, `comment`) VALUES (?,?,?,?,?)";
        statement=con.prepareStatement(query);
        statement.setString(1,cunsultationobj.getPatientid());
        statement.setString(2,cunsultationobj.getSymptoms());

        statement.setString(3,cunsultationobj.getDiagnosis());
        statement.setString(4,cunsultationobj.getTearment());
        statement.setString(5,cunsultationobj.getComment());
        check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"consultation was aded" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }







    }


    public void updateconsultation(cunsultation cunsultationobj) throws SQLException {
        query="UPDATE `cunsultation` SET `patientid`=?,`Symptoms`=?,`diagnosis`=?,`treatment`=?,`comment`=? WHERE `patientid`=?";
        statement=con.prepareStatement(query);
        statement.setString(1,cunsultationobj.getPatientid());
        statement.setString(2,cunsultationobj.getSymptoms());
        statement.setString(3,cunsultationobj.getDiagnosis());
        statement.setString(4,cunsultationobj.getTearment());
        statement.setString(5,cunsultationobj.getComment());
        statement.setString(6,cunsultationobj.getPatientid());
        check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"consultation was updated" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }

    }

    public void deletecunsultation(cunsultation cunsultationobj) throws SQLException {
        query="DELETE FROM `cunsultation` WHERE `patientid`=?";
        statement=con.prepareStatement(query);
        statement.setString(1,cunsultationobj.getPatientid());
        check=statement.executeUpdate();

        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"something went wrong" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"consultation was deleted" );

        }

    }



}
