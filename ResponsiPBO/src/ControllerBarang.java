
import java.sql.*;
import javax.swing.JOptionPane;

public class ControllerBarang {
    
    private ModelBarang mb;
    
    public void setMb(ModelBarang mb){
        this.mb = mb;
    }
    
    public void resetForm(ViewInput viewInput){
        String Nama = viewInput.getNama().getText();
        String Massa = viewInput.getMassa().getText();
        String Harga = viewInput.getHarga().getText();
        
        if(Nama.equals("") && Massa.equals("") && Harga.equals("")){
            
        } else{
            mb.resetForm();
        }
    }
    
    public void submitForm(ViewInput viewInput){
        String Nama = viewInput.getNama().getText();
        String Massa = viewInput.getMassa().getText();
        String Harga = viewInput.getHarga().getText();
        
        if(Nama.trim().equals("")){
            JOptionPane.showMessageDialog(viewInput, "Nama masih kosong!");
        } else if(Massa.trim().equals("")){
            JOptionPane.showMessageDialog(viewInput, "Massa masih kosong!");
        } else if(Harga.trim().equals("")){
            JOptionPane.showMessageDialog(viewInput, "Harga masih kosong!");
        } else{
            mb.submitForm(viewInput);
            
            String DBurl = "jdbc:mysql://localhost/barang";
            String DBusername = "root";
            String DBpassword = "";
            Connection koneksi;
            Statement statement;
            
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println(DBurl);
                koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
                statement = koneksi.createStatement();
                statement.executeUpdate("insert into barang values(" + null + "," + Nama + "','" + Massa + "','" + Harga + "')");
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
                statement.close();
                koneksi.close();
            } catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
            }
            
            mb.resetForm();
            
        }
    }
}
