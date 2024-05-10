package isi.dan.app02.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "APP2_EQUIPO")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP2_SEQ_EQUIPO")
    @SequenceGenerator(name = "APP2_SEQ_EQUIPO", allocationSize = 1,initialValue = 1,sequenceName = "SEQ_APP2_EQUIPO")
    private Integer id;

    @Column(name = "NOMBRE_EQUIPO")
    private String nombre;
    @Column(name = "CANTIDAD_SOCIOS")
    private Integer cantidadSocios;

    @OneToMany(mappedBy = "equipo")
    @JsonIgnore
    private List<Jugador> jugadores;

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
    public Integer getCantidadSocios() {
        return cantidadSocios;
    }
    public void setCantidadSocios(Integer cantidadSocios) {
        this.cantidadSocios = cantidadSocios;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    
}
