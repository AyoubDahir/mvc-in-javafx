package Home.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Home.model.*;

import Home.utilities.*;

import javax.swing.*;

public class labresultDAO
{
    Connection con= DBconnection.connect();
    PreparedStatement statement;
    int check;
    String query;


    public void createlabresult(labResult labResultobj) throws SQLException {
        query="INSERT INTO `labresult`(`patientid`, `labname`, `result`, `cost`) VALUES (?,?,?,?)";
        statement=con.prepareStatement(query);
        statement.setString(1,labResultobj.getPatientid());
        statement.setString(2,labResultobj.getLabname());
        statement.setString(3,labResultobj.getResult());
        statement.setString(4,labResultobj.getCost());
        check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"result added Successfully" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }


    }
    public void updatelabresult(labResult labResultobj) throws SQLException {
        query="UPDATE `labresult` SET `patientid`=?,`labname`=?,`result`=?,`cost`=? WHERE `patientid`=?";
        statement=con.prepareStatement(query);
        statement.setString(1,labResultobj.getPatientid());
        statement.setString(2,labResultobj.getLabname());
        statement.setString(3,labResultobj.getResult());
        statement.setString(4,labResultobj.getCost());
        statement.setString(4,labResultobj.getPatientid());
        check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"result updated Successfully" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }

    }
    public void deletelabresult(labResult labResultobj) throws SQLException {
        query="DELETE FROM `labresult` WHERE `patientid`=?";
        statement=con.prepareStatement(query);
        statement.setString(1,labResultobj.getPatientid());
        check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"result deleted Successfully" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }

    }
}
