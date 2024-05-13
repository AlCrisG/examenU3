package banco;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import banco.utils.EstatusSolicitud;
import banco.utils.Sucursal;
import banco.utils.TipoTarjeta;
import banco.utils.TipoTarjetaCredito;

public class Tarjeta {
    private String numeroTarjeta, clabe, cvv;
    private Sucursal sucursalRegistro;
    private TipoTarjeta tipo;
    private TipoTarjetaCredito tipoCredito;
    private EstatusSolicitud estatus;    
    private double saldo, creditoMaximo;
    private LocalDate fechaVencimiento, fechaUltimoMovimiento;
    private final LocalDate fechaCreacion;

    public Tarjeta (Sucursal sucursalRegistro, TipoTarjeta tipo) {
        this.sucursalRegistro = sucursalRegistro;
        this.tipo = tipo;    
        this.numeroTarjeta = generarNumeroTarjeta(sucursalRegistro);
        this.clabe = generarClabe(sucursalRegistro, clabe);        
        this.cvv = generarCvv();
        this.fechaVencimiento = LocalDate.now().plusYears(5);
        this.saldo = 0;        
        this.fechaCreacion = LocalDate.now();
    }

    public Tarjeta (Sucursal sucursalRegistro, TipoTarjeta tipo, TipoTarjetaCredito tipoCredito, double creditoMaximo) {
        this.sucursalRegistro = sucursalRegistro;
        this.tipo = tipo;
        this.tipoCredito = tipoCredito;
        this.numeroTarjeta = generarNumeroTarjeta(sucursalRegistro);
        this.clabe = generarClabe(sucursalRegistro, clabe);        
        this.cvv = generarCvv();
        this.fechaVencimiento = LocalDate.now().plusYears(5);
        this.saldo = 0;        
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

    public void solicitarTarjeta() {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        int opcion;  
        
        System.out.println("¿Qué categoría de tarjeta desea solicitar?");
        System.out.println("1. Simplicity \n 2. Platino \n 3. Oro");
        opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                if(this.saldo<50000) {
                    System.out.println("Necesitas un saldo mínimo de $50,000 MXN para solicitar esta tarjeta.");
                } else {

                }
                break;        
            default:
                break;
        }
    }

    public void realizarPagoCredito() {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        double pago;

        System.out.print("Ingrese la cantidad de su pago a crédito: ");
        pago = leer.nextDouble();

        if(pago<creditoMaximo) {
            this.creditoMaximo = creditoMaximo-pago;
            this.fechaUltimoMovimiento = LocalDate.now();
        } else {
            System.out.println("El monto de tu compra es mayor a tu crédito restante.\n Realiza el pago de la tarjeta para aumentar tu crédito.");
        }    
    }

    public void pagarTarjetaCredito() {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        int opcion;
        double pago;

        System.out.print("¿Cómo desea hacer su pago? \n 1. Efectivo \n 2. Saldo en tarjeta de débito");
        opcion= leer.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese la cantidad a pagar: ");
                pago= leer.nextDouble();

                this.creditoMaximo = creditoMaximo + pago;
                this.fechaUltimoMovimiento = LocalDate.now();
                System.out.println("Pago de tarjeta realizado con éxito");                
                break;
            case 2:
                System.out.print("Ingrese la cantidad a pagar: ");
                pago= leer.nextDouble();

                if(pago<saldo) {                
                    this.creditoMaximo = creditoMaximo + pago;
                    this.saldo = saldo - pago;
                    this.fechaUltimoMovimiento = LocalDate.now();
                    System.out.println("Pago de tarjeta realizado con éxito");
                } else {
                    System.out.println("Error en el pago de tarjeta. Fondos insuficientes.");
                }
                break;        
            default:
                System.out.println("Opción inválida.");
                break;
        }
    }

    public void depositarDinero() {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        double deposito;

        System.out.print("¿Cuánto dinero desea depositar?");
        deposito = leer.nextDouble();

        this.saldo = saldo + deposito;
        this.fechaUltimoMovimiento = LocalDate.now();
        System.out.println("Depósito hecho con éxito.");
    }

    public void retirarDinero() {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        double retiro;

        System.out.print("¿Cuánto dinero desea retirar?");
        retiro = leer.nextDouble();

        if(saldo>retiro) {
            this.saldo = saldo - retiro;
            this.fechaUltimoMovimiento = LocalDate.now();
            System.out.println("Se han retirado $" + retiro + " de su cuenta.");
        } else {
            System.out.println("Error al retirar. Fondos insuficientes.");
        }
        
    }

    public void realizarPagoDebito() {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        double pago;

        System.out.print("Ingrese la cantidad de su pago");
        pago = leer.nextDouble();

        if(saldo>pago) {
            this.saldo = saldo - pago;
            this.fechaUltimoMovimiento = LocalDate.now();
            System.out.println("Pago con éxito. \n Se ha hecho un cargo de $" + pago + " a su cuenta.");
        } else {
            System.out.println("Error de pago. Fondos insuficientes.");
        }
    }    
    
    public TipoTarjeta getTipoTarjeta() {
        return tipo;
    }

    public TipoTarjetaCredito getTipoTarjetaCredito() {
        return tipoCredito;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getClabe() {
        return clabe;
    }

    public String getCvv() {
        return cvv;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getCreditoMaximo() {
        return creditoMaximo;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public LocalDate getFechaUltimoMovimiento() {
        return fechaUltimoMovimiento;
    }

    public LocalDate getFechaCreacion() {
        return fechaUltimoMovimiento;
    }

    public void setTipoTarjetaCredito(TipoTarjetaCredito tipoCredito) {
        this.tipoCredito = tipoCredito;
    }
}