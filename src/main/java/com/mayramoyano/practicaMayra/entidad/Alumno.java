package com.mayramoyano.practicaMayra.entidad;

/*Aca estamos importando los paquetes*/
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

/*JPA: Hibernate*/
@Entity /*ESTA CLASE PERTENECE A UNA TABLA EN LA BASE DE DATOS*/

/*lombok*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

/*JPA: Hibernate*/
@Table(name = "alumnos") /*RENOMBRAMOS*/

public class Alumno {
    /*JPA: Hibernate*/
    @Id /*CLAVE PRIMARIA*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*EL ID NO LO ESCRIBIMOS NOSOTROS SINO QUE LE DECIMOS QUE SEA INCREMENTAL*/
    private Long id;
    private String nombre;
    private String apellido;

    /*RELACION UNO A UNO*/
    @OneToOne(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Legajo legajo;


    @ManyToMany
    @JoinTable(name = "alumno_materia", joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "materia_id"))
    private List<Materia> materias;
}
