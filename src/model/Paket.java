/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rafli
 */
public class Paket {
    private String idPaket;
    private Barang barangPaket;

    public Paket() {
    }

    public String getIdPaket() {
        return idPaket;
    }
    
    protected void setBarang(Barang b){
        
    }
    protected double hargaPengiriman(double jarak){
        return 5000*jarak;
    }
    public double deliveryType(String type){
        double harga = 0;
        if("Fast".equals(type)){
            harga = 10000;
        }else if("Reguler".equals(type)){
            harga =  7000;
        }else if("Normal".equals(type)){
            harga =  5000;
        }
        return harga;
    }
    
    public int Totalharga(int jenisPengiriman, int JenisPaket){
        return jenisPengiriman + JenisPaket;
    }
}
