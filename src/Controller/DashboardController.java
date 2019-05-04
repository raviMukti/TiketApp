
package Controller;

import Database.DBConfig;
import Model.TiketModel;
import Model.TiketViewModel;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author raviMukti at Aftwork
 */
public class DashboardController implements Initializable {

    @FXML
    private JFXButton btnBeli;
    @FXML
    private JFXButton btnGanti;
    @FXML
    private JFXButton btnHapus;
    @FXML
    private JFXButton btnCetak;
    @FXML
    private Pagination lintingHalaman;
    @FXML
    private TableView<TiketViewModel> tableTiket;
    @FXML
    private TableColumn<TiketModel, String> colKtp;
    @FXML
    private TableColumn<TiketModel, String> colNama;
    @FXML
    private TableColumn<TiketModel, String> colJadwal;
    @FXML
    private TableColumn<TiketModel, String> colAsal;
    @FXML
    private TableColumn<TiketModel, String> colTujuan;
    @FXML
    private TableColumn<TiketModel, String> colKelas;
    @FXML
    private TableColumn<TiketModel, String> colKereta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initCol();
        loadData();
    }        

    @FXML
    private void btnBeliAction(ActionEvent event) throws IOException {
        //Memanggil stage BeliTiket.fxml
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/BeliTiket.fxml"));
        Parent root = (Parent) loader.load();
        Stage beliStage = new Stage();
        Scene beliScene = new Scene(root);
        beliStage.initModality(Modality.APPLICATION_MODAL);
        beliStage.setResizable(false);
        beliStage.setTitle("Beli Tiket - Tiket APP");
        beliStage.setScene(beliScene);
        beliStage.showAndWait();
    }

    @FXML
    private void btnGantiAction(ActionEvent event) throws IOException {
        //Memanggil stage EditTiket.fxml
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/EditTiket.fxml"));
        Parent root = (Parent) loader.load();
        Stage gantiTiketStage = new Stage();
        Scene gantiTiketScene = new Scene(root);
        gantiTiketStage.initModality(Modality.APPLICATION_MODAL);
        gantiTiketStage.setResizable(false);
        gantiTiketStage.setTitle("Ganti Tiket - Tiket APP");
        gantiTiketStage.setScene(gantiTiketScene);
        gantiTiketStage.showAndWait();
    }

    @FXML
    private void btnHapusAction(ActionEvent event) {
    }

    @FXML
    private void btnCetakAction(ActionEvent event) {
    }
    
    void initCol(){
//       colResi.setCellValueFactory(new PropertyValueFactory<>("No. Resi"));
       colKtp.setCellValueFactory(new PropertyValueFactory<>("noKtp"));
       colNama.setCellValueFactory(new PropertyValueFactory<>("nama_penumpang"));
       colJadwal.setCellValueFactory(new PropertyValueFactory<>("jadwal_berangkat"));
       colAsal.setCellValueFactory(new PropertyValueFactory<>("st_asal"));
       colTujuan.setCellValueFactory(new PropertyValueFactory<>("st_tujuan"));
       colKelas.setCellValueFactory(new PropertyValueFactory<>("kelas_kereta"));
       colKereta.setCellValueFactory(new PropertyValueFactory<>("nama_kereta"));
   }
    
    //Untuk retrieve data dari database dan menampilkannya ke tableview
   void loadData(){
       ObservableList<TiketViewModel> oblist = FXCollections.observableArrayList();
       
//       oblist.removeAll(oblist);
       
        try {
            Connection conn = DBConfig.getConnection();
            ResultSet result = conn.createStatement().executeQuery("SELECT * FROM order_tiket");
            
            while (result.next()) {                
                  oblist.add(new TiketViewModel(result.getString("no_ktp"),
                          result.getString("nama_penumpang"), result.getDate("tanggal_berangkat").toLocalDate(), 
                          result.getString("stasiun_asal"), result.getString("stasiun_tujuan"), 
                          result.getString("kelas_kereta"), result.getString("nama_kereta")));
            }
        } catch (SQLException e) {
            System.out.println("Ada Kesalahan "+ e);
        } catch (ClassNotFoundException ex) {
            System.out.println("Ada Kesalahan" + ex);
        }
        
        tableTiket.setItems(oblist);
   }
   
   private static DashboardController instance;
   public DashboardController(){
       instance = this;
   }
   //   Method getInstance()
   public static DashboardController getInstance(){
       return instance;
   }
}
