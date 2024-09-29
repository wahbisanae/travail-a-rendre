
package exo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class nombrescript{

public static void nombrescript(){
            
        //information d'accès à la base de données 
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/scripts";
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
            String req = "SELECT SUM(NBScripts) AS total_scripts FROM devdata WHERE datecreation >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)";

        //etape 4 : exécution de la requête          
            rs =st.executeQuery(req);
        //methode getType()
            int resultsetType = rs.getType();
        //etape 5 : parcourir de ResultSet
            while(rs.next()){
               int totalScripts = rs.getInt("total_scripts");
                    System.out.println("Nombre total de scripts réalisés en une semaine : " + totalScripts);
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