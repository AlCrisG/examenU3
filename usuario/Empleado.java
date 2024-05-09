package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import banco.Banco;
import banco.utils.Sucursal;
import usuario.utils.DatosComun;
import usuario.utils.Rol;

public class Empleado extends Persona{
    private static Scanner leerNumeros = new Scanner(System.in);
    private LocalDate fechaInicio;
    private double salario;

    public Empleado(String nombre, String primerApellido, String segundoApellido, String fecha, String genero, String ciudad, String estado, String direccion, LocalDate fechaInicio, Sucursal sucursal, double salario, Rol rol, String nombreUsuario, String contra){
        super(nombre, primerApellido, segundoApellido, fecha, genero, ciudad, estado, direccion, nombreUsuario, contra, rol, sucursal);
        this.fechaInicio = fechaInicio;
        this.salario = salario;
    }

    public static void agregarEmpleado(Rol rol, Sucursal sucursal){
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun();

        Sucursal sucursalRegistro = sucursal;

        String nombre = datosComun.get(0);
        String primerApellido = datosComun.get(1);
        String segundoApellido = datosComun.get(2);
        String fecha = datosComun.get(3);
        String genero = datosComun.get(4);
        String estado = datosComun.get(5);
        String ciudad = datosComun.get(6);
        String direccion = datosComun.get(7);
        String nombreUsuario = datosComun.get(8);
        String contra = datosComun.get(9);

        System.out.println("Ingrese el salario del empleado: ");
        double salario = leerNumeros.nextDouble();

        Banco.usuarios.get(rol).add(new Empleado(nombre, primerApellido, segundoApellido, fecha, genero, ciudad, estado, direccion, LocalDate.now(), sucursalRegistro,salario, rol, nombreUsuario, contra));
    }

    public LocalDate getFechaInicio(){
        return fechaInicio;
    }

    public double getSalario(){
        return salario;
    }
}
