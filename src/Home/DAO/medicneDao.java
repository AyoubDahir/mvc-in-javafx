package Home.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class medicneDao
{

    @FXML
    private ComboBox<?> combopatientid;

    @FXML
    private TextField txtsymptoms;

    @FXML
    private ComboBox<?> combolabrequest;

    @FXML
    private TextField txtdiagnosis;

    @FXML
    private TextField txttreatment;

    @FXML
    private TextField txtcomment;

    @FXML
    private TableView<?> cunsultationTable;

    @FXML
    private TableColumn<?, ?> colpatientid;

    @FXML
    private TableColumn<?, ?> colSymptoms;

    @FXML
    private TableColumn<?, ?> collabrequest;

    @FXML
    private TableColumn<?, ?> coldiagnosis;

    @FXML
    private TableColumn<?, ?> coltreatment;

    @FXML
    private TableColumn<?, ?> colcomment;

    @FXML
    void delete(ActionEvent event)
    {


    }

    @FXML
    void registercunsult(ActionEvent event)
    {

    }

    @FXML
    void update(ActionEvent event) {

    }
}
