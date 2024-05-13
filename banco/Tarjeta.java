package banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

import banco.utils.Sucursal;
import banco.utils.TipoTarjeta;
import banco.utils.TipoTarjetaCredito;
import banco.utils.EstatusSolicitud;
import usuario.Cliente;

public class Tarjeta {
    private static Scanner leerNumeros = new Scanner(System.in);
    private String clabe, numeroTarjeta, cvv;
    private Sucursal sucursalRegistro;
    private TipoTarjeta tipo;
    private TipoTarjetaCredito tipoCredito = null;
    private double saldo, creditoMaximo, creditoDisponible;
    private Cliente titular;
    private EstatusSolicitud estatus;
    private LocalDateTime fechaCreacion, fechaVencimiento, fechaUltimoMovimiento, fechaRespuesta;
    private static int idSolicitudGlobal = 1;
    private int idSolicitud;

    public Tarjeta (Cliente titular, Sucursal sucursalRegistro, TipoTarjeta tipo) {
        this.titular = titular;
        this.sucursalRegistro = sucursalRegistro;
        this.tipo = tipo;    
        this.numeroTarjeta = generarNumeroTarjeta(sucursalRegistro);
        this.clabe = generarClabe(sucursalRegistro, this.numeroTarjeta);        
        this.cvv = generarCvv();
        this.fechaVencimiento = LocalDateTime.now().plusYears(5);
        this.saldo = 0;        
        this.fechaCreacion = LocalDateTime.now();
    }

    public Tarjeta (Cliente titular, Sucursal sucursalRegistro, TipoTarjeta tipo, TipoTarjetaCredito tipoCredito, double creditoMaximo) {
        this.titular = titular;
        this.sucursalRegistro = sucursalRegistro;
        this.tipo = tipo;
        this.tipoCredito = tipoCredito;
        this.numeroTarjeta = generarNumeroTarjeta(sucursalRegistro);
        this.clabe = generarClabe(sucursalRegistro, this.numeroTarjeta);        
        this.cvv = generarCvv();
        this.fechaVencimiento = LocalDateTime.now().plusYears(5);
        this.fechaCreacion = LocalDateTime.now();
        this.estatus = EstatusSolicitud.EnProceso;
        this.creditoMaximo = creditoMaximo;
        this.creditoDisponible = creditoMaximo;
        this.idSolicitud = idSolicitudGlobal;
        idSolicitudGlobal++;
    }

    private static String generarNumeroTarjeta(Sucursal sucursal) {
        Random ran = new Random();

        String numeroTarjeta="";    

        for(int i = 0; i<12; i++){
            int l = ran.nextInt(9)+1;

            numeroTarjeta = numeroTarjeta + l;
        }

        if (sucursal == Sucursal.Madero) {
            numeroTarjeta = "5629" + numeroTarjeta;
        } else {
            numeroTarjeta = "5627" + numeroTarjeta;
        }
        System.out.println(numeroTarjeta);
        return numeroTarjeta;
    }

    private static String generarClabe(Sucursal sucursal, String numeroTarjeta) {
        Random ran = new Random();

        String clabe=numeroTarjeta.substring(4,15);    
        int l = ran.nextInt(9)+1;

        if (sucursal == Sucursal.Madero) {
            return "562912" + clabe + l;
        } else {
            return "562784" + clabe + l;
        }
    }

    private static String generarCvv() {
        Random ran = new Random();

        String cvv="";    

        for(int i = 0; i<3; i++){
            int l = ran.nextInt(9)+1;

            cvv = cvv + l;
        }

        return cvv;
    }

