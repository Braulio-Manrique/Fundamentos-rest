package pe.edu.cibertec.appbancocibertec.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appbancocibertec.dto.Cuentadto;
import pe.edu.cibertec.appbancocibertec.dto.TransferenciaDTO;
import pe.edu.cibertec.appbancocibertec.model.Cuenta;
import pe.edu.cibertec.appbancocibertec.model.Transaccion;
import pe.edu.cibertec.appbancocibertec.repository.CuentaRepository;
import pe.edu.cibertec.appbancocibertec.repository.TransaccionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class CuentaService implements ICuentaService{
    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;
    @Override
    public List<Cuentadto> listarCuentas() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        List<Cuentadto> cuentaDtos = new ArrayList<>();
        for (Cuenta cuenta : cuentas) {
            cuentaDtos.add(Cuentadto.builder().id(cuenta.getId()).cuenta(cuenta.getNombre()).build());
        }
        return cuentaDtos;
    }
@Transactional
    @Override
    public void transferir(TransferenciaDTO transferenciaDTO) {
        Cuenta cuentaOrigen =  cuentaRepository.findById(transferenciaDTO.getCuentaorigenid()).orElseThrow(()-> new RuntimeException("No existe el cuenta"));
        Cuenta cuentaDestino =  cuentaRepository.findById(transferenciaDTO.getCuentadestinoid()).orElseThrow(()-> new RuntimeException("No destino no existe"));
    if(cuentaOrigen.getSaldo()< transferenciaDTO.getMonto()){
        throw new RuntimeException("El saldo no tiene suficiente monto");
    }
    cuentaOrigen.setSaldo(cuentaOrigen.getSaldo()-transferenciaDTO.getMonto());
    cuentaDestino.setSaldo(cuentaOrigen.getSaldo()+transferenciaDTO.getMonto());
        Transaccion nuevaTransaccion = new Transaccion();
        nuevaTransaccion.setCuentaorigenid(cuentaOrigen.getId());
        nuevaTransaccion.setCuentadestinoid(cuentaDestino.getId());
        nuevaTransaccion.setMonto(transferenciaDTO.getMonto());
        nuevaTransaccion.setFecha(LocalDateTime.now());
        transaccionRepository.save(nuevaTransaccion);
        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);

    }
}
