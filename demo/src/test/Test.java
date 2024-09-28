/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Site;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test{
public static void save(Site s){ 
        //information d'accès à la base de données 
                   String user = "root"; 
                   String password = ""; 
                   String url = "jdbc:mysql://localhost:3306/db"; 
                   Connection cn = null; 
                   Statement st = null; 
                   try{ 
        //etape 1 : chargement du driver 
                Class.forName("com.mysql.jdbc.Driver"); 
        //etape 2 : récupération de la connexion 
                cn = DriverManager.getConnection(url, user, password); 
                
        //etape 3 : création de statement 
                st = cn.createStatement(); 
                String req = "insert into site values (null,'" +s.getNom() +"')";
        //etape 4 : exécution de la requête          
                st.executeUpdate(req);
        }catch (SQLException e){
                System.out.println("Erreur SQL");
        }catch (ClassNotFoundException ex){
                System.out.println("Impossible de charger le driver");
        }finally {
                try{
                   //etape 5 : libérer les ressources de la mémoire
                   st.close();
                   cn.close();
                }catch (SQLException ex){
                   System.out.println("Impossible de libérer les ressources");
                }
        } 
}
public static void load(){
        //information d'accès à la base de données 
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/db";
        Connection cn = null;
        Statement st = null;
        ResultSet rs =null;

        try{
        //etape 1 : chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

        //etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, user, password);

        //etape 3 : création de statement          
            st = cn.createStatement();
            String req = "SELECT * FROM site";

        //etape 4 : exécution de la requête          
            rs =st.executeQuery(req);
        //etape 5 : parcourir de ResultSet
            while(rs.next()){
                System.out.println(rs.getInt(1) + " " +rs.getString(2));
            }
        }catch (SQLException e){
                System.out.println(e.getMessage());
        }catch (ClassNotFoundException ex){
                System.out.println("Impossible de charger le driver");
        }finally {
                try{
                   //etape 5 : libérer les ressources de la mémoire
                   st.close();
                   cn.close();
                }catch (SQLException ex){
                   System.out.println("Impossible de libérer les ressources");
                }
        } 
}
}   


    

