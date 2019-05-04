
package Main;

import Database.DBConfig;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author raviMukti at Aftwork
 */
public class TiketApp extends Application{
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Dashboard TiketAPP");
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        launch(args);
//        DBConfig.dbConnect();
    }
}
