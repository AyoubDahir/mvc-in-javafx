package Home.controller;
import Home.model.Doctor;
import Home.utilities.DBconnection;
import com.mysql.cj.xdevapi.PreparableStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Home.DAO.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javax.print.Doc;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DoctorController implements Initializable
{




    @FXML
    private TextField txtsearch;
    @FXML
    private TableView<Doctor> doctorTable;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colphone;

    @FXML
    private TableColumn<?, ?> colcertificatation;

    @FXML
    private TableColumn<?, ?> colexipiriment;

    @FXML
    private TableColumn<?, ?> colsalary;

    @FXML
    private TextField txtname;
    @FXML
    private TextField txtsalary;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtcertificate;

    @FXML
    private TextField txtexpiriment;

    @FXML
    private ComboBox<String> comboaddres;


    @FXML
    void backDoctor(ActionEvent event) {

    }

    @FXML
    void clearDoctor(ActionEvent event) {

    }

    @FXML
    void deleteDoctor(ActionEvent event)
    {
        

    }
    Doctor doctorobj=new Doctor();
    doctorDAO doctorDAOobj;












    @FXML
    void saveDoctor(ActionEvent event) throws SQLException, IOException
    {

        doctorobj=new Doctor();
        doctorobj.setName(txtname.getText());
        doctorobj.setAddress(comboaddres.getValue());
        doctorobj.setPhone(txtphone.getText());
        doctorobj.setSelary(txtsalary.getText());
        doctorobj.setCertificate(txtcertificate.getText());
        doctorobj.setExpiriment(txtexpiriment.getText());

        doctorDAOobj=new doctorDAO();
        doctorDAOobj.creatdoctor(doctorobj);
        viewtable();








    }

    @FXML
    void updateDoctor(ActionEvent event) throws SQLException {

    Doctor d=new Doctor();
    d.setName(txtname.getText());
    d.setExpiriment(txtexpiriment.getText());
    d.setAddress(comboaddres.getValue());
    d.setSelary(txtsalary.getText());
    d.setCertificate(txtcertificate.getText());
    d.setPhone(txtphone.getText());
     doctorDAO docdao=new doctorDAO();
      docdao.updatedoctor(d);


    }


    public void mousis()
    {
        Doctor doctorupdate=new Doctor();

        doctorupdate=doctorTable.getSelectionModel().getSelectedItem();

        if(doctorupdate!=null)
        {
            txtname.setText(doctorupdate.getName());
            comboaddres.setValue(doctorupdate.getAddress());


            txtexpiriment.setText(doctorupdate.getExpiriment());
            txtcertificate.setText(doctorupdate.getCertificate());
            txtphone.setText(doctorupdate.getPhone());
            txtsalary.setText(doctorupdate.getSelary());
        }



    }




    @FXML
    public void put(MouseEvent event)
    {
      mousis();




    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {



        ObservableList<String >address= FXCollections.observableArrayList("Hargeisa","burco","gabilay","ceerigabo","berbera");
        comboaddres.setItems(address);


        //tables

        viewtable();






    }
    @FXML
    void searcho(KeyEvent event)
    {
        ArrayList<Doctor>Doctors=new ArrayList<>();
        FilteredList<Doctor> filteredList = new FilteredList(FXCollections.observableList(Doctors), p -> true);
        filteredList.setPredicate(p->p.getPhone().contains(txtsearch.getText().trim()));
        doctorTable.setItems(filteredList);


    }
    public void viewtable()
    {
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colcertificatation.setCellValueFactory(new PropertyValueFactory<>("certificate"));
        colexipiriment.setCellValueFactory(new PropertyValueFactory<>("expiriment"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colphone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        colsalary.setCellValueFactory(new PropertyValueFactory<>("selary"));
        Connection con=DBconnection.connect();
        String query="select * from doctor";
        ObservableList<Doctor>doctorlist=FXCollections.observableArrayList();
        try {
            PreparedStatement statement=con.prepareStatement(query);
            ResultSet rs=statement.executeQuery();
            while (rs.next())
            {
                doctorlist.add(new Doctor(
                        rs.getString("doctorname"), rs.getString("address"), rs.getString("phone"), rs.getString("certificated"), rs.getString("expiriment"), rs.getString("salary")

                ));


            }
            doctorTable.setItems(doctorlist);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
