package Home.controller;
import Home.utilities.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import Home.model.*;
import Home.DAO.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class labrequestController implements Initializable
{
    @FXML
    private ComboBox<String> comboid;

    @FXML
    private ComboBox<String> combotest;

    @FXML
    void save(ActionEvent event)
    {
        labrequest labrequestobj=new labrequest();




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        //seting combo box show
        ObservableList<String>requesdt=FXCollections.observableArrayList("blood test ","urine test","seroine test");
        combotest.setItems(requesdt);


        Connection con= DBconnection.connect();
        String query="select * from patient";
        ObservableList<String> patientidlist= FXCollections.observableArrayList();

        try {
            PreparedStatement statement=con.prepareStatement(query);
            ResultSet rs=statement.executeQuery();
            while(rs.next())

            {
                patientidlist.add(rs.getString("patient_id"));





            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        comboid.setItems(patientidlist);

    }
}
