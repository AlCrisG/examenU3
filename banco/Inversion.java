package banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import banco.utils.Sucursal;
import usuario.Inversionista;

public class Inversion {
    LocalDateTime fechaMovimiento;
    Inversionista inversor;
    Sucursal sucursal;
    long montoInversion;

    public Inversion(long montoInversion, LocalDateTime fechaMovimiento, Inversionista inversionista, Sucursal sucursal){
        this.montoInversion = montoInversion;
        this.fechaMovimiento = fechaMovimiento;
        this.inversor = inversionista;
        this.sucursal = sucursal;
    }

    public Sucursal getSucursal(){
        return sucursal;
    }

    public static void consultarTodas(Sucursal sucursal){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        if(Banco.inversiones.isEmpty()){
            System.out.println("No hay inversiones en la sucursal.");
        }
        else{
            for(Inversion inversion : Banco.inversiones){
                if(inversion.getSucursal() == sucursal){
                    System.out.println("======================================================");
                    System.out.printf("Monto de inversion: %s%n", inversion.montoInversion);
                    System.out.printf("Inversionista: %s%n", inversion.inversor.getNombreCompleto());
                    System.out.printf("Fecha del movimiento: %s a las %s%n", inversion.fechaMovimiento.format(formatoFecha), inversion.fechaMovimiento.format(formatoHora));
                    System.out.println("======================================================");
                }
            }
        }
    }

    public static void consultarPorInversor(int id, Sucursal sucursal){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        int cont = 0;
        if(Banco.inversiones.isEmpty()){
            System.out.println("No hay inversiones en la sucursal.");
        }
        else{
            for(Inversion inversion : Banco.inversiones){
                if(inversion.getSucursal() == sucursal && inversion.inversor.getId() == id){
                    System.out.println("======================================================");
                    System.out.printf("Monto de inversion: %s%n", inversion.montoInversion);
                    System.out.printf("Inversionista: %s%n", inversion.inversor.getNombreCompleto());
                    System.out.printf("Fecha del movimiento: %s a las %s%n", inversion.fechaMovimiento.format(formatoFecha), inversion.fechaMovimiento.format(formatoHora));
                    System.out.println("======================================================");
                    cont++;
                }
            }
        }

        if(cont == 0){
            System.out.println("No hay inversiones para el inversionista en la sucursal.");
        }
    }
}
