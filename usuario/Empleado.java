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
                    System.out.println("Ingrese el nombre de usuario: ");
                    String newNombreUsuario = leerCadenas.nextLine();
                    empleadoModificado.setNombreUsuario(newNombreUsuario);
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
    
    public static void mostrarInformacionTodosEmpleados(Rol rol, Sucursal sucursal) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    int cont = 0;
    for (Persona persona : Banco.usuarios.get(rol)) {
        if (persona instanceof Empleado && persona.getSucursal() == sucursal) {
            Empleado empleado = (Empleado) persona;
            System.out.println("======================================================");
            System.out.printf("ID: %s%n", empleado.getId());
            System.out.printf("Nombre completo: %s %s %s%n", empleado.getNombre(), empleado.getPrimerApellido(), empleado.getSegundoApellido());
            System.out.printf("Fecha de inicio: %s%n", empleado.getFechaInicio().format(formatter));
            System.out.printf("Salario: %s%n", empleado.getSalario());
            cont++;
        }
    }
    if (cont == 0) {
        System.out.println("No se han agregado empleados para mostrar.");
    }
}



    public static void consultarEmpleadoPorID(int id, Rol rol, Sucursal sucursal) {
        for (Persona usuario : Banco.usuarios.get(rol)) {
            if (usuario instanceof Empleado && usuario.getId() == id && usuario.getSucursal() == sucursal) {
                Empleado empleado = (Empleado) usuario;
                System.out.println("ID: " + empleado.getId());
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Apellido: " + empleado.getPrimerApellido());
                System.out.println("Salario: " + empleado.getSalario());
                System.out.println("Rol: "+ empleado.getRol());
                // Puedes mostrar más información si lo deseas
                return; // Terminamos la función luego de encontrar el empleado
            }
        }
        System.out.println("No se encontró ningún empleado con ese ID y rol en la sucursal.");
    }

    public static void consultarEmpleadosPorRol(Rol rol, Sucursal sucursal) {
        System.out.println("Empleados registrados con el rol " + rol + ":");
        for (Persona usuario : Banco.usuarios.get(rol)) {
            if (usuario instanceof Empleado && usuario.getSucursal() == sucursal) {
                Empleado empleado = (Empleado) usuario;
                System.out.println("ID: " + empleado.getId());
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Apellido: " + empleado.getPrimerApellido());
                System.out.println("Salario: " + empleado.getSalario());
                // Puedes mostrar más información si lo deseas
                System.out.println("-----------------------------");
            }
        }
    }

    public static void consultarEmpleados(Rol rol, Sucursal sucursal) {
    
        System.out.println("¿Cómo desea consultar los empleados?");
        System.out.println("1. Por ID");
        System.out.println("2. Por Rol");
    
        int opcion = leerNumeros.nextInt();
    
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el ID del empleado a consultar:");
                int id = leerNumeros.nextInt();
                consultarEmpleadoPorID(id, rol, sucursal);
                break;
            case 2:
                System.out.println("Rol de empleado a consultar:");
                System.out.println("1.- Gerente ");
                System.out.println("2.- Ejecutivo ");
                System.out.println("3.- Capturista ");
                int opcionConsultar = leerNumeros.nextInt();
                switch (opcionConsultar) {
                    case 1:
                        consultarEmpleadosPorRol(Rol.GerenteSucursal, sucursal);
                        break;
                    case 2:
                        consultarEmpleadosPorRol(Rol.EjecutivoCuenta, sucursal);
                        break;
                    case 3:
                        consultarEmpleadosPorRol(Rol.Capturista, sucursal);
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


    
}
    

