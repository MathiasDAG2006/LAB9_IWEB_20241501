package Daos;

import Beans.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibroDao extends DaoBase {

    // Funcion para listar libros
    public ArrayList<Libro> listarLibros() {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        String sql = """
                SELECT id_libro, id_genero, titulo, autor, anio_publicacion
                FROM libro
                """;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Recorremos las filas de libros para ir guardando cada uno en lista

            while (rs.next()) {
                Libro libro = new Libro();
                libro.setIdLibro(rs.getInt("id_libro"));
                libro.setIdGenero(rs.getInt("id_genero"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnioPublicacion(rs.getInt("anio_publicacion"));
                listaLibros.add(libro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaLibros;
    }

}
