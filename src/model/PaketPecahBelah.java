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
public class PaketPecahBelah extends Paket{
    @Override
    protected double hargaPengiriman(double jarak) {
        return 7000*jarak; //To change body of generated methods, choose Tools | Templates.
    }
}
