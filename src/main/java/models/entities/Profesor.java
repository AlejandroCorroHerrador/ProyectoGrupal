package models.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "alumno", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_profesor", "id_alumno"})
})
public class Profesor implements Serializable {
    @Id
    @Column(name = "id_profesor")
    private Long idProfesor;

    @OneToOne
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    private Alumno alumno;
}
