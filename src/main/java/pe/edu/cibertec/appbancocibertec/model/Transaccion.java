package pe.edu.cibertec.appbancocibertec.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Table(name = "Transaccion")
@Entity
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cuentaorigenid;
    private int cuentadestinoid;
    private double monto;
    private Date fecha;
}
