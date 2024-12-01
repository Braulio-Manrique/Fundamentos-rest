package pe.edu.cibertec.appbancocibertec.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TransferenciaDTO {
    private Integer cuentaorigenid;
    private Integer cuentadestinoid;
    private Double monto;
    private LocalDateTime fecha;


}
