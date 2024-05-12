package banco;

import java.time.LocalDate;
import java.util.Random;

import banco.utils.Sucursal;
import banco.utils.TipoTarjeta;

public class Tarjeta {
    String numeroTarjeta, clabe, cvv;
    Sucursal sucursalRegistro;
    TipoTarjeta tipo;
    double saldo;
    LocalDate fechaCreacion, fechaVencimiento, fechaUltimoMovimiento;

    public Tarjeta (Sucursal sucursalRegistro, TipoTarjeta tipo, String clabe, int numeroTarjeta, int cvv, LocalDate fechaVencimiento, int saldo) {
        this.sucursalRegistro = sucursalRegistro;
        this.tipo = tipo;    
        this.numeroTarjeta = generarNumeroTarjeta(sucursalRegistro);
        this.clabe = generarClabe(sucursalRegistro, clabe);        
        this.cvv = generarCvv();
        this.fechaVencimiento = LocalDate.now().plusYears(5);
        this.saldo = saldo;
        this.fechaUltimoMovimiento = null;
        this.fechaCreacion = LocalDate.now();
    }

    public static String generarNumeroTarjeta(Sucursal sucursal) {
        Random ran = new Random();

        String numeroTarjeta="";    

        for(int i = 0; i<12; i++){
            int l = ran.nextInt(9)+1;

            numeroTarjeta = numeroTarjeta + l;
        }

        if (sucursal == Sucursal.Madero) {
            return "5629" + numeroTarjeta;
        } else {
            return "5627" + numeroTarjeta;
        }
        
    }

    public static String generarClabe(Sucursal sucursal, String numeroTarjeta) {
        Random ran = new Random();

        String clabe=numeroTarjeta.substring(4,15);    
        int l = ran.nextInt(9)+1;

        if (sucursal == Sucursal.Madero) {
            return "562912" + clabe + l;
        } else {
            return "562784" + clabe + l;
        }
    }

    public static String generarCvv() {
        Random ran = new Random();

        String cvv="";    

        for(int i = 0; i<3; i++){
            int l = ran.nextInt(9)+1;

            cvv = cvv + l;
        }

        return cvv;
    }

}