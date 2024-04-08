package models.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "alumno", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_alumno", "id_profesor"})
})
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Long idAlumno;

    @ManyToOne
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_profesor")
    private Profesor profesor;

    @Column(name = "nombre_alumno")
    private String nombre_alumno;

    @Column(name = "apellido_alumno")
    private String apellido_alumno;

    @Column(name = "email")
    private String email;

    @Column(name = "curso")
    private String curso;

    @Column(name = "grupo")
    private String grupo;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "servidor")
    private String servidor;

    @Column(name = "comodin")
    private int comodin;

    public Alumno(Long idAlumno, Profesor profesor, String nombre_alumno, String apellido_alumno, String email, String curso,
                  String grupo, String username, String password, String servidor, int comodin) {
        this.idAlumno = idAlumno;
        this.profesor = profesor;
        this.nombre_alumno = nombre_alumno;
        this.apellido_alumno = apellido_alumno;
        this.email = email;
        this.curso = curso;
        this.grupo = grupo;
        this.username = username;
        this.password = password;
        this.servidor = servidor;
        this.comodin = comodin;
    }

    public Alumno() {

    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getApellido_alumno() {
        return apellido_alumno;
    }

    public void setApellido_alumno(String apellido_alumno) {
        this.apellido_alumno = apellido_alumno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public int getComodin() {
        return comodin;
    }

    public void setComodin(int comodin) {
        this.comodin = comodin;
    }
}
