package Home.controller;

import javafx.beans.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Home.model.*;
import Home.DAO.*;
import Home.utilities.*;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class signupController  implements Initializable
{
    @FXML
    private TextField txtusername;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnregister;

    @FXML
    private ComboBox<String> cmotype;



    @FXML
    void registeruser(ActionEvent event) throws SQLException, ClassNotFoundException {
        user userobj=new user();


        userobj.setUsername(txtusername.getText());
        userobj.setPassword(txtpassword.getText());
        userobj.setType(cmotype.getValue());

        userDAO userDAOobj=new userDAO();
        userDAOobj.createuser(userobj);




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ObservableList<String> type= FXCollections.observableArrayList("Admin","patient","doctor","nurse");
        cmotype.setItems(type);

    }

    @FXML
    void showsigup(ActionEvent event) throws IOException {
        url obj=new url();
        obj.show("signup page","/Home/viewer/login.fxml");
        txtpassword.getScene().getWindow().hide();


    }
}
