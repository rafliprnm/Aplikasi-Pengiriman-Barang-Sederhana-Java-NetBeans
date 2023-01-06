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
public class Barang {
    private String penerima;
    private String name;
    private double weight;
    private int sumItem;
    private double totalWeightItem;
    private String destinationAddress;
    private String JenisPengiriman;
    private String JenisPaket;
    private int harga;
    private String pembayaran;

    public Barang(String penerima, String name, double weight, int sumItem, double totalWeightItem, String destinationAddress, String JenisPengiriman, String JenisPaket, int harga, String pembayaran) {
        this.penerima = penerima;
        this.name = name;
        this.weight = weight;
        this.sumItem = sumItem;
        this.totalWeightItem = totalWeightItem;
        this.destinationAddress = destinationAddress;
        this.JenisPengiriman = JenisPengiriman;
        this.JenisPaket = JenisPaket;
        this.harga = harga;
        this.pembayaran = pembayaran;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public Barang() {
        
    }

    public String getJenisPengiriman() {
        return JenisPengiriman;
    }

    public String getJenisPaket() {
        return JenisPaket;
    }

    public int getHarga() {
        return harga;
    }
        
    public double jumlahBeratBarang(int jumlah, double berat){
        return jumlah * berat;
    }
    
    public String getDestinationaddress(){
        return destinationAddress;
    }

    public String getPenerima() {
        return penerima;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getSumItem() {
        return sumItem;
    }

    public double getTotalWeightItem() {
        return totalWeightItem;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }
    
    
}
