package banco;
import java.util.Scanner;

import banco.menus.MenuGerente;
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
        boolean datosCorrectos = false;

        do {
            System.out.println("BIENVENIDO AL SISTEMA DE LA BIBLIOTECA");
            System.out.println("Inicia sesión para continuar");

            System.out.println("Ingresa tu usuario: ");
            String usuario = leerCad.nextLine();

            System.out.println("Ingresa tu contraseña: ");
            String contraMadero = leerCad.nextLine();

            Persona usuarioActual = banco.verificarInicioSesion(usuario, contraMadero, sucursal);

            if (usuarioActual != null) {
                UsuarioEnSesion.getInstancia().setUsuario(usuarioActual);
                datosCorrectos = true;
                seleccionarMenu();
            } else {
                System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo.");
                ejecutarSistema();
            }

        } while (!datosCorrectos);
    }

    private void seleccionarMenu() {
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()) {
            case Cliente -> mostrarMenuCliente(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal());
            case EjecutivoCuenta -> mostrarMenuEjecutivoCuenta(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal());
            case GerenteSucursal -> mostrarMenuGerente(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal());
            case Capturista -> mostrarMenuCapturista(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal());
            case Inversionista -> mostrarMenuInversionista(UsuarioEnSesion.getInstancia().getUsuarioActual().getSucursal());
        }
    }

    public void mostrarMenuGerente(Sucursal sucursal){
        int opcion;
        do{
            opcion = MenuGerente.mostrarMenuGerenteSucursal(sucursal);
        } while(opcion != 5);
    }

    public void mostrarMenuEjecutivoCuenta(Sucursal sucursal){

    }
    
    public void mostrarMenuCapturista(Sucursal sucursal){

    }

    public void mostrarMenuInversionista(Sucursal sucursal){

    }

    public void mostrarMenuCliente(Sucursal sucursal){

    }
}
