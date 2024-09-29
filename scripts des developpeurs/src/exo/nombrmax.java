/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author sanae
 */
public class nombrmax {

    public static void nombrmax() {
        
        //information d'accès à la base de données 
                   String user = "root"; 
                   String password = ""; 
                   String url = "jdbc:mysql://localhost:3306/scripts";
                   Connection cn = null; 
                   Statement st = null; 
                   ResultSet ss = null ;
                           
                   try{ 
        //etape 1 : chargement du driver 
                Class.forName("com.mysql.jdbc.Driver"); 
        //etape 2 : récupération de la connexion 
                cn = DriverManager.getConnection(url, user, password); 
                
        //etape 3 : création de statement 
                st = cn.createStatement(); 
                String req ="SELECT Developpeurs, jour, max(NBScripts)\n" + "from devdata\n" +"group by jour";
                ss =st.executeQuery(req);
        //methode getType()
            int resultsetType = ss.getType();
        //etape 5 : parcourir de ResultSet
            while(ss.next()){
                System.out.println(ss.getString("Developpeurs") + "  " +ss.getString(2)+ " "+ ss.getInt(3));
            }
        //etape 4 : exécution de la requête          
                st.executeQuery(req);
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
   
}

