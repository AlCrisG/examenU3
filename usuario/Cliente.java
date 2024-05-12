package usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import banco.Banco;
import banco.utils.Sucursal;
import usuario.utils.DatosComun;
import usuario.utils.Rol;

public class Cliente extends Persona{
    private LocalDate fechaRegistro;
    static Scanner leerCadenas = new Scanner(System.in);
    
    public Cliente(String nombre, String primerApellido, String segundoApellido, String fecha, String genero, String ciudad, String estado, String direccion, String nombreUsuario, String contra, LocalDate fechaRegistro, Sucursal sucursalRegistro){
        super(nombre, primerApellido, segundoApellido, fecha, genero, ciudad, estado, direccion, nombreUsuario, contra, Rol.Cliente, sucursalRegistro);
        this.fechaRegistro = fechaRegistro;
    }

    public static void agregarCliente(Sucursal sucursal){
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

        Banco.usuarios.get(Rol.Cliente).add(new Cliente(nombre, primerApellido, segundoApellido, fecha, genero, ciudad, estado, direccion, nombreUsuario, contra, LocalDate.now(), sucursalRegistro));
    }

    public static void mostrarInformacionTodosClientes(Sucursal sucursal){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int cont = 0;
        if(Banco.usuarios.get(Rol.Cliente).isEmpty()){
            System.out.println("No se han agregado usuarios de dicho rol.");
        }
        else{
            for(Persona persona : Banco.usuarios.get(Rol.Cliente)){
                Cliente cliente = (Cliente) persona;
                if(cliente.getSucursal() == sucursal){
                    Persona.mostrarInformacion(persona);
                    System.out.printf("Fecha de registro: %s%n", cliente.fechaRegistro.format(formatter));
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

    public static void modificarCliente(Sucursal sucursal) {
        @SuppressWarnings("resource")
        Scanner leerNumeros = new Scanner(System.in);
    
        System.out.println("Ingrese el ID del Cliente a modificar: ");
        int idClienteModif = leerNumeros.nextInt();
        boolean clienteEncontrado = false;
        Cliente clienteModificado = null;
    
        
        for (Persona usuario : Banco.usuarios.get(Rol.Cliente)) {
            
            if (usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                if (cliente.getId() == idClienteModif) {
                    clienteEncontrado = true;
                    clienteModificado = cliente;
                    break; 
                }
            }
        }
    
        if (clienteEncontrado) {
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
                    clienteModificado.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("Ingrese el apellido: ");
                    String nuevoApellido = leerCadenas.nextLine();
                    clienteModificado.setPrimerApellido(nuevoApellido);
                    break;
                case 3:
                    System.out.println("Ingrese el segundo apellido: ");
                    String nuevoApellido2 = leerCadenas.nextLine();
                    clienteModificado.setSegundoApellido(nuevoApellido2);
                    break;
                case 4:
                    clienteModificado.setNombreUsuario(DatosComun.obtenerNombreUsuario(sucursal));
                    break;
                case 5:
                    System.out.println("Ingrese la contraseña: ");
                    String nuevaContra = leerCadenas.nextLine();
                    clienteModificado.setContra(nuevaContra);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
    
        } else {
            System.out.println("No se ha encontrado cliente con ese ID...");
        }
    }

    public static void consultarClientePorID( Sucursal sucursal) {
        @SuppressWarnings("resource")
        Scanner leerNumeros = new Scanner(System.in);

        System.out.println("Ingrese el ID del cliente a consultar: ");
        int id = leerNumeros.nextInt();

        for (Persona usuario : Banco.usuarios.get(Rol.Cliente)) {
            if (usuario instanceof Cliente && usuario.getId() == id && usuario.getSucursal() == sucursal) {
                Cliente cliente = (Cliente) usuario;
                System.out.println("ID: " + cliente.getId());
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getPrimerApellido());
                System.out.println("Ciudad: " + cliente.getCiudad());
                System.out.println("Fecha de registro: "+ cliente.fechaRegistro);
                return; 
            }
        }
        System.out.println("No se encontró ningún cliente con ese ID en la sucursal.");
    }

    public static void eliminarCliente(Sucursal sucursal){
        System.out.println("Ingrese el ID del usuario para eliminar: ");
        int idClienteEliminar = leerCadenas.nextInt();
        Boolean respuestaCorrecta = false;
        Cliente clienteEncontrado=null;

        for (Persona usuario : Banco.usuarios.get(Rol.Cliente)) {
            Cliente cliente = (Cliente) usuario;
            if (usuario instanceof Cliente && cliente.getId() == idClienteEliminar && usuario.getSucursal() == sucursal) {
                respuestaCorrecta = true;
                clienteEncontrado=cliente;
                
            }
        }

        if (respuestaCorrecta) {
            System.out.println("\nCliente eliminado.\n");
                Banco.usuarios.get(Rol.Cliente).remove(clienteEncontrado);
        }else{
            System.out.println("No pudo eliminarse al cliente.");
        }
        
        
    }

}
