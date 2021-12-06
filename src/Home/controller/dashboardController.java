package Home.controller;
import Home.utilities.url;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class dashboardController
{
    @FXML
    private Button btnDoctor;

    @FXML
    private Button btnpatient;

    @FXML
    void billShow(ActionEvent event) {

    }
    @FXML
    void requestshow(MouseEvent event) throws IOException {

    }

    @FXML
    void diagnosShow(ActionEvent event) throws IOException {
        url obj=new url();
        obj.show("signup page","/Home/viewer/consultation.fxml");

    }

    @FXML
    void doctorShow(ActionEvent event) throws IOException {
        url obj=new url();
        obj.show("signup page","/Home/viewer/doctor.fxml");

    }

    @FXML
    void labShow(ActionEvent event) throws IOException {
        url obj=new url();
        obj.show("lab request","/Home/viewer/labRequest.fxml");


    }

    @FXML
    void medicneShow(ActionEvent event) {

    }

    @FXML
    void patientShow(ActionEvent event) throws IOException {
        url obj=new url();
        obj.show("Patient Registertion","/Home/viewer/patient.fxml");

    }


    @FXML
    void reportShow(ActionEvent event) throws IOException {
        url obj=new url();
        obj.show("Patient Registertion","/Home/viewer/report.fxml");

    }


    @FXML
    void dashboardShow(ActionEvent event) {

    }
}
