package pe.edu.cibertec.appbancocibertec.dto;

import lombok.Data;



@Data
public class TransferenciaDTO {
    private Integer cuentaorigenid;
    private Integer cuentadestinoid;
    private Double monto;


}
