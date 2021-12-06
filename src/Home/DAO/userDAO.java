package Home.DAO;
import Home.model.user;
import Home.utilities.*;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class userDAO
{
    String query;
    user userobj=new user();
    Connection con=DBconnection.connect();


    public void createuser(user userobj) throws SQLException, ClassNotFoundException {


        query="INSERT INTO `user`(`username`, `password`, `type`) VALUES (?,?,?)";
        PreparedStatement statement=con.prepareStatement(query);
        statement.setString(1, userobj.getUsername());
        statement.setString(2, userobj.getPassword());
        statement.setString(3, userobj.getType());
        int check=statement.executeUpdate();
        if(check==1)
        {
            JOptionPane.showConfirmDialog(null,"user created");
        }
        else
        {
            JOptionPane.showConfirmDialog(null,"user not created ,please try again ");

        }









    }


    public void updateuser(){}



    public void deleteuser(){}


    public void selectuser(user userobj) throws SQLException, IOException {
        query="select * from user";
        PreparedStatement statement=con.prepareStatement(query);
        ResultSet st=statement.executeQuery();
        if(st.next())
        {
            JOptionPane.showMessageDialog(null,"welcome dear "+userobj.getUsername());
            url obj=new url();
            obj.show("Hospital signup","/Home/viewer/dashboard.fxml");

        }
        else
        {
            JOptionPane.showMessageDialog(null,"incorrect username or password try again");


        }




    }


}
