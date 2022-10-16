/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.model;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

/**
 *
 * @author ACER
 */
@ManagedBean(name="controller")
@SessionScoped

public class controller {
public model model;
private String tarikTunai;
private String setorTunai;
private int jumlah;

public controller() {
    model = new model();
}  

    public String getResponSetorTunai(){
        if(model.cekTransaksi(jumlah)==1){
            model.tambahSaldo(jumlah);
            return "Setor Tunai Berhasil";
        } else{
            return "Setor harus kelipatan 50.000";
        }
    }
    public String getResponTarikTunai(){
        if(model.cekBatasSaldo()){
            return "Saldo Anda Mencapai Limit";   
        } else if((model.getSaldo()- jumlah )< model.limitSaldo()){
            return "Jumlah penarikan melebihi limit penarikan";
        }else if((model.getSaldo() > jumlah )&&(model.cekTransaksi(jumlah)==1)){
        model.tarikSaldo(jumlah);
        return  "Tarik tunai berhasil";
        }else{
            return "String penarikna harus kelipatan 50k";
            }
    }
    
    
    
public int cekSaldo(){
    return model.getSaldo();
}

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}

