package Beans;

import java.sql.Date;

public class Prestamo {
    private int idPrestamo;
    private int idUsuario;
    private int idLibro;
    private Date fechaPrestamo;
    private Date fechaLimite;

    // Agregamos aributos extra para guardar el titulo del libro y el nombre de usuario cuando hagamos la consulta SQL
    private String tituloLibro;
    private String nombreUsuario;


    public Prestamo() {
    }

    public Prestamo(int idPrestamo, int idUsuario, int idLibro, Date fechaPrestamo, Date fechaLimite, String tituloLibro, String nombreUsuario) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaLimite;
        this.tituloLibro = tituloLibro;
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
