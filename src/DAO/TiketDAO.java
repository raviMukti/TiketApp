
package DAO;

import Database.DBConfig;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author raviMukti at Aftwork
 */
public class TiketDAO {
    
    //method insertTiket
   public static void insertTiket(String ktp, String nama, String st_asal, String st_tujuan, String kode_kereta,
           String nama_kereta, String kelas_kereta, int jumlah_tiket, int total_harga, LocalDate tanggal_berangkat, LocalTime jam_berangkat) throws SQLException, ClassNotFoundException{
       //Buat Query
       String beliTiket = 
               "INSERT INTO `order_tiket` (`no_ktp`, `nama_penumpang`, `stasiun_asal`, `stasiun_tujuan`,"
               + "`kelas_kereta`, `nama_kereta`, `jumlah_tiket`, `total_harga`, `tanggal_berangkat`, `jam_berangkat`)"
               + " VALUES ('"+ktp+"', '"+nama+"', '"+st_asal+"', '"+st_tujuan+"', '"+kelas_kereta+"',"
               + "'"+nama_kereta+"', '"+jumlah_tiket+"', '"+total_harga+"', '"+tanggal_berangkat+"', '"+jam_berangkat+"')";
       try {
            DBConfig.dbExecuteUpdate(beliTiket);
        } catch (SQLException e) {
            System.out.println("Ada Kesalahan saat input data ke Database" + e);
        }
   }
   
   //Method deleteMhs()
    public static void deleteTiket(String noKtp) throws SQLException, ClassNotFoundException{
        String deleteStmt = "DELETE FROM `order_tiket` WHERE no_ktp = '"+noKtp+"'";
        try {
            DBConfig.dbExecuteUpdate(deleteStmt);
        } catch (SQLException e) {
            System.out.println("Ada Kesalahan " + e);
        }
        DBConfig.dbDisconnect();
    }
}
