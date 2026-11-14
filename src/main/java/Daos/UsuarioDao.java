package Daos;

import Beans.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao extends DaoBase {

    // Buscamos un usuario que coincida con las credenciales puestas
    public Usuario validarLogin(String email, String passwordHash) {
        Usuario usuario = null;
        String sql = """
                SELECT id_usuario, nombres, apellidos, email, rol, estado
                FROM usuario
                WHERE email = ? AND password_hash = ?
                """;

        // Abrimos la conexión

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, passwordHash);

            try (ResultSet rs = pstmt.executeQuery()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("email"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstado(rs.getString("estado"));


            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return usuario;

    }

    // Insertar un nuevo usuario en la base de datos

    public void registrarUsuario(Usuario usuario) {

        String sql = """
                INSERT INTO usuario (nombres, apellidos, email, password_hash, rol)
                VALUES (?, ?, ?, ?, 'LECTOR')
                """;
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombres());
            pstmt.setString(2, usuario.getApellidos());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getPasswordHash());
            pstmt.setString(5, usuario.getRol());

            pstmt.executeUpdate(); // ejecutamos la actualización

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
