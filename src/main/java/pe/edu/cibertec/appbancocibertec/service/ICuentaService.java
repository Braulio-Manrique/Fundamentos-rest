package pe.edu.cibertec.appbancocibertec.service;

import pe.edu.cibertec.appbancocibertec.dto.Cuentadto;
import pe.edu.cibertec.appbancocibertec.dto.TransferenciaDTO;

import java.util.List;

public interface ICuentaService {
        List<Cuentadto> listarCuentas();
        void transferir(TransferenciaDTO transferenciaDTO);
}
