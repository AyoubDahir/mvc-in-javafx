package Home.controller;

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

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Home.DAO.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PatientController implements Initializable
{
    @FXML
    private TableView<patient> patientTable;

    @FXML
    private TableColumn<patient, String> colname;

    @FXML
    private TableColumn<patient, String> colage;

    @FXML
    private TableColumn<patient, String> coladdress;

    @FXML
    private TableColumn<patient, String> colphone;

    @FXML
    private TableColumn<patient, String> coldob;

    @FXML
    private TableColumn<patient, String> coldoctorid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtage;

    @FXML
    private TextField txtphone;
    @FXML
    private ComboBox<String> comboid;

    @FXML
    private TextField txtdob;

    @FXML
    private ComboBox<String> comboaddres;

    @FXML
    void backpatient(ActionEvent event) {

    }

    @FXML
    void clearpatient(ActionEvent event)
    {

    }

    @FXML
    void deletepatient(ActionEvent event) throws SQLException {
        patient patientobj=new patient();
        patientobj.setName(txtname.getText());
        patientobj.setAge(txtage.getText());
        patientobj.setDOb(txtdob.getText());
        patientobj.setUnderDoctorB(comboid.getValue());
        patientobj.setPhone(txtphone.getText());
        patientobj.setAddress(comboaddres.getValue());

        patientDAO patientDAOobj=new patientDAO();
        patientDAOobj.deletepatient(patientobj);

    }

    @FXML
    void savepatient(ActionEvent event) throws SQLException {
        patient patientobj=new patient();
        patientobj.setName(txtname.getText());
        patientobj.setAge(txtage.getText());
        patientobj.setDOb(txtdob.getText());
        patientobj.setUnderDoctorB(comboid.getValue());
        patientobj.setPhone(txtphone.getText());
       patientobj.setAddress(comboaddres.getValue());

       patientDAO patientDAOobj=new patientDAO();
       patientDAOobj. createpatient(patientobj);






    }
    @FXML
    void updatepatient(ActionEvent event) throws SQLException {
        patient patientobj=new patient();
        patientobj.setName(txtname.getText());
        patientobj.setAge(txtage.getText());
        patientobj.setDOb(txtdob.getText());
        patientobj.setUnderDoctorB(comboid.getValue());
        patientobj.setPhone(txtphone.getText());
        patientobj.setAddress(comboaddres.getValue());

        patientDAO patientDAOobj=new patientDAO();
        patientDAOobj.updatepatient(patientobj);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {


        mousis();



        ObservableList<String>address= FXCollections.observableArrayList("Hargeisa","gabilay","burco","borama","ceerigabo","berbera","saylac");
        comboaddres.setItems(address);
        Connection con= DBconnection.connect();
        String query="select * from doctor";
        ObservableList<String>doctorid=FXCollections.observableArrayList();

        try {
            PreparedStatement statement=con.prepareStatement(query);
            ResultSet rs=statement.executeQuery();
            while(rs.next())

            {
                doctorid.add(rs.getString("doctorid"));





            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        comboid.setItems(doctorid);





        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colage.setCellValueFactory(new PropertyValueFactory<>("age"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        coldob.setCellValueFactory(new PropertyValueFactory<>("DOb"));
        coldoctorid.setCellValueFactory(new PropertyValueFactory<>("underDoctorB"));




        String patientquery="SELECT * FROM `patient`";
        ObservableList<patient>patientlist=FXCollections.observableArrayList();
        try {
            PreparedStatement patietnstatement=con.prepareStatement(patientquery);
            ResultSet rs7=patietnstatement.executeQuery();
            while (rs7.next())
            {
                patientlist.add(new patient(


                        rs7.getString("name"),rs7.getString("age"),rs7.getString("address"),rs7.getString("phone"),rs7.getString("dob"),rs7.getString("doctor")
                ));

                System.out.println(rs7.getFetchSize());



            }
            patientTable.setItems(patientlist);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void mousis()
    {
        patient patientt=new patient();
        patientt=patientTable.getSelectionModel().getSelectedItem();
        if (patientt!=null)
        {
            txtname.setText(patientt.getName());
            txtage.setText(patientt.getAge());
            comboaddres.setValue(patientt.getAddress());
            txtphone.setText(patientt.getPhone());
            txtdob.setText(patientt.getDOb());
            comboid.setValue(patientt.getUnderDoctorB());


        }

    }

    @FXML
    void showitems(MouseEvent event)
    {
        mousis();

    }



}
