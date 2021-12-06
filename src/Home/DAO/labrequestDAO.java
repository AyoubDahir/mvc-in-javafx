package Home.DAO;

import Home.utilities.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Home.model.*;

import javax.swing.*;


public class labrequestDAO
{
    Connection con= DBconnection.connect();
    PreparedStatement statement;
    int check;
    String query;

    public void createdRequest(labrequest labrequestobj) throws SQLException {
        query="INSERT INTO `labrequest`( `patientid`, `resultname`, `statue`) VALUES (?,?,?)";
        statement=con.prepareStatement(query);
        statement.setString(1,labrequestobj.getPatientid());
        statement.setString(2,labrequestobj.getResultname());
        statement.setString(3,labrequestobj.getState());
        check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"request added Successfully" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }

    }

    public void updaterequest(labrequest labrequestobj) throws SQLException {
        query="UPDATE `labrequest` SET `patientid`=?,`resultname`=?,`statue`=? WHERE =`patientid`=?";
        statement=con.prepareStatement(query);
        statement.setString(1,labrequestobj.getPatientid());
        statement.setString(2,labrequestobj.getResultname());
        statement.setString(3,labrequestobj.getState());
        check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"request updated Successfully" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }

    }

    public void deleterequest(labrequest labrequestobj) throws SQLException {
        query="DELETE FROM `labrequest` WHERE `patientid`=?";
        statement=con.prepareStatement(query);
        statement.setString(1,labrequestobj.getPatientid());
        check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"request deleted Successfully" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }

    }
}
