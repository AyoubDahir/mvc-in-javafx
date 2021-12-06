package Home.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Home.model.*;
import Home.DAO.*;

import java.io.IOException;
import java.sql.SQLException;

public class loginController
{

    @FXML
    private TextField txtusername;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnlogin;

    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
        user userobj=new user();
        userobj.setUsername(txtusername.getText());
        userobj.setPassword(txtpassword.getText());

        userDAO userDAOobj=new userDAO();
        userDAOobj.selectuser(userobj);

    }
}
