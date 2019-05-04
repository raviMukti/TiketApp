
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author raviMukti at Aftwork
 */
public class EditTiketController implements Initializable {
    @FXML
    private ToggleGroup toggleKelasTIket;
    @FXML
    private Label labelTotalBayar;
    @FXML
    private JFXButton btnBeliUpdate;
    @FXML
    private JFXButton btnBatalUpdate;
    @FXML
    private JFXTextField fieldPemesanUpdate;
    @FXML
    private JFXComboBox<?> comboAsalUpdate;
    @FXML
    private JFXComboBox<?> comboTujuanUpdate;
    @FXML
    private JFXTimePicker fieldJadwalUpdate;
    @FXML
    private DatePicker fieldTanggalUpdate;
    @FXML
    private Spinner<?> spinDewasaUpdate;
    @FXML
    private Spinner<?> spinAnakUpdate;
    @FXML
    private JFXTextField fieldPenumpangUpdate;
    @FXML
    private JFXTextField fieldKtpUpdate;
    @FXML
    private JFXComboBox<?> comboKodeKeretaUpdate;
    @FXML
    private RadioButton radioEkseUpdate;
    @FXML
    private RadioButton comboBisnisUpdate;
    @FXML
    private RadioButton comboEkonomiUpdate;
    @FXML
    private JFXTextField fieldNamaKeretaUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBeliUpdateAction(ActionEvent event) {
    }

    @FXML
    private void btnBatalUpdateAction(ActionEvent event) {
    }
    
}
