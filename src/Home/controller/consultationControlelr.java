package Home.controller;
import Home.model.*;
import Home.utilities.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Home.model.*;
import Home.DAO.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Home.DAO.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class consultationControlelr implements Initializable
{
    @FXML
    private ComboBox<String> combopatientid;

    @FXML
    private TextField txtsymptoms;

    @FXML
    private ComboBox<String> combolabrequest;

    @FXML
    private TextField txtdiagnosis;

    @FXML
    private TextField txttreatment;

    @FXML
    private TextField txtcomment;

    @FXML
    private TableView<cunsultation> cunsultationTable;

    @FXML
    private TableColumn<cunsultation, String> colpatientid;

    @FXML
    private TableColumn<cunsultation, String> colSymptoms;



    @FXML
    private TableColumn<cunsultation, String> coldiagnosis;

    @FXML
    private TableColumn<cunsultation, String> coltreatment;

    @FXML
    private TableColumn<cunsultation, String> colcomment;

    @FXML
    void delete(ActionEvent event) throws SQLException {
        cunsultation conobj=new cunsultation();
        conobj.setPatientid(combopatientid.getValue());
        conobj.setDiagnosis(txtdiagnosis.getText());
        conobj.setComment(txtcomment.getText());
        conobj.setSymptoms(txtsymptoms.getText());

        conobj.setTearment(txttreatment.getText());

        cunsultationDAO cunsultationDAOobj=new cunsultationDAO();
        cunsultationDAOobj.deletecunsultation(conobj);

    }

    @FXML
    void registercunsult(ActionEvent event) throws SQLException {
        cunsultation conobj=new cunsultation();
        conobj.setPatientid(combopatientid.getValue());
        conobj.setDiagnosis(txtdiagnosis.getText());
        conobj.setComment(txtcomment.getText());
        conobj.setSymptoms(txtsymptoms.getText());

        conobj.setTearment(txttreatment.getText());

        cunsultationDAO cunsultationDAOobj=new cunsultationDAO();
        cunsultationDAOobj.createconsultation(conobj);

    }

    @FXML
    void update(ActionEvent event) throws SQLException {
        cunsultation conobj=new cunsultation();
        conobj.setPatientid(combopatientid.getValue());
        conobj.setDiagnosis(txtdiagnosis.getText());
        conobj.setComment(txtcomment.getText());
        conobj.setSymptoms(txtsymptoms.getText());

        conobj.setTearment(txttreatment.getText());

        cunsultationDAO cunsultationDAOobj=new cunsultationDAO();
        cunsultationDAOobj.updateconsultation(conobj);

    }

    @FXML
    void deletecunsultation(MouseEvent event) throws SQLException {
        cunsultation conobj=new cunsultation();
        conobj.setPatientid(combopatientid.getValue());
        conobj.setDiagnosis(txtdiagnosis.getText());
        conobj.setComment(txtcomment.getText());
        conobj.setSymptoms(txtsymptoms.getText());

        conobj.setTearment(txttreatment.getText());

        cunsultationDAO cunsultationDAOobj=new cunsultationDAO();
        cunsultationDAOobj.deletecunsultation(conobj);

    }

    public void show()
    {
        cunsultation cunsultationobj=cunsultationTable.getSelectionModel().getSelectedItem();
        if (cunsultationobj !=null)
        {
            combopatientid.setValue(cunsultationobj.getPatientid());
            txtsymptoms.setText(cunsultationobj.getSymptoms());
            txtdiagnosis.setText(cunsultationobj.getDiagnosis());
            txttreatment.setText(cunsultationobj.getTearment());
            txtcomment.setText(cunsultationobj.getComment());
        }



    }

    @FXML
    void showclicked(MouseEvent event)
    {
        show();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        show();



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
        combopatientid.setItems(patientidlist);








        colpatientid.setCellValueFactory(new PropertyValueFactory<>("patientid"));
        colSymptoms.setCellValueFactory(new PropertyValueFactory<>("symptoms"));
        coldiagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        coltreatment.setCellValueFactory(new PropertyValueFactory<>("tearment"));
        colcomment.setCellValueFactory(new PropertyValueFactory<>("comment"));


        String q="select * from cunsultation";
        ObservableList<cunsultation>cunsultationlist =FXCollections.observableArrayList();
        try {
            PreparedStatement statement=con.prepareStatement(q);
            ResultSet rs=statement.executeQuery();
            while (rs.next())
            {
             cunsultationlist.add(new cunsultation(
                     rs.getString("patientid"),rs.getString("Symptoms"),rs.getString("diagnosis"),rs.getString("treatment"),rs.getString("comment")
             ));
             cunsultationTable.setItems(cunsultationlist);


            }
            cunsultationTable.setItems(cunsultationlist);
            System.out.println(cunsultationTable);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
