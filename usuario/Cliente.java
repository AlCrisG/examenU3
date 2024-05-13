package usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import banco.Banco;
import banco.Tarjeta;
import banco.utils.EstatusSolicitud;
import banco.utils.Sucursal;
import banco.utils.TipoTarjeta;
import banco.utils.TipoTarjetaCredito;
import usuario.utils.DatosComun;
import usuario.utils.Rol;
import usuario.utils.UsuarioEnSesion;

public class Cliente extends Persona{    
    private static ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    private LocalDate fechaRegistro;
    private boolean tieneSolicitudes = false;
    static Scanner leerCadenas = new Scanner(System.in);
    
    public Cliente(String nombre, String primerApellido, String segundoApellido, String fecha, String genero, String ciudad, String estado, String direccion, String nombreUsuario, String contra, LocalDate fechaRegistro, Sucursal sucursalRegistro){
        super(nombre, primerApellido, segundoApellido, fecha, genero, ciudad, estado, direccion, nombreUsuario, contra, Rol.Cliente, sucursalRegistro);
        this.fechaRegistro = fechaRegistro;
        generarTarjetaDebito(sucursalRegistro);
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

    public static void generarTarjetaDebito(Sucursal sucursal) {
        Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
        tarjetas.add(new Tarjeta(cliente, sucursal, TipoTarjeta.Debito));
        Banco.solicitudes.get(EstatusSolicitud.EnProceso).
    }

    public static void generarTarjetaCredito(Cliente cliente, Sucursal sucursal, TipoTarjetaCredito tipoCredito, double creditoMaximo) {
        tarjetas.add(new Tarjeta(cliente, sucursal, TipoTarjeta.Credito, tipoCredito, creditoMaximo));        
    }
    
    public ArrayList<Tarjeta> obtenerTarjetasCredito(){
        ArrayList<Tarjeta> tarjetasCredito = tarjetas;
        tarjetasCredito.remove(0);
        return tarjetasCredito;
    }

    public static void listarTarjetas() {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        int i, opcion;

        do {
            System.out.println("|   MENU TARJETAS   |");
            System.out.println("+------------------------------------------+");
            System.out.println("| OPCIÓN |              TARJETA            |");
            System.out.println("+------------------------------------------+");
            System.out.println("|   1    | Tarjeta - Débito                |");
            for(i=1; i<tarjetas.size(); i++) {
                System.out.println("|   " + (i+1) + "   | Tarjeta - Crédito - " + tarjetas.get(i).getTipoTarjetaCredito() + "  |");
            }
            System.out.println("|   0    | Volver                          |");
            System.out.println("+------------------------------------------+");
            System.out.print("Elige una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        } while (opcion!=0);      
    }

    public static void menuTarjeta(int i) {
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);
        int opcion;

        if(tarjetas.get(i).getTipoTarjeta() == TipoTarjeta.Credito) {
            do {
                System.out.println("|  MENU TARJETA CRÉDITO " + tarjetas.get(i).getTipoTarjetaCredito() +" |");    
                System.out.println("+------------------------------------------+");
                System.out.println("| OPCIÓN |           DESCRIPCIÓN           |");
                System.out.println("+------------------------------------------+");
                System.out.println("|   1    | Ver datos de la tarjeta         |");                        
                System.out.println("|   2    | Realizar pago                   |");
                System.out.println("|   3    | Pagar tarjeta                   |");
                System.out.println("|   4    | Volver                          |");
                System.out.println("+------------------------------------------+");
                System.out.print("Elige una opción: ");
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        mostrarInformacionTarjetaCredito(i);                    
                        break;        
                    case 2:
                        tarjetas.get(i).realizarPagoCredito();                    
                        break;        
                    case 3:
                        Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
                        tarjetas.get(i).pagarTarjetaCredito(cliente);                                                            
                        break;        
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            } while (opcion!=4);
            
        } else {
            do {
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
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        mostrarInformacionTarjetaCredito(i);                    
                        break;        
                    case 2:
                        tarjetas.get(i).depositarDinero();;                    
                        break;        
                    case 3:
                        tarjetas.get(i).retirarDinero();                                                            
                        break;        
                    case 4:
                        tarjetas.get(i).realizarPagoDebito();                                                            
                        break;        
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }

            } while(opcion!=5);
        }        
    }

    public static void mostrarInformacionTarjetaDebito(int i) {
        DateTimeFormatter vencimiento = DateTimeFormatter.ofPattern("MM/yyyy");
        DateTimeFormatter movimiento = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("======================================================");
        System.out.printf("Número de tarjeta: %s%n", tarjetas.get(i).getNumeroTarjeta());
        System.out.printf("Clabe interbancaria: %s%n", tarjetas.get(i).getClabe());
        System.out.printf("CVV: %s%n", tarjetas.get(i).getCvv());
        System.out.printf("Fecha de vencimiento: %s%n", tarjetas.get(i).getFechaVencimiento().format(vencimiento));        
        System.out.printf("Saldo: %d%n", tarjetas.get(i).getSaldo());
        System.out.printf("Fecha del último movimiento: %s%n", tarjetas.get(i).getFechaUltimoMovimiento().format(movimiento));
        System.out.printf("Fecha de creación: %s%n", tarjetas.get(i).getFechaCreacion().format(movimiento));
    }

    public static void mostrarInformacionTarjetaCredito(int i) {
        DateTimeFormatter vencimiento = DateTimeFormatter.ofPattern("MM/yyyy");
        DateTimeFormatter movimiento = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("======================================================");
        System.out.printf("Tipo de crédito: %s%n", tarjetas.get(i).getTipoTarjetaCredito());
        System.out.printf("Número de tarjeta: %s%n", tarjetas.get(i).getNumeroTarjeta());
        System.out.printf("Clabe interbancaria: %s%n", tarjetas.get(i).getClabe());
        System.out.printf("CVV: %s%n", tarjetas.get(i).getCvv());
        System.out.printf("Fecha de vencimiento: %s%n", tarjetas.get(i).getFechaVencimiento().format(vencimiento));        
        System.out.printf("Crédito: %d%n", tarjetas.get(i).getCreditoMaximo());
        System.out.printf("Fecha del último movimiento: %s%n", tarjetas.get(i).getFechaUltimoMovimiento().format(movimiento));
        System.out.printf("Fecha de creación: %s%n", tarjetas.get(i).getFechaCreacion().format(movimiento));
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

    public double getSaldoTarjetaDebito(){
        return tarjetas.get(0).getSaldo();
    }

    public void setSaldoTarjetaDebito(double saldoTarjetaDebito){
        tarjetas.get(0).setSaldo(saldoTarjetaDebito);
    }

    public boolean tieneSolicitudes(){
        return tieneSolicitudes;
    }

    public void setTieneSolicitudes(boolean tieneSolicitudes){
        this.tieneSolicitudes = tieneSolicitudes;
    }
}
