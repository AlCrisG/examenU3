package banco;
import java.util.Scanner;

import banco.menus.MenuCapturista;
import banco.menus.MenuCliente;
import banco.menus.MenuEjecutivo;
import banco.menus.MenuGerenteSucursal;
import banco.menus.MenuInversionista;
import banco.utils.Sucursal;
import usuario.Persona;
import usuario.utils.UsuarioEnSesion;

public class BankSystem {
    public static Scanner leerNum = new Scanner(System.in);
    public static Scanner leerCad = new Scanner(System.in);
    Banco banco = new Banco();

    public void ejecutarSistema(){    
            int opcion=0;
            do {
                System.out.println("\n*** BIENVENIDO ***");
                System.out.println("¿A QUE SUCURSAL DESEA INGRESAR?:");
                System.out.println("1.- Madero");
                System.out.println("2.- Acueducto");
                System.out.println("3.- Salir");
                opcion = leerNum.nextInt();
        
                switch (opcion) {
                    case 1:
                        iniciarSesionSistema(Sucursal.Madero);
                        break;
                    case 2:
                        iniciarSesionSistema(Sucursal.Acueducto);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }
            } while (true);
        
    }


    private void iniciarSesionSistema(Sucursal sucursal){
        System.out.println("BIENVENIDO AL SISTEMA DE LA BIBLIOTECA");
        System.out.println("Inicia sesión para continuar");

        System.out.println("Ingresa tu usuario: ");
        String usuario = leerCad.nextLine();

        System.out.println("Ingresa tu contraseña: ");
        String contra = leerCad.nextLine();

        Persona usuarioActual = banco.verificarInicioSesion(usuario, contra, sucursal);

        if (usuarioActual != null) {
            UsuarioEnSesion.getInstancia().setUsuario(usuarioActual);
            seleccionarMenu();
        } else {
            System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo.");
            ejecutarSistema();
        }
    }

    private void seleccionarMenu() {
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()) {
            case Cliente:
                mostrarMenuCliente(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal());
                break;

            case EjecutivoCuenta:
                mostrarMenuEjecutivoCuenta(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal());
                break;

            case GerenteSucursal:
                mostrarMenuGerente(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal());
                break;

            case Capturista:
                mostrarMenuCapturista(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal());
                break;

            case Inversionista:
                mostrarMenuInversionista(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal());
                break;
        }
    }

    public void mostrarMenuGerente(Sucursal sucursal){
        MenuGerenteSucursal.mostrarMenuGerenteSucursal(sucursal);
    }

    public void mostrarMenuEjecutivoCuenta(Sucursal sucursal){
        MenuEjecutivo.mostrarMenuEjecutivo(sucursal);
    }
    
    public void mostrarMenuCapturista(Sucursal sucursal){
        MenuCapturista.mostrarMenuCapturista(sucursal);
    }

    public void mostrarMenuInversionista(Sucursal sucursal){
        MenuInversionista.mostrarMenuInversionista(sucursal);
    }

    public void mostrarMenuCliente(Sucursal sucursal){
        MenuCliente.mostrarMenuCliente(sucursal);
    }
}
