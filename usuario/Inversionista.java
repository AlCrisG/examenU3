package usuario;

import java.time.LocalDateTime;
import java.util.Scanner;

import banco.Banco;
import banco.Inversion;
import banco.utils.Sucursal;
import usuario.utils.DatosComun;
import usuario.utils.Rol;

public class Inversionista extends Persona{
    private static Scanner leerCadenas = new Scanner(System.in);
    private static Scanner leerNumeros = new Scanner(System.in);
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

        String nombreUsuario = DatosComun.obtenerNombreUsuario(sucursal);

        System.out.println("Ingrese su contraseña: ");
        String contra = leerCadenas.nextLine();

        Banco.usuarios.get(Rol.Inversionista).add(new Inversionista(nombre, primerApellido, segundoApellido, nombreUsuario, contra, sucursal));
    }

    public long getDineroInvertido(){
        return dineroInvertido;
    }

    public String getNombreCompleto(){
        return super.getNombre() + " " + super.getPrimerApellido() + " " + super.getSegundoApellido();
    }

    public static void modificarInversionista(Sucursal sucursal) {
        @SuppressWarnings("resource")
        Scanner leerNumeros = new Scanner(System.in);
    
        System.out.println("Ingrese el ID del Inversionista a modificar: ");
        int idInverModif = leerNumeros.nextInt();
        boolean inverEncontrado = false;
        Inversionista inverModificado = null;
    
        
        for (Persona usuario : Banco.usuarios.get(Rol.Inversionista)) {
            
            if (usuario instanceof Inversionista) {
                Inversionista inversionista = (Inversionista) usuario;
                if (inversionista.getId() == idInverModif) {
                    inverEncontrado = true;
                    inverModificado = inversionista;
                    break; 
                }
            }
        }
    
        if (inverEncontrado) {
            System.out.println("Elija la opción que desea modificar: ");
            System.out.println("1.- Nombre ");
            System.out.println("2.- Apellido ");
            System.out.println("3.- Segundo apellido ");
            System.out.println("4.- Nombre de usuario");
            System.out.println("5.- Contraseña ");
            int opcion = leerNumeros.nextInt();
    
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre: ");
                    String nuevoNombre = leerCadenas.nextLine();
                    inverModificado.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("Ingrese el apellido: ");
                    String nuevoApellido = leerCadenas.nextLine();
                    inverModificado.setPrimerApellido(nuevoApellido);
                    break;
                case 3:
                    System.out.println("Ingrese el segundo apellido: ");
                    String nuevoApellido2 = leerCadenas.nextLine();
                    inverModificado.setSegundoApellido(nuevoApellido2);
                    break;
                case 4:
                    inverModificado.setNombreUsuario(DatosComun.obtenerNombreUsuario(sucursal));
                    break;
                case 5:
                    System.out.println("Ingrese la contraseña: ");
                    String nuevaContra = leerCadenas.nextLine();
                    inverModificado.setContra(nuevaContra);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
    
        } else {
            System.out.println("No se ha encontrado cliente con ese ID...");
        }
    }

    public static void mostrarInformacionTodosInversionistas(Sucursal sucursal){
        int cont = 0;
        if(Banco.usuarios.get(Rol.Inversionista).isEmpty()){
            System.out.println("No se han agregado usuarios de dicho rol.");
        }
        else{
            for(Persona persona : Banco.usuarios.get(Rol.Inversionista)){
                Inversionista inversionista = (Inversionista) persona;
                if(inversionista.getSucursal() == sucursal){
                    System.out.println("======================================================");
                    System.out.printf("ID: %s%n", inversionista.getId());
                    System.out.printf("Nombre completo: %s %s %s%n", inversionista.getNombre(), inversionista.getPrimerApellido(), inversionista.getSegundoApellido());
                    System.out.printf("Dinero invertido: %s%n", inversionista.dineroInvertido);
                    cont++;
                }
            }
            if(cont == 0){
                System.out.println("No se han agregado usuarios de dicho rol.");
            } else{
                System.out.println("======================================================");
            }
        }
    }

    public static void consultarInversionistaPorID( Sucursal sucursal) {
        @SuppressWarnings("resource")
        Scanner leerNumeros = new Scanner(System.in);

        System.out.println("Ingrese el ID del inversionista a consultar: ");
        int id = leerNumeros.nextInt();

        for (Persona usuario : Banco.usuarios.get(Rol.Inversionista)) {
            if (usuario instanceof Inversionista && usuario.getId() == id && usuario.getSucursal() == sucursal) {
                Inversionista inversionista = (Inversionista) usuario;
                System.out.println("======================================================");
                System.out.printf("ID: %s%n", inversionista.getId());
                System.out.printf("Nombre completo: %s %s %s%n", inversionista.getNombre(), inversionista.getPrimerApellido(), inversionista.getSegundoApellido());
                System.out.printf("Dinero invertido: %s%n", inversionista.dineroInvertido);
                System.out.println("======================================================");
                return; 
            }
        }
        System.out.println("No se encontró ningún Inversionista con ese ID en la sucursal.");
    }


    public static void eliminarInversionista(Sucursal sucursal){
        System.out.println("Ingrese el ID del inversionista para eliminar: ");
        int idInverEliminar = leerCadenas.nextInt();
        Boolean respuestaCorrecta = false;
        Inversionista inverEncontrado=null;

        for (Persona usuario : Banco.usuarios.get(Rol.Cliente)) {
            Inversionista inversionista = (Inversionista) usuario;
            if (usuario instanceof Inversionista && inversionista.getId() == idInverEliminar && usuario.getSucursal() == sucursal) {
                respuestaCorrecta = true;
                inverEncontrado=inversionista;
                
            }
        }

        if (respuestaCorrecta) {
            System.out.println("\nInversionista eliminado.\n");
                Banco.usuarios.get(Rol.Cliente).remove(inverEncontrado);
        }else{
            System.out.println("No pudo eliminarse al inversionista.");
        }
    }

    public static void hacerInversion(Inversionista inversionista, Sucursal sucursal){
        System.out.println("Ingrese el monto de la inversión: ");
        long montoInversion = leerNumeros.nextLong();

        inversionista.dineroInvertido += montoInversion;
        Banco.inversiones.add(new Inversion(montoInversion, LocalDateTime.now(), inversionista, sucursal));
    }
}
