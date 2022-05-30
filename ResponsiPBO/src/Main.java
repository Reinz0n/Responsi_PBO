
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Main extends JFrame{
    
    JLabel lmainmenu = new JLabel("Main Menu");
    JButton bTambah = new JButton("Tambah Barang");
    JButton bLihat = new JButton("Lihat Barang");
    
    public Main(){
        setTitle("");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        
        setLayout(null);
        add(lmainmenu);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(bTambah);
        add(bLihat);
        pack();
        setVisible(true);
        
        bTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new ViewInput();
            }
        });
        
//        bLihat.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                new ViewData();
//            }
//        });
    }
     
    public static void main(String[] args) {
        new Main();
    }
    
}
