package Daos;

import Beans.Prestamo;
import com.sun.tools.attach.AgentInitializationException;

import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PrestamosDao extends DaoBase {

    // Metodo para registrar un prestamo
    public void registrarPrestamo(int idUsuario, int idLibro) {

        String sql = """
                INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo, fecha_limite)
                VALUES (?, ?, ?, ?)
                """;

        // Primero obtenemos la fecha actual y calculamos la fecha de devolución
        LocalDate hoy = LocalDate.now();
        LocalDate limite = hoy.plusDays(7); // añadimos 7 dias pues es la fecha maxima de prestamo

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idLibro);
            pstmt.setDate(3, Date.valueOf(hoy));
            pstmt.setDate(4, Date.valueOf(limite));

            // ejecutamos el registro del prestamos
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listamos los libros de un usuario
    public ArrayList<Prestamo> listarPrestamos() {
        ArrayList<Prestamo> lista = new ArrayList<>();

        String sql ="""
                SELECT p.id_prestamo, p.id_usuario, p.id_libro, p.fecha_prestamos, p.fecha_limite
                FROM prestamo p
                INNER JOIN libro l ON p.id_libro = l.id_libro
                INNER JOIN usuario u ON p.id_usuario = u.id_usuario
                """;

        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Prestamo p = new Prestamo();
                p.setIdPrestamo(rs.getInt("id_prestamo"));
                p.setIdUsuario(rs.getInt("id_usuario"));
                p.setIdLibro(rs.getInt("id_libro"));
                p.setFechaPrestamo(rs.getDate("fecha_limite"));
                p.setTituloLibro(rs.getString("titulo"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
