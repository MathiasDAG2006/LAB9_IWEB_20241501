package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoBase {
    // Definimos los parametros para la conexión
    private static final String URL = "jdbc:mysql://localhost:3306/lab9_biblioteca?serverTimezone=America/Lima";
    private static final String USER = "root";
    private static final String PASSWORD = "Mathias_Pucp2006";

    // Desarrollamos el metodo getConnection para obtener conexión en los demás archivos

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysqsl.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al conectar la base de datos");
        }

        //Devolvemos la conexión
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
