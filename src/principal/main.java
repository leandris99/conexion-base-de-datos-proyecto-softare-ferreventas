package principal;

import java.sql.*;

/* programa que contecta la java con la base de datos*/
public class main {
            /* crea el metodo public static Connection que recibe como parametro el nombre de la base de datos*/
        public static Connection conexiobd(String bd){

            /* ***** nombramiento de variables ****** */
            Connection conexion;
            String host =  "jdbc:mysql://localhost:3307/";
            String user = "root";
            String pass = "root1316";
            Statement statement;
            ResultSet rs;


            System.out.println("conectandoo...");

            /* ***** metodo try, catch que realiza la conexion y caso contrario muestra mensaje de error ****** */

            try {
                conexion = DriverManager.getConnection(host+bd,user,pass);
                System.out.println("conexion exitosa");

                /* CONSULTA DE DATOS */
                statement = conexion.createStatement();
                rs = statement.executeQuery("SELECT * FROM personas "); /* se selecciona la tabla a la que se desea hacer el proceso*/
                while (rs.next()){
                    System.out.println(rs.getString("nombre")); /* se inserta el nombre de la columna que se desea consultar */
                }

                /* INSERSION DE DATOS */
                statement.execute("INSERT INTO `bd_ferreventas`.`personas` (`IDENTIFICACION`, `NOMBRE`, `CORREO`, `TELEFONO`, `DIRECCION_idDIRECCION`) " +
                        "VALUES ('24932747', 'diana correa c', 'dianaco@gmail.com', '2384837261', '2'");

                /*ACTUALIZACION DE DATOS*/
                    statement.execute("UPDATE `bd_ferreventas`.`personas` SET `NOMBRE` = 'alfonso ealo' WHERE (`idPERSONAS` = '2'");

                /* ELIMINACION DE DATOS*/
                    statement.execute("DELETE FROM `bd_ferreventas`.`personas` WHERE (`idPERSONAS` = '14'");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }

            return conexion;

        }

            /* se llama a la base de datos */
        public static void main(String[] args) {
            Connection bd = conexiobd("bd_ferreventas");
        }

}