    public static void solicitarTarjeta(Cliente cliente) {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        int opcion = 0, cont = 1;
        if(getSaldoTarjetaDebito(cliente) <= 50000){
            System.out.println("Aún no puede solicitar ninguna tarjeta de crédito");
            return;
        }
        if(getSaldoTarjetaDebito(cliente) >= 50000){
            System.out.println("+-------------------------+");
            System.out.println("|    SOLICITAR TARJETA    |");
            System.out.println("+-------------------------+");
            System.out.println("|   1   | Simplicity      |");
            cont++;
        }
        if(getSaldoTarjetaDebito(cliente) >= 100000){
            System.out.println("|   2   | Platino         |");
            cont++;
        }
        if(getSaldoTarjetaDebito(cliente) >= 200000){
            System.out.println("|   3   | Oro             |");
            cont++;
        }
        if(cont != 0){
            System.out.printf("|   %s   | Regresar        |%n", cont);
            System.out.println("+-------------------------+");
            System.out.println("Ingrese una opcion: ");
            opcion = leer.nextInt();
        

            switch (cont) {
                case 2:
                    switch(opcion){
                        case 1:
                            if(!cliente.tieneSimplicity()){
                                solicitarTarjetaCredito(cliente, TipoTarjetaCredito.Simplicity, 60000);
                                cliente.setTieneSolicitud(true);
                            } else{
                                System.out.println("Ya tiene una tarjeta de este tipo.");
                            }
                            break;

                        case 2:
                            break;
                    }
                    break;

                case 3:
                    switch(opcion){
                        case 1:
                            if(!cliente.tieneSimplicity()){
                                solicitarTarjetaCredito(cliente, TipoTarjetaCredito.Simplicity, 60000);
                                cliente.setTieneSolicitud(true);
                            } else{
                                System.out.println("Ya tiene una tarjeta de este tipo.");
                            }
                            break;

                        case 2:
                            if(!cliente.tienePlatino()){
                                solicitarTarjetaCredito(cliente, TipoTarjetaCredito.Platino, 150000);
                                cliente.setTieneSolicitud(true);
                            } else{
                                System.out.println("Ya tiene una tarjeta de este tipo.");
                            }
                            break;

                        case 3:
                            break;
                    }
                    break;

                case 4:
                    switch(opcion){
                        case 1:
                            if(!cliente.tieneSimplicity()){
                                solicitarTarjetaCredito(cliente, TipoTarjetaCredito.Simplicity, 60000);
                                cliente.setTieneSolicitud(true);
                            } else{
                                System.out.println("Ya tiene una tarjeta de este tipo.");
                            }
                            break;

                        case 2:
                            if(!cliente.tienePlatino()){
                                solicitarTarjetaCredito(cliente, TipoTarjetaCredito.Platino, 150000);
                                cliente.setTieneSolicitud(true);
                            } else{
                                System.out.println("Ya tiene una tarjeta de este tipo.");
                            }
                            break;

                        case 3:
                            if(!cliente.tieneOro()){
                                solicitarTarjetaCredito(cliente, TipoTarjetaCredito.Oro, 400000);
                                cliente.setTieneSolicitud(true);
                            } else{
                                System.out.println("Ya tiene una tarjeta de este tipo.");
                            }
                            break;

                        case 4:
                            break;
                    }
                    break;
            
                default:
                    break;
            }
        }
    }

    private static double getSaldoTarjetaDebito(Cliente cliente){
        double saldo = 0;
        for(Tarjeta tarjeta : Banco.tarjetas){
            if(tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Debito){
                saldo = tarjeta.getSaldo();
            }
        }
        return saldo;
    }

    public static void generarTarjetaDebito(Cliente cliente){
        Banco.tarjetas.add(new Tarjeta(cliente, cliente.getSucursal(), TipoTarjeta.Debito));
    }

    private static void solicitarTarjetaCredito(Cliente cliente, TipoTarjetaCredito tipoTarjetaCredito, double creditoMaximo){
        Banco.tarjetas.add(new Tarjeta(cliente, cliente.getSucursal(), TipoTarjeta.Credito, tipoTarjetaCredito, creditoMaximo));
    }

    public static void listarTarjetasUsuario(Cliente cliente){
        for(Tarjeta tarjeta : Banco.tarjetas){
            if(tarjeta.getTitular() == cliente){
                if(tarjeta.getTipoTarjeta() == TipoTarjeta.Debito){
                    mostrarInformacionTarjetaDebito(tarjeta);
                } else{
                    if(tarjeta.estatus == EstatusSolicitud.Aprobada){
                        mostrarInformacionTarjetaCredito(tarjeta);
                    }
                }
            }
        }
        System.out.println("======================================================");
    }

