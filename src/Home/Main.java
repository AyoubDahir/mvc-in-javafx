package Home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Home.utilities.*;
import Home.DAO.*;

import Home.controller.*;
//import Home.asset.*;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        url obj=new url();
        obj.show("signup page","/Home/viewer/signup.fxml");

    }


    public static void main(String[] args) {
        launch(args);
    }
}
