package pe.edu.cibertec.appbancocibertec.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cuentadto {
    private int id;
    private String cuenta;
}
