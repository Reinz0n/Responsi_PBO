
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ViewInput extends JFrame implements ActionListener, ListenerBarang {
    
    JLabel linput = new JLabel("Input Barang");
    JLabel lnama = new JLabel("Nama");
    JLabel lmassa = new JLabel("Massa (gr)");
    JLabel lharga = new JLabel("Harga Satuan");
    final JTextField fnama = new JTextField(30);
    final JTextField fmassa = new JTextField(10);
    final JTextField fharga = new JTextField(20);
    JButton bSubmit = new JButton("Submit");
    JButton bReset = new JButton("Reset");
    ControllerBarang controllerBarang;
    ModelBarang modelBarang;
    
    public ViewInput(){
        setTitle("Input Barang");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 190);
        
        setLayout(null);
        add(lnama);
        add(fnama);
        add(lmassa);
        add(fmassa);
        add(lharga);
        add(fharga);
        add(bSubmit);
        add(bReset);
        
        lnama.setBounds(10, 10, 120, 20);
        fnama.setBounds(130, 10, 170, 20);
        lmassa.setBounds(10, 35, 120, 20);
        fmassa.setBounds(130, 35, 170, 20);
        lharga.setBounds(10, 60, 120, 20);
        fharga.setBounds(130, 60, 170, 20);
        bSubmit.setBounds(130, 100, 80, 20);
        bReset.setBounds(220, 100, 80, 20);
        
        bSubmit.addActionListener(this);
        bReset.addActionListener(this);
        
        setVisible(true);
        
        controllerBarang = new ControllerBarang();
        modelBarang = new ModelBarang();
        modelBarang.setBarangListener(this);
        controllerBarang.setMb(modelBarang );
    }
    
    public JTextField getHarga(){
        return fharga;
    }
    
    public JTextField getNama(){
        return fnama;
    }
    
    public JTextField getMassa(){
        return fmassa;
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == bSubmit){
            controllerBarang.submitForm(this);
        }
        if(e.getSource() == bReset){
            controllerBarang.resetForm(this);
        }
    }
    
    @Override
    public void onChange(ModelBarang modelBarang){
        fnama.setText(modelBarang.getNama());
        fmassa.setText(modelBarang.getMassa());
        fharga.setText(modelBarang.getHarga());
    }
}
