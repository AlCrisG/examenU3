package banco;

import java.time.LocalDate;

import banco.utils.Sucursal;
import banco.utils.TipoTarjeta;

public class Tarjeta {
    String clabe;
    Sucursal sucursalRegistro;
    TipoTarjeta tipo;
    int numeroTarjeta, cvv;
    double saldo;
    LocalDate fechaCreacion, fechaVencimiento, fechaUltimoMovimiento;

    public Tarjeta (Sucursal sucursalRegistro, TipoTarjeta tipo, String clabe, int numeroTarjeta, int cvv, LocalDate fechaVencimiento, int saldo) {
        this.sucursalRegistro = sucursalRegistro;
        this.tipo = tipo;
        this.clabe = clabe;
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.fechaVencimiento = fechaVencimiento;
        this.saldo = saldo;
        this.fechaUltimoMovimiento = null;
        this.fechaCreacion = LocalDate.now();
    }

    
}