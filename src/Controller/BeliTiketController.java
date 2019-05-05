
package Controller;

import DAO.TiketDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author raviMukti at Aftwork
 */
public class BeliTiketController implements Initializable {

    @FXML
    private JFXButton btnSimpanBeli;
    @FXML
    private JFXButton btnBatalBeli;
    @FXML
    private JFXTextField fieldKtp;
    @FXML
    private Label labelTotalBayar;
    @FXML
    private JFXComboBox<String> comboAsal;
    @FXML
    private JFXComboBox<String> comboTujuan;
    @FXML
    private JFXComboBox<String> comboKodeKereta;
    @FXML
    private RadioButton radioEkse;
    @FXML
    private RadioButton radioBisnis;
    @FXML
    private RadioButton radioEkonomi;
    @FXML
    private JFXTextField fieldNamaKereta;
    @FXML
    private ToggleGroup toggleKelasTiket;
    @FXML
    private JFXTextField fieldNamaPenumpang;
    @FXML
    private Spinner<Integer> spinTiket;
    @FXML
    private DatePicker tanggalBerangkat;
    @FXML
    private JFXTimePicker jamBerangkat;
    
    //Inisialisasi nilai awal
    public int kelas = 0;
    public int dewasa = 0;
    public int total = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inisialisasi Combobox
        //Combo Stasiun Asal
        ObservableList<String> asal = FXCollections.observableArrayList(
                "Stasiun Bandung",
                "Stasiun Cimahi"
        );
//        Combo Stasiun tujuan
        ObservableList<String> tujuan = FXCollections.observableArrayList(
                "Stasiun Jakarta",
                "Stasiun Tasikmalaya",
                "Stasiun Bogor",
                "Stasiun Tangerang"
        );

//        Combo Kode Kereta
        ObservableList<String> kodeKereta = FXCollections.observableArrayList(
                "A",
                "B",
                "C"
        );
        
//        Inisialisasi nilai spinner
        SpinnerValueFactory<Integer> valueTiket = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        
//        Set nilai combo Stasiun asal
        comboAsal.setItems(asal);
//        Memberi Nilai default dari combo asal
        comboAsal.setValue("Stasiun Bandung");
        
//        Set nilai combo stasiun tujuan
        comboTujuan.setItems(tujuan);
//        Memberi Nilai default dari combo tujuan
        comboTujuan.setValue("Stasiun Jakarta");
        
//      Set nilai combo kode kereta
        comboKodeKereta.setItems(kodeKereta);
//      Memberi nilai default dari combo kode kereta
        comboKodeKereta.setValue("A");
        
//      Set nilai spinner Dewasa
        spinTiket.setValueFactory(valueTiket);
        
//      Set nilai default fieldNamaKereta
        fieldNamaKereta.setText("ESEMKA");
        
    }    

    @FXML
    private void btnSimpanBeliAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        //Mengecek field kosong
        if (fieldKtp.getText().isEmpty() || fieldNamaPenumpang.getText().isEmpty() || 
            tanggalBerangkat.getValue().toString().isEmpty() || jamBerangkat.getValue().toString().isEmpty()  ) {
           Alert fieldKosong = new Alert(Alert.AlertType.WARNING);
           fieldKosong.setTitle("Perhatian");
           fieldKosong.setHeaderText("Form Kosong");
           fieldKosong.setContentText("Harap Mengisi Semua Field !!!");
           fieldKosong.showAndWait();
        } else {
            String jk = "";
            if (radioEkse.isSelected()) {
                jk = radioEkse.getText();
            }
            if (radioBisnis.isSelected()) {
                jk = radioBisnis.getText();
            } if(radioEkonomi.isSelected()){
                jk = radioEkonomi.getText();
            }
            String labelBayar = labelTotalBayar.getText();
            int bayar = Integer.parseInt(labelBayar);
            
            TiketDAO.insertTiket(fieldKtp.getText(), fieldNamaPenumpang.getText(), 
                    comboAsal.getValue(), comboTujuan.getValue(), comboKodeKereta.getValue(), fieldNamaKereta.getText(),
                    toggleKelasTiket.getSelectedToggle().toString(),spinTiket.getValue(), bayar, tanggalBerangkat.getValue(), jamBerangkat.getValue());
            // Menampilkan dialog box informasi
                Alert alertSimpan = new Alert(Alert.AlertType.INFORMATION);
                alertSimpan.setTitle("Kampus App - Informasi");
                alertSimpan.setHeaderText("Informasi Simpan Data");
                alertSimpan.setContentText("Simpan data ke database berhasil !");
                alertSimpan.showAndWait();

                
                DashboardController.getInstance().loadData(); //memanggil method loadData() dari DashboardController
                btnSimpanBeli.getScene().getWindow().hide(); //Menutup scene AddMahasiswa.fxml
        }
    }

    @FXML
    private void btnBatalBeliAction(ActionEvent event) {
        // Membuat dialog box konfirmasi
        Alert alertBatal = new Alert(Alert.AlertType.CONFIRMATION);
        alertBatal.setTitle("Tiket App - Konfirmasi Batal");
        alertBatal.setHeaderText("Batal Beli Tiket");
        alertBatal.setContentText("Apakah anda yakin akan membatalkan pembelian?");
        Optional<ButtonType> konfirmasiBatal = alertBatal.showAndWait();
        if(konfirmasiBatal.get() == ButtonType.OK){
            btnBatalBeli.getScene().getWindow().hide();
        }
    }

    
    //Method untuk mengetahui nilai comboKodeKereta yang terpilih
    @FXML
    private void comboKodeKeretaAction(ActionEvent event) {
        String kode = comboKodeKereta.getValue();
        switch(kode){
            case "A" :
                fieldNamaKereta.setText("ESEMKA"); //Set Nama Kereta jadi ESEMKA
                break;
            case "B" :
                fieldNamaKereta.setText("SATRIA"); //Set nama kereta jadi SATRIA
                break;  
            default:
                fieldNamaKereta.setText("LIGHTNING MCQUEEN"); //Set nama kereta jadi LIGHTNING MCQUEEN
        }
    }
   

    //trigger getTotal()
    @FXML
    private void ekseSelected(ActionEvent event) {
        getTotal();
    }
    
    //trigger getTotal()
    @FXML
    private void bisnisSelected(ActionEvent event) {
        getTotal();
    }
    
    //trigger getTotal()
    @FXML
    private void ekonomiSelected(ActionEvent event) {
        getTotal();
    }
    
    //Method mengambil nilai total dari pembelian tiket
    public void getTotal (){
        if (radioEkse.isSelected()) {
            dewasa = spinTiket.getValue();
            kelas = 150000;
            total = dewasa*kelas;
            String hargaBayar = Integer.toString(total);
            labelTotalBayar.setText(hargaBayar);
        } if (radioBisnis.isSelected()) {
            dewasa = spinTiket.getValue();
            kelas = 130000;
            total = dewasa*kelas;
            String hargaBayar = Integer.toString(total);
            labelTotalBayar.setText(hargaBayar);
        } if (radioEkonomi.isSelected()){
            dewasa = spinTiket.getValue();
            kelas = 110000;
            total = dewasa*kelas;
            String hargaBayar = Integer.toString(total);
            labelTotalBayar.setText(hargaBayar);
        }
    }

    @FXML
    private void spinTiketAction(MouseEvent event) {
        getTotal();
    }
    
}
