
package exo;

import java.sql.*;
import java.util.Scanner;

public class ExoJDBC {
    public static void executeFreeQuery() {
        // Information d'accès à la base de données
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/scripts"; // Remplacez "scripts" par le nom correct de votre BD
        Connection cn = null;
        Statement st = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Étape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Étape 2 : Récupération de la connexion
            cn = DriverManager.getConnection(url, user, password);

            // Étape 3 : Création du statement
            st = cn.createStatement();

            // Entrée de la requête SQL libre
            System.out.println("Entrez votre requête SQL :");
            String req = scanner.nextLine();

            // Vérification du type de requête
            if (req.trim().toUpperCase().startsWith("SELECT")) {
                // Si la requête est un SELECT, elle renvoie un ResultSet
                ResultSet rs = st.executeQuery(req);

                // Récupération des méta-informations sur le ResultSet
                ResultSetMetaData rsMetaData = rs.getMetaData();
                int columnCount = rsMetaData.getColumnCount();

                // Affichage du nombre de colonnes
                System.out.println("Nombre de colonnes : " + columnCount);

                // Affichage des informations sur chaque colonne
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println("Colonne " + i + " : " + rsMetaData.getColumnName(i) + " (Type : " + rsMetaData.getColumnTypeName(i) + ")");
                }

                // Affichage du contenu du ResultSet
                System.out.println("\nContenu du ResultSet :");
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(rs.getString(i) + "\t");
                    }
                    System.out.println();
                }
                rs.close();
            } else {
                // Si la requête est une modification (INSERT, UPDATE, DELETE)
                int rowsAffected = st.executeUpdate(req);
                System.out.println("Nombre de lignes modifiées : " + rowsAffected);
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver : " + ex.getMessage());
        } finally {
            try {
                // Étape 5 : Libérer les ressources de la mémoire
                if (st != null) st.close();
                if (cn != null) cn.close();
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources : " + ex.getMessage());
            }
        }
    }

   
}

