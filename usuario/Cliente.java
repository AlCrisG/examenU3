package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import banco.Banco;
import banco.utils.Sucursal;
import usuario.utils.DatosComun;
import usuario.utils.Rol;

public class Cliente extends Persona{
    private static Scanner leerNumeros = new Scanner(System.in);
    private LocalDate fechaRegistro;
    private Sucursal sucursalRegistro;

    public Cliente(String nombre, String primerApellido, String segundoApellido, String fecha, String genero, String ciudad, String estado, String direccion, LocalDate fechaRegistro, Sucursal sucursalRegistro){
        super(nombre, primerApellido, segundoApellido, fecha, genero, ciudad, estado, direccion, Rol.Cliente);
        this.fechaRegistro = fechaRegistro;
        this.sucursalRegistro = sucursalRegistro;
    }

    public static void agregarCliente(){
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun();

        boolean respuestaValida;
        Sucursal sucursalRegistro = null;
        do{
            respuestaValida = true;
            System.out.println("Ingrese la sucursal de registro: ");
            System.out.println("1. Madero");
            System.out.println("2. Acueducto");
            System.out.println("Su elección: ");
            int option = leerNumeros.nextInt();

            switch(option){
                case 1:
                    sucursalRegistro = Sucursal.Madero;
                    break;
                case 2:
                    sucursalRegistro = Sucursal.Acueducto;
                    break;
                default:
                    System.out.println("Seleccione una opción válida.");
                    respuestaValida = false;
            }
        }while(!respuestaValida);

        String nombre = datosComun.get(0);
        String primerApellido = datosComun.get(1);
        String segundoApellido = datosComun.get(2);
        String fecha = datosComun.get(3);
        String genero = datosComun.get(4);
        String estado = datosComun.get(5);
        String ciudad = datosComun.get(6);
        String direccion = datosComun.get(7);

        Banco.usuarios.get(Rol.Cliente).add(new Cliente(nombre, primerApellido, segundoApellido, fecha, genero, ciudad, estado, direccion, LocalDate.now(), sucursalRegistro));
    }
}
