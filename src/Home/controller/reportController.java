package Home.controller;
import Home.utilities.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Home.utilities.DBconnection;



public class reportController implements Initializable
{
    @FXML
    private Label lblpatient;

    @FXML
    private Label lbldoctors;

    @FXML
    private Label lblcunsults;

    @FXML
    private PieChart PieChart;;
    @FXML
    private PieChart PieChart1;

    Connection con=DBconnection.connect();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ObservableList<PieChart.Data>data= FXCollections.observableArrayList();










        try {
            con= DBconnection.connect();
            String query="SELECT COUNT(patient_id) FROM patient";
            PreparedStatement statement=con.prepareStatement(query);

            ResultSet rs=statement.executeQuery();
           while (rs.next())
           {
            String count=rs.getString("COUNT(patient_id)");

            lblpatient.setText(count);




           }




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }





        try {
             con= DBconnection.connect();
            String query="SELECT COUNT(doctorid) FROM doctor";
            PreparedStatement statement=con.prepareStatement(query);

            ResultSet rs=statement.executeQuery();
            while (rs.next())
            {
                String count=rs.getString("COUNT(doctorid)");

                lbldoctors.setText(count);




            }




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }





        try {
             con= DBconnection.connect();
            String query="SELECT COUNT(doctorid) FROM doctor";
            PreparedStatement statement=con.prepareStatement(query);

            ResultSet rs=statement.executeQuery();
            while (rs.next())
            {
                String count=rs.getString("COUNT(doctorid)");

                lbldoctors.setText(count);




            }




        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }







        try {

            con = DBconnection.connect();
            String query="SELECT * FROM cunsultation";


            PreparedStatement statement=con.prepareStatement(query);

            ResultSet rs=statement.executeQuery();

            while (rs.next()){
                data.add(new PieChart.Data(rs.getString("diagnosis"),rs.getInt("consultid")));
            }







        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PieChart.setData(data);





        //second piechart

        try {

            con = DBconnection.connect();
            String query="SELECT * FROM patient";


            PreparedStatement statement=con.prepareStatement(query);

            ResultSet rs=statement.executeQuery();

            while (rs.next()){
                data.add(new PieChart.Data(rs.getString("diagnosis"),rs.getInt("consultid")));
            }







        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PieChart.setData(data);




    }



    }