    private static void mostrarInformacionTarjetaDebito(Tarjeta tarjeta) {
        DateTimeFormatter vencimiento = DateTimeFormatter.ofPattern("MM/yyyy");
        DateTimeFormatter movimiento = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        System.out.println("======================================================");
        System.out.printf("Número de tarjeta: %s%n", tarjeta.getNumeroTarjeta());
        System.out.printf("Clabe interbancaria: %s%n", tarjeta.getClabe());
        System.out.printf("CVV: %s%n", tarjeta.getCvv());
        System.out.printf("Fecha de vencimiento: %s%n", tarjeta.getFechaVencimiento().format(vencimiento));        
        System.out.printf("Saldo: %s%n", tarjeta.getSaldo());
        if(tarjeta.fechaUltimoMovimiento != null){
            System.out.printf("Fecha del último movimiento: %s%n", tarjeta.getFechaUltimoMovimiento().format(movimiento));
        }
        System.out.printf("Fecha de creación: %s%n", tarjeta.getFechaCreacion().format(movimiento));
    }

    private static void mostrarInformacionTarjetaCredito(Tarjeta tarjeta) {
        DateTimeFormatter vencimiento = DateTimeFormatter.ofPattern("MM/yyyy");
        DateTimeFormatter movimiento = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        System.out.println("======================================================");
        System.out.printf("Tipo de crédito: %s%n", tarjeta.getTipoTarjetaCredito());
        System.out.printf("Número de tarjeta: %s%n", tarjeta.getNumeroTarjeta());
        System.out.printf("Clabe interbancaria: %s%n", tarjeta.getClabe());
        System.out.printf("CVV: %s%n", tarjeta.getCvv());
        System.out.printf("Fecha de vencimiento: %s%n", tarjeta.getFechaVencimiento().format(vencimiento));        
        System.out.printf("Crédito máximo: %s%n", tarjeta.getCreditoMaximo());
        System.out.printf("Crédito disponible: %s%n", tarjeta.creditoDisponible);
        if(tarjeta.fechaUltimoMovimiento != null){
            System.out.printf("Fecha del último movimiento: %s%n", tarjeta.getFechaUltimoMovimiento().format(movimiento));
        }
        System.out.printf("Fecha de aprobación: %s%n", tarjeta.fechaRespuesta.format(movimiento));
    }

