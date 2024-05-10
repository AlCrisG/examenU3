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
    

    
}
