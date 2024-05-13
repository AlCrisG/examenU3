package banco.menus;

import java.sql.ClientInfoStatus;
import java.util.Scanner;

import banco.Tarjeta;
import usuario.Cliente;
import banco.utils.Sucursal;
import usuario.utils.UsuarioEnSesion;

public class MenuCliente {
    
    static Scanner leerNum = new Scanner(System.in);
    public static void mostrarMenuCliente(Sucursal sucursal){
        int opcion = 0;

        do{
            System.out.println("+------------------------+");
            if(sucursal == Sucursal.Madero){
                System.out.println("|    MENU BANCO MADERO   |");
            } else{
                System.out.println("|  MENU BANCO ACUEDUCTO  |");
            }
            System.out.println("+--------------------------------+");
            System.out.println("| OPCION |      DESCRIPCION      |");
            System.out.println("+--------------------------------+");
            System.out.println("|   1    | Solicitar tarjeta     |");
            System.out.println("|   2    | Ver mis tarjetas      |");
            System.out.println("|   3    | Realizar operación    |");
            System.out.println("|   4    | Ver mis solicitudes   |");
            System.out.println("|   5    | Cerrar sesión         |");
            System.out.println("+--------------------------------+");
            System.out.print("Elige una opción: ");
            opcion = leerNum.nextInt();

            Cliente cliente = (Cliente) UsuarioEnSesion.getInstancia().getUsuarioActual();
            switch(opcion){
                case 1:
                    Tarjeta.solicitarTarjeta(cliente);
                    break;

                case 2:
                    Tarjeta.listarTarjetasUsuario(cliente);
                    break;

                case 3:
                    Tarjeta.seleccionarTarjeta(cliente);
                    break;

                case 4:
                    Tarjeta.verSolicitudesCliente(cliente);
                    break;

                case 5:
                    System.out.println("Cerrando sesión...");
                    return;

                default:
                    break;
            }
        }while(true);
    }
}
