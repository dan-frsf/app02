package isi.dan.app02.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "APP_JUGADOR")
public class Jugador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP2_SEQ_JUGADOR")
    @SequenceGenerator(name = "APP2_SEQ_JUGADOR", allocationSize = 1,initialValue = 1,sequenceName = "SEQ_APP2_JUGA")
    private Integer id;

    @Column(name = "NOMBRE_JUGADOR")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO")
    @Basic(fetch = FetchType.LAZY)
    @JsonIgnore // Ignore during serialization
    private Equipo equipo;

    private Integer pj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Integer getPj() {
        return pj;
    }

    public void setPj(Integer pj) {
        this.pj = pj;
    }

    
}
