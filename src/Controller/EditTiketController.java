
package Controller;

import Database.DBConfig;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author raviMukti at Aftwork
 */
public class EditTiketController implements Initializable {
    @FXML
    private Label labelTotalBayar;
    @FXML
    private JFXButton btnSimpanGanti;
    @FXML
    private JFXButton btnBatalGanti;
    @FXML
    private JFXTextField fieldKtpGanti;
    @FXML
    private JFXComboBox<String> comboAsalGanti;
    @FXML
    private RadioButton radioEkse;
    @FXML
    private ToggleGroup toggleKelasTiket;
    @FXML
    private RadioButton radioBisnis;
    @FXML
    private RadioButton radioEkonomi;
    @FXML
    private JFXTextField fieldNamaPenumpangGanti;
    @FXML
    private JFXComboBox<String> comboTujuanGanti;
    @FXML
    private JFXComboBox<String> comboKodeKeretaGanti;
    @FXML
    private JFXTextField fieldNamaKeretaGanti;
    @FXML
    private Spinner<Integer> spinTiketGanti;
    @FXML
    private DatePicker tanggalBerangkatGanti;
    @FXML
    private JFXTimePicker jamBerangkatGanti;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSimpanGantiAction(ActionEvent event) {
    }

    @FXML
    private void btnBatalGantiAction(ActionEvent event) {
    }

    @FXML
    private void ekseSelected(ActionEvent event) {
    }

    @FXML
    private void bisnisSelected(ActionEvent event) {
    }

    @FXML
    private void ekonomiSelected(ActionEvent event) {
    }

    @FXML
    private void comboKodeKeretaGantiAction(ActionEvent event) {
    }

    @FXML
    private void spinTiketAction(MouseEvent event) {
    }
    
    public void initData(String sql) throws SQLException, ClassNotFoundException{
        try {
            Connection conn = DBConfig.getConnection();
            ResultSet result = conn.createStatement().executeQuery("SELECT * FROM `order_tiket` WHERE no_ktp = '"+sql+"'");
            while (result.next()) {                 
                 String add1 = result.getString("no_ktp");
                 fieldKtpGanti.setText(add1);
                 String add2 = result.getString("nama_penumpang");
                 fieldNamaPenumpangGanti.setText(add2);
                 String add3 = result.getString("stasiun_asal");
                 comboAsalGanti.setValue(add3);
                 String add4 = result.getString("stasiun_tujuan");
                 comboTujuanGanti.setValue(add4);
                 String add5 = result.getString("kelas_kereta");
                 comboKodeKeretaGanti.setValue(add5);
                 String add6 = result.getString("nama_kereta");
                 fieldNamaKeretaGanti.setText(add6);
                 String add7 = result.getString("");
//                 if () {
//                    
//                } else {
//                }
             }
        } catch (Exception e) {
        }
    }
}
