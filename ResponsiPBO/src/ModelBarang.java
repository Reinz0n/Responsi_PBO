import javax.swing.JOptionPane;

public class ModelBarang {
    
    private String nama;
    private String massa;
    private String harga;
    private ListenerBarang listenerBarang;
    
    protected void fireOnChange(){
        if(listenerBarang != null){
            listenerBarang.onChange(this);
        }
    }
    
    public ListenerBarang getBarangListener(){
        return listenerBarang;
    }
    
    public void setBarangListener(ListenerBarang listenerBarang){
        this.listenerBarang = listenerBarang;
    }
    
    public String getHarga(){
        return harga;
    }
    
    public void setHarga(String harga){
        this.harga = harga;
        fireOnChange();
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
        fireOnChange();
    }
    
    public String getMassa(){
        return massa;
    }
    
    public void setMassa(String massa){
        this.massa = massa;
        fireOnChange();
    }
    
    public void resetForm(){
        setNama("");
        setMassa("");
        setHarga("");
    }
    
    public void submitForm(ViewInput viewInput){
        JOptionPane.showMessageDialog(null, "Data " + viewInput.getNama().getText() + " " + viewInput.getMassa().getText() + " " + viewInput.getHarga().getText() + " sudah di submit");
    }
}
