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
public class Kurir extends User {
    private String name;
    private String phoneNumber;
    private double wallet;
    private Paket[] Package = new Paket[10];
    private int jumlahpaket=0;

    public Kurir(String name, String phoneNumber, double wallet) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    @Override
    public void login() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void giveDeliveryProgress(Pengirim p, boolean s){
        if(s==true){
            p.setDeliveryProgress(true, getName(), getPhoneNumber());
        }else{
           p.setDeliveryProgress(false, getName(), getPhoneNumber()); 
        }
    }
    
    public void addBarang(Paket p){
        if(jumlahpaket<10){
            this.Package[jumlahpaket++]=p;
        }else{
            throw new IllegalArgumentException("Kurir Sudah Membawa 10 Paket");
        }
    }
    
    public void deleteBarang(String id){
        for(int i =0;i<jumlahpaket;i++){
            if(Package[i].getIdPaket().equals(id)){
                for(int j = i; j < jumlahpaket; j++){
                    Package[j]=Package[j+1];
                }
            }
        }
        Package[jumlahpaket--]=null;
    }
    
    public void Income(double money){
        
    }
    
}
