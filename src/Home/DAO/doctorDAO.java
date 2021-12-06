package Home.DAO;
import Home.model.*;
import Home.DAO.*;
import Home.utilities.DBconnection;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Home.utilities.*;

public class doctorDAO
{
    Connection con= DBconnection.connect();
    int check;

    Doctor doctorobj=new Doctor();
    String query;
    PreparedStatement statement;

    public void creatdoctor(Doctor doctorobj) throws SQLException, IOException {
        query="INSERT INTO `doctor`( `doctorname`, `address`, `phone`, `certificated`, `expiriment`, `salary`) VALUES (?,?,?,?,?,?)";
        statement=con.prepareStatement(query);
        statement.setString(1,doctorobj.getName());
        statement.setString(2,doctorobj.getAddress());
        statement.setString(3,doctorobj.getPhone());
        statement.setString(4,doctorobj.getCertificate());
        statement.setString(5,doctorobj.getExpiriment());
        statement.setString(6,doctorobj.getSelary());

        check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"Doctor Created Successfully" );
            url obj=new url();
            obj.show("doctor page","/Home/view/doctor.fxml");


        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }
    }

    public void updatedoctor(Doctor doctorobj) throws SQLException {
        query="UPDATE `doctor` SET `doctorname`=?,`address`=?,`phone`=?,`certificated`=?,`expiriment`=?,`salary`=? WHERE `doctorname` =?";
        statement=con.prepareStatement(query);
        statement.setString(1,doctorobj.getName());
        statement.setString(2,doctorobj.getAddress());
        statement.setString(3,doctorobj.getPhone());
        statement.setString(4,doctorobj.getCertificate());
        statement.setString(5,doctorobj.getExpiriment());
        statement.setString(6,doctorobj.getSelary());
        statement.setString(7,doctorobj.getName());
        check=statement.executeUpdate();
        if (check==1)
        {
            JOptionPane.showMessageDialog(null,"Doctor update Successfully" );
        }
        else
        {
            JOptionPane.showMessageDialog(null,"something went wrong " );

        }





    }

  public void deletedoctor(Doctor doctorobj) throws SQLException {
      query="DELETE FROM `doctor` WHERE `doctorname`=?";
      statement=con.prepareStatement(query);
      statement.setString(1,doctorobj.getName());
      check=statement.executeUpdate();
      if (check==1)
      {
          JOptionPane.showMessageDialog(null,"Doctor deleted Successfully" );
      }
      else
      {
          JOptionPane.showMessageDialog(null,"something went wrong " );

      }


  }

}
