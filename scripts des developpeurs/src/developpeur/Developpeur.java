/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developpeur;

public class Developpeur {
   private String Jour;
   private int NBScripts;
   private String nomdev;

    public Developpeur(String Jour, int NBScripts, String nomdev) {
        this.Jour = Jour;
        this.NBScripts = NBScripts;
        this.nomdev = nomdev;
    }

    public Developpeur() {
    }

    public String getJour() {
        return Jour;
    }

    public void setJour(String Jour) {
        this.Jour = Jour;
    }

    public int getNBScripts() {
        return NBScripts;
    }

    public void setNBScripts(int NBScripts) {
        this.NBScripts = NBScripts;
    }

    public String getNomdev() {
        return nomdev;
    }

    public void setNomdev(String nomdev) {
        this.nomdev = nomdev;
    }
    
   
    
}
