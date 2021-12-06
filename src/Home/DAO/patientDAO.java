package Home.DAO;
import Home.model.*;
import Home.utilities.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class patientDAO
{
    Connection con=DBconnection.connect();
    String query ;
    ResultSet rs;
    PreparedStatement statement;
    int check;

    public void createpatient(patient patientobj) throws SQLException
    {
        query="INSERT INTO `patient`( `name`, `age`, `address`, `phone`, `dob`, `doctor`) VALUES (?,?,?,?,?,?)";
        statement=con.prepareStatement(query);
        statement.setString(1,patientobj.getName());
        statement.setString(2,patientobj.getAge());
        statement.setString(3,patientobj.getAddress());
        statement.setString(4,patientobj.getPhone());
        statement.setString(5,patientobj.getDOb());
        statement.setString(6,patientobj.getUnderDoctorB());
         check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"patient created Successfully" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }


    }

    public void updatepatient(patient patientobj) throws SQLException {
        query="UPDATE `patient` SET `name`=?,`age`=?,`address`=?,`phone`=?,`dob`=?,`doctor`=? WHERE `name`=?" ;
        statement=con.prepareStatement(query);
        statement.setString(1,patientobj.getName());
        statement.setString(2,patientobj.getAge());
        statement.setString(3,patientobj.getAddress());
        statement.setString(4,patientobj.getPhone());
        statement.setString(5,patientobj.getDOb());
        statement.setString(6,patientobj.getUnderDoctorB());
        statement.setString(7,patientobj.getName());

        check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"patient updated Successfully" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }


    }

    public void deletepatient(patient patientobj) throws SQLException {
        query="DELETE FROM `patient` WHERE `name`=?";
        statement=con.prepareStatement(query);
        statement.setString(1,patientobj.getName());
        check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"patient delete Successfully" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }


    }

}
