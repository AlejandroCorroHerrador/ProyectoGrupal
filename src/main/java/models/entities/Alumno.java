package models.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "alumno", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_alumno", "id_profesor"})
})
public class Alumno implements Serializable {
    @Id
    @Column(name = "id_alumno")
    private Long idAlumno;

    @ManyToOne
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    private Profesor profesor;


}
