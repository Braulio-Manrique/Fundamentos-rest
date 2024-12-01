package pe.edu.cibertec.appbancocibertec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.appbancocibertec.dto.Cuentadto;
import pe.edu.cibertec.appbancocibertec.dto.TransferenciaDTO;
import pe.edu.cibertec.appbancocibertec.model.Transaccion;
import pe.edu.cibertec.appbancocibertec.service.ICuentaService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1/cuenta")
public class CuentaController {
    private final ICuentaService cuentaService;
    @PostMapping("/transaccion")
    public ResponseEntity<String> transaccion(@RequestBody TransferenciaDTO transferenciaDTO) {


        try {
            cuentaService.transferir(transferenciaDTO);
            return new ResponseEntity<>("Transferencia correcta", HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity<>("Erro: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @GetMapping()
    public  ResponseEntity<List<Cuentadto>> getCuenta() {
        return  new ResponseEntity<>(cuentaService.listarCuentas(),HttpStatus.OK);

    }
}
