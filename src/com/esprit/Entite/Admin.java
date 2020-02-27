/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author PC-HP
 */
public class Admin {
    
   private String aa;
   private String bb;
   private String cc;
   private String dd;
  private  String ee;

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getEe() {
        return ee;
    }

    public void setEe(String ee) {
        this.ee = ee;
    }
    
    public Admin(){
    }

    public Admin(String aa, String bb, String cc, String dd, String ee) {
        this.aa = aa;
        this.bb = bb;
        this.cc = cc;
        this.dd = dd;
        this.ee = ee;
    }

    @Override
    public String toString() {
        return "Admin{" + "aa=" + aa + ", bb=" + bb + ", cc=" + cc + ", dd=" + dd + ", ee=" + ee + '}';
    }
  
  
    
    
}