    public static void seleccionarTarjeta(Cliente cliente){
        int cont = 2, i = 2;
        System.out.println("SUS TARJETAS:");
        System.out.println("1. Tarjeta - Débito");
        for(Tarjeta tarjeta : Banco.tarjetas){
            if(tarjeta.estatus == EstatusSolicitud.Aprobada && tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Credito){
                System.out.printf("%s. Tarjeta - Crédito %s%n", cont, tarjeta.tipoCredito);
                cont++;
            }
        }
        System.out.printf("%s. Regresar%n", cont);
        System.out.println("SU ELECCIÓN: ");
        int opcion = leerNumeros.nextInt();

        switch(cont){
            case 2:
                switch(opcion){
                    case 1:
                        for(Tarjeta tarjeta : Banco.tarjetas){
                            if(tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Debito){
                                menuTarjetaDebito(tarjeta);
                            }
                        }
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            case 3:
                switch (opcion) {
                    case 1:
                        for(Tarjeta tarjeta : Banco.tarjetas){
                            if(tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Debito){
                                menuTarjetaDebito(tarjeta);
                                break;
                            }
                        }
                        break;

                    case 2:
                        for(Tarjeta tarjeta : Banco.tarjetas){
                            if(tarjeta.estatus == EstatusSolicitud.Aprobada && tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Credito){
                                menuTarjetaCredito(tarjeta);
                                break;
                            }
                        }
                        break;

                    case 3:
                        break;
                
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
                break;

            case 4:
                i = 2;
                switch (opcion) {
                    case 1:
                        for(Tarjeta tarjeta : Banco.tarjetas){
                            if(tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Debito){
                                menuTarjetaDebito(tarjeta);
                                break;
                            }
                        }
                        break;

                    case 2:
                        i = 2;
                        for(Tarjeta tarjeta : Banco.tarjetas){
                            if(tarjeta.estatus == EstatusSolicitud.Aprobada && tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Credito && i == 2){
                                menuTarjetaCredito(tarjeta);
                                break;
                            }
                            if(tarjeta.estatus == EstatusSolicitud.Aprobada && tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Credito){
                                i++;
                            }
                        }
                        break;

                    case 3:
                        i = 2;
                        for(Tarjeta tarjeta : Banco.tarjetas){
                            if(tarjeta.estatus == EstatusSolicitud.Aprobada && tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Credito && i == 3){
                                menuTarjetaCredito(tarjeta);
                                break;
                            }
                            if(tarjeta.estatus == EstatusSolicitud.Aprobada && tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Credito){
                                i++;
                            }
                        }
                        break;
                
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
                break;

            case 5:
                switch (opcion) {
                    case 1:
                        for(Tarjeta tarjeta : Banco.tarjetas){
                            if(tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Debito){
                                menuTarjetaDebito(tarjeta);
                                break;
                            }
                        }
                        break;

                    case 2:
                        i = 2;
                        for(Tarjeta tarjeta : Banco.tarjetas){
                            if(tarjeta.estatus == EstatusSolicitud.Aprobada && tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Credito && i == 2){
                                menuTarjetaCredito(tarjeta);
                                break;
                            }
                            if(tarjeta.estatus == EstatusSolicitud.Aprobada && tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Credito){
                                i++;
                            }
                        }
                        break;

                    case 3:
                        i = 2;
                        for(Tarjeta tarjeta : Banco.tarjetas){
                            if(tarjeta.estatus == EstatusSolicitud.Aprobada && tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Credito && i == 3){
                                menuTarjetaCredito(tarjeta);
                                break;
                            }
                            if(tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Credito){
                                i++;
                            }
                        }
                        break;

                    case 4:
                        i = 2;
                        for(Tarjeta tarjeta : Banco.tarjetas){
                            if(tarjeta.estatus == EstatusSolicitud.Aprobada && tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Credito && i == 4){
                                menuTarjetaCredito(tarjeta);
                                break;
                            }
                            if(tarjeta.estatus == EstatusSolicitud.Aprobada && tarjeta.getTitular() == cliente && tarjeta.getTipoTarjeta() == TipoTarjeta.Credito){
                                i++;
                            }
                        }
                        break;
                
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
                break;
        }
    }

    private static void menuTarjetaDebito(Tarjeta tarjeta){
        int opcion;
        do{
            System.out.println("|  MENU TARJETA DÉBITO |");    
            System.out.println("+------------------------------------------+");
            System.out.println("| OPCIÓN |           DESCRIPCIÓN           |");
            System.out.println("+------------------------------------------+");
            System.out.println("|   1    | Ver datos de la tarjeta         |");
            System.out.println("|   2    | Realizar depósito               |");
            System.out.println("|   3    | Realizar retiro                 |");
            System.out.println("|   4    | Realizar pago                   |");
            System.out.println("|   5    | Volver                          |");
            System.out.println("+------------------------------------------+");
            System.out.print("Elige una opción: ");
            opcion = leerNumeros.nextInt();

            switch(opcion){
                case 1:
                    mostrarInformacionTarjetaDebito(tarjeta);
                    System.out.println("======================================================");
                    break;

                case 2:
                    depositarDinero(tarjeta);
                    break;

                case 3:
                    retirarDinero(tarjeta);
                    break;

                case 4:
                    realizarPagoDebito(tarjeta);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }while(opcion != 5);
    }

    private static void menuTarjetaCredito(Tarjeta tarjeta){
        int opcion;
        do{
            System.out.println("|  MENU TARJETA CRÉDITO " + tarjeta.getTipoTarjetaCredito() +" |");    
            System.out.println("+------------------------------------------+");
            System.out.println("| OPCIÓN |           DESCRIPCIÓN           |");
            System.out.println("+------------------------------------------+");
            System.out.println("|   1    | Ver datos de la tarjeta         |");                        
            System.out.println("|   2    | Realizar pago                   |");
            System.out.println("|   3    | Pagar tarjeta                   |");
            System.out.println("|   4    | Volver                          |");
            System.out.println("+------------------------------------------+");
            System.out.print("Elige una opción: ");
            opcion = leerNumeros.nextInt();

            switch (opcion) {
                case 1:
                    mostrarInformacionTarjetaCredito(tarjeta);
                    System.out.println("======================================================");
                    break;

                case 2:
                    realizarPagoCredito(tarjeta);
                    break;

                case 3:
                    pagarTarjetaCredito(tarjeta);
                    break;

                case 4:
                    return;
            
                default:
                    break;
            }
        }while(opcion != 4);
    }

    private static void realizarPagoCredito(Tarjeta tarjeta) {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        double pago;

        System.out.print("Ingrese la cantidad de su pago a crédito: ");
        pago = leer.nextDouble();

        if(pago <= tarjeta.creditoDisponible) {
            tarjeta.creditoDisponible = tarjeta.creditoDisponible - pago;
            tarjeta.fechaUltimoMovimiento = LocalDateTime.now();
        } else {
            System.out.println("El monto de tu compra es mayor a tu crédito restante.\n Realiza el pago de la tarjeta para aumentar tu crédito.");
        }    
    }

    private static void pagarTarjetaCredito(Tarjeta tarjeta) {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        int opcion;
        double pago;

        System.out.print("¿Cómo desea hacer su pago? \n 1. Efectivo \n 2. Saldo en tarjeta de débito\n");
        System.out.print("Su elección: ");
        opcion= leer.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese la cantidad a pagar: ");
                pago= leer.nextDouble();

                tarjeta.creditoDisponible = tarjeta.creditoDisponible + pago;
                tarjeta.fechaUltimoMovimiento = LocalDateTime.now();
                System.out.println("Pago de tarjeta realizado con éxito");                
                break;
            case 2:
                System.out.print("Ingrese la cantidad a pagar: ");
                pago = leer.nextDouble();
                
                for(Tarjeta tarjetaDebito : Banco.tarjetas){
                    if(tarjeta.getTitular() == tarjetaDebito.getTitular() && tarjetaDebito.tipo == TipoTarjeta.Debito) {
                        if(pago <= tarjetaDebito.saldo){
                            tarjeta.creditoDisponible = tarjeta.creditoDisponible + pago;
                            if(tarjeta.creditoDisponible > tarjeta.creditoMaximo){
                                double aux = tarjeta.creditoDisponible - tarjeta.creditoMaximo;
                                tarjeta.creditoDisponible -= aux;
                                pago -= aux;
                                System.out.printf("No puede pagar más del crédito máximo. Se le devuelven $%s.%n", aux);
                            }
                            tarjetaDebito.setSaldo(tarjetaDebito.getSaldo() - pago);
                            tarjeta.fechaUltimoMovimiento = LocalDateTime.now();
                            System.out.println("Pago de tarjeta realizado con éxito");
                        }                
                        else {
                            System.out.println("Error en el pago de tarjeta. Fondos insuficientes.");
                        }
                    }
                }
                break;        
            default:
                System.out.println("Opción inválida.");
                break;
        }
    }

    private static void depositarDinero(Tarjeta tarjeta) {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        double deposito;

        System.out.print("¿Cuánto dinero desea depositar?");
        deposito = leer.nextDouble();

        tarjeta.saldo = tarjeta.saldo + deposito;
        tarjeta.fechaUltimoMovimiento = LocalDateTime.now();
        System.out.println("Depósito hecho con éxito.");
    }

    private static void retirarDinero(Tarjeta tarjeta) {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        double retiro;

        System.out.print("¿Cuánto dinero desea retirar?");
        retiro = leer.nextDouble();

        if(tarjeta.saldo >= retiro) {
            tarjeta.saldo = tarjeta.saldo - retiro;
            tarjeta.fechaUltimoMovimiento = LocalDateTime.now();
            System.out.println("Se han retirado $" + retiro + " de su cuenta.");
        } else {
            System.out.println("Error al retirar. Fondos insuficientes.");
        }
    }

    private static void realizarPagoDebito(Tarjeta tarjeta) {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        double pago;

        System.out.print("Ingrese la cantidad de su pago: ");
        pago = leer.nextDouble();

        if(tarjeta.saldo >= pago) {
            tarjeta.saldo = tarjeta.saldo - pago;
            tarjeta.fechaUltimoMovimiento = LocalDateTime.now();
            System.out.println("Pago con éxito. \n Se ha hecho un cargo de $" + pago + " a su cuenta.");
        } else {
            System.out.println("Error de pago. Fondos insuficientes.");
        }
    } 
    
    public static void verSolicitudesCliente(Cliente cliente){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        int cont = 0;
        for(Tarjeta tarjeta : Banco.tarjetas){
            if(tarjeta.getTitular() == cliente && tarjeta.tipo == TipoTarjeta.Credito){
                System.out.println("=====================================");
                System.out.println("Tipo de crédito: " + tarjeta.getTipoTarjetaCredito());
                System.out.println("Estatus: " + tarjeta.estatus);
                System.out.println("Fecha de solicitud: " + tarjeta.fechaCreacion.format(formatter));
                if(tarjeta.estatus == EstatusSolicitud.Aprobada){
                    System.out.println("Fecha de aprobación: " + tarjeta.fechaRespuesta.format(formatter));
                } else if(tarjeta.estatus == EstatusSolicitud.Rechazada){
                    System.out.println("Fecha de rechazo: " + tarjeta.fechaRespuesta.format(formatter));
                }
                System.out.println("=====================================");
                cont++;
            }
        }
        if(cont == 0){
            System.out.println("No se han realizado solicitudes.");
        }
    }

    public static boolean verSolicitudesTodos(EstatusSolicitud estatusSolicitud, Sucursal sucursal){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        int cont = 0;
        for(Tarjeta tarjeta : Banco.tarjetas){
            if(tarjeta.estatus == estatusSolicitud && tarjeta.tipo == TipoTarjeta.Credito && tarjeta.getSucursal() == sucursal){
                System.out.println("=====================================");
                System.out.println("No. de Solicitud: " + tarjeta.idSolicitud);
                System.out.println("Solicitante: " + tarjeta.getTitular().getNombreCompleto());
                System.out.println("Tipo de crédito: " + tarjeta.getTipoTarjetaCredito());
                System.out.println("Estatus: " + tarjeta.estatus);
                System.out.println("Fecha de solicitud: " + tarjeta.fechaCreacion.format(formatter));
                if(tarjeta.estatus == EstatusSolicitud.Aprobada){
                    System.out.println("Fecha de aprobación: " + tarjeta.fechaRespuesta.format(formatter));
                } else if(tarjeta.estatus == EstatusSolicitud.Rechazada){
                    System.out.println("Fecha de rechazo: " + tarjeta.fechaRespuesta.format(formatter));
                }
                double saldoDebito = 0;
                for(Tarjeta tarjeta2 : Banco.tarjetas){
                    if(tarjeta.getTitular() == tarjeta2.getTitular() && tarjeta2.getTipoTarjeta() == TipoTarjeta.Debito){
                        saldoDebito = tarjeta2.getSaldo();
                    }
                }
                System.out.println("Saldo en Tarjeta de Débito: " + saldoDebito);
                System.out.println("=====================================");
                cont++;
            }
        }
        if(cont == 0){
            System.out.println("No se han recibido solicitudes con este estatus.");
            return false;
        } else{
            return true;
        }
    }

    public static void cambiarEstatusSolicitud(Sucursal sucursal){
        if(verSolicitudesTodos(EstatusSolicitud.EnProceso, sucursal)){
            System.out.println("SELECCIONE UN NÚMERO DE SOLICITUD: ");
            int numSolicitud = leerNumeros.nextInt();
            boolean encontrado = false;

            for(Tarjeta tarjeta : Banco.tarjetas){
                if(tarjeta.estatus == EstatusSolicitud.EnProceso && tarjeta.idSolicitud == numSolicitud && tarjeta.getSucursal() == sucursal){
                    encontrado = true;
                    System.out.println("Seleccione una opción");
                    System.out.println("1. Aprobar");
                    System.out.println("2. Rechazar");
                    System.out.println("SU ELECCIÓN: ");
                    int opcion = leerNumeros.nextInt();

                    switch (opcion) {
                        case 1 -> tarjeta.setEstatus(EstatusSolicitud.Aprobada);
                        case 2 -> tarjeta.setEstatus(EstatusSolicitud.Rechazada);
                        default -> System.out.println("Opción no válida.");
                    }

                    if(tarjeta.estatus == EstatusSolicitud.Aprobada || tarjeta.estatus == EstatusSolicitud.Rechazada){
                        TipoTarjetaCredito tipoCredito = tarjeta.getTipoTarjetaCredito();
                        switch(tipoCredito){
                            case Simplicity -> tarjeta.getTitular().setTieneSimplicity(true);
                            case Platino -> tarjeta.getTitular().setTienePlatino(true);
                            case Oro -> tarjeta.getTitular().setTieneOro(true);
                        }
                        tarjeta.getTitular().setTieneSolicitud(false);
                        tarjeta.fechaRespuesta = LocalDateTime.now();
                    }
                }
            }

            if(!encontrado){
                System.out.println("No hay ninguna solicitud con ese número.");
            }
        }
    }

    public void setEstatus(EstatusSolicitud estatusSolicitud){
        this.estatus = estatusSolicitud;
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

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public LocalDateTime getFechaUltimoMovimiento() {
        return fechaUltimoMovimiento;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setTipoTarjetaCredito(TipoTarjetaCredito tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public Cliente getTitular(){
        return titular;
    }

    public Sucursal getSucursal(){
        return sucursalRegistro;
    }
}