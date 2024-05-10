package usuario;

import java.util.Scanner;

import banco.Banco;
import banco.utils.Sucursal;
import usuario.utils.DatosComun;
import usuario.utils.Rol;

public class Inversionista extends Persona{
    private static Scanner leerCadenas = new Scanner(System.in);
    private long dineroInvertido = 0;

    public Inversionista(String nombre, String primerApellido, String segundoApellido, String nombreUsuario, String contra, Sucursal sucursal){
        super(nombre, primerApellido, segundoApellido, nombreUsuario, contra, sucursal, Rol.Inversionista);
    }

    public static void agregarInversionista(Sucursal sucursal){

        System.out.println("Ingrese nombre:");
        String nombre = leerCadenas.nextLine();

        System.out.println("Ingrese apellido paterno:");
        String primerApellido = leerCadenas.nextLine();

        System.out.println("Ingrese apellido materno: ");
        String segundoApellido = leerCadenas.nextLine();

        String nombreUsuario = DatosComun.obtenerNombreUsuario();

        System.out.println("Ingrese su contraseña: ");
        String contra = leerCadenas.nextLine();

        Banco.usuarios.get(Rol.Inversionista).add(new Inversionista(nombre, primerApellido, segundoApellido, nombreUsuario, contra, sucursal));
    }

    public long getDineroInvertido(){
        return dineroInvertido;
    }
}
