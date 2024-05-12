package usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import banco.Banco;
import banco.utils.Sucursal;
import usuario.utils.DatosComun;
import usuario.utils.Rol;

public class Empleado extends Persona{
    private static Scanner leerNumeros = new Scanner(System.in);
    private static Scanner leerCadenas = new Scanner(System.in);
    private LocalDate fechaInicio;
    private double salario;

    public Empleado(String nombre, String primerApellido, String segundoApellido, String fecha, String genero, String ciudad, String estado, String direccion, LocalDate fechaInicio, Sucursal sucursal, double salario, Rol rol, String nombreUsuario, String contra){
        super(nombre, primerApellido, segundoApellido, fecha, genero, ciudad, estado, direccion, nombreUsuario, contra, rol, sucursal);
        this.fechaInicio = fechaInicio;
        this.salario = salario;
        
    }

    public static void agregarEmpleado(Rol rol, Sucursal sucursal){
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(sucursal);

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



    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public static void modificarEmpleado(Rol rol, Sucursal sucursal) {
        Scanner leerNumeros = new Scanner(System.in);
    
        System.out.println("Ingrese el ID del Empleado a modificar: ");
        int idEmpleadoModif = leerNumeros.nextInt();
        boolean empleadoEncontrado = false;
        Empleado empleadoModificado = null;
    
        
        for (Persona usuario : Banco.usuarios.get(rol)) {
            
            if (usuario instanceof Empleado) {
                Empleado empleado = (Empleado) usuario;
                if (empleado.getId() == idEmpleadoModif) {
                    empleadoEncontrado = true;
                    empleadoModificado = empleado;
                    break; 
                }
            }
        }
    
        if (empleadoEncontrado) {
            System.out.println("Elija la opción que desea modificar: ");
            System.out.println("1.- Nombre ");
            System.out.println("2.- Apellido ");
            System.out.println("3.- Segundo apellido ");
            System.out.println("4.- Nombre de usuario");
            System.out.println("5.- Contraseña ");
            System.out.println("6.- Salario ");
            int opcion = leerNumeros.nextInt();
    
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre: ");
                    String nuevoNombre = leerCadenas.nextLine();
                    empleadoModificado.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("Ingrese el apellido: ");
                    String nuevoApellido = leerCadenas.nextLine();
                    empleadoModificado.setPrimerApellido(nuevoApellido);
                    break;
                case 3:
                    System.out.println("Ingrese el segundo apellido: ");
                    String nuevoApellido2 = leerCadenas.nextLine();
                    empleadoModificado.setSegundoApellido(nuevoApellido2);
                    break;
                case 4:
                    empleadoModificado.setNombreUsuario(DatosComun.obtenerNombreUsuario(sucursal));
                    break;
                case 5:
                    System.out.println("Ingrese la contraseña: ");
                    String nuevaContra = leerCadenas.nextLine();
                    empleadoModificado.setContra(nuevaContra);
                    break;
                case 6:
                    System.out.println("Ingrese el salario: ");
                    double nuevoSalario = leerNumeros.nextDouble();
                    empleadoModificado.setSalario(nuevoSalario);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
    
        } else {
            System.out.println("No se ha encontrado empleado con ese ID...");
        }
    }

    public static void mostrarInformacionTodos(Rol rol, Sucursal sucursal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int cont = 0;

        for(Persona persona : Banco.usuarios.get(rol)){
            if(persona.getId() != 0){
                Empleado empleado = (Empleado) persona;
                if(empleado.getSucursal() == sucursal){
                    Persona.mostrarInformacion(persona);
                    System.out.printf("Fecha de inicio: %s%n", empleado.fechaInicio.format(formatter));
                    System.out.printf("Salario: %s%n", empleado.salario);
                    cont++;
                }
            }
        }
        if(cont == 0){
            System.out.printf("No hay empleados del rol: %s%n", rol);
        } else{
            System.out.println("======================================================");
        }
    }

    private static boolean consultarEmpleadoPorID(int id, Rol rol, Sucursal sucursal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int cont = 0;
        boolean encontrado = false;

        for(Persona persona : Banco.usuarios.get(rol)){
            if(persona.getId() != 0){
                Empleado empleado = (Empleado) persona;
                if(empleado.getSucursal() == sucursal && empleado.getId() == id){
                    Persona.mostrarInformacion(persona);
                    System.out.printf("Fecha de inicio: %s%n", empleado.fechaInicio.format(formatter));
                    System.out.printf("Salario: %s%n", empleado.salario);
                    cont++;
                    encontrado = true;
                }
            }
        }
        if(cont == 0){
            System.out.println("No hay empleados con ese ID");
        } else{
            System.out.println("======================================================");
        }

        return encontrado;
    }

    public static void consultarEmpleados(Sucursal sucursal) {
    
        System.out.println("¿Cómo desea consultar los empleados?");
        System.out.println("1. Por ID");
        System.out.println("2. Por Rol");
    
        int opcion = leerNumeros.nextInt();
    
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el ID del empleado a consultar:");
                int id = leerNumeros.nextInt();
                for(int i= 0; i < 3; i++){
                    Rol rol = null;
                    switch (i) {
                        case 0 -> rol = Rol.Capturista;
                        case 1 -> rol = Rol.EjecutivoCuenta;
                        case 2 -> rol = Rol.GerenteSucursal;
                    }
                    if(consultarEmpleadoPorID(id, rol, sucursal)){
                        return;
                    }
                }
                break;

            case 2:
                System.out.println("Rol de empleado a consultar:");
                System.out.println("1.- Gerente ");
                System.out.println("2.- Ejecutivo ");
                System.out.println("3.- Capturista ");
                int opcionConsultar = leerNumeros.nextInt();
                switch (opcionConsultar) {
                    case 1:
                        mostrarInformacionTodos(Rol.GerenteSucursal, sucursal);
                        break;
                    case 2:
                        mostrarInformacionTodos(Rol.EjecutivoCuenta, sucursal);
                        break;
                    case 3:
                        mostrarInformacionTodos(Rol.Capturista, sucursal);
                        break;

                    default:
                        break;
                }
                
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public static void eliminarEmpleado(Sucursal sucursal){
        System.out.println("Ingrese el ID del empleado para eliminar: ");
        int idEmpleadoEliminar = leerCadenas.nextInt();
        Boolean respuestaCorrecta = false;
        Empleado empleadoEncontrado=null;

        for (Persona usuario : Banco.usuarios.get(Rol.Capturista)) {
            Empleado empleado = (Empleado) usuario;
            if (usuario instanceof Empleado && empleado.getId() == idEmpleadoEliminar && usuario.getSucursal() == sucursal) {
                respuestaCorrecta = true;
                empleadoEncontrado=empleado;
                
            }
        }

        for (Persona usuario : Banco.usuarios.get(Rol.EjecutivoCuenta)) {
            Empleado empleado = (Empleado) usuario;
            if (usuario instanceof Empleado && empleado.getId() == idEmpleadoEliminar && usuario.getSucursal() == sucursal) {
                respuestaCorrecta = true;
                empleadoEncontrado=empleado;
                
            }
        }

        for (Persona usuario : Banco.usuarios.get(Rol.GerenteSucursal)) {
            Empleado empleado = (Empleado) usuario;
            if (usuario instanceof Empleado && empleado.getId() == idEmpleadoEliminar && usuario.getSucursal() == sucursal) {
                respuestaCorrecta = true;
                empleadoEncontrado=empleado;
                
            }
        }


        if (respuestaCorrecta) {
            System.out.println("\nEmpleado eliminado.\n");
                Banco.usuarios.get(Rol.Cliente).remove(empleadoEncontrado);
        }else{
            System.out.println("No pudo eliminarse al empleado.");
        }
        
        
    }
    
}
    

