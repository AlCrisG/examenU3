package banco.menus;

import java.util.Scanner;

import banco.Tarjeta;
import banco.utils.EstatusSolicitud;
import banco.utils.Sucursal;
import usuario.Cliente;


public class MenuEjecutivo {

    static Scanner leerNum = new Scanner(System.in);
    public static void mostrarMenuEjecutivo(Sucursal sucursal){
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
            System.out.println("|   1    | Registrar clientes    |");
            System.out.println("|   2    | Modificar clientes    |");
            System.out.println("|   3    | Consultar clientes    |");
            System.out.println("|   4    | Eliminar  clientes    |");
            System.out.println("|   5    | Ver solicitudes       |");
            System.out.println("|   6    | Autorizar tarjetas    |");
            System.out.println("|   7    | Cerrar sesión         |");
            System.out.println("+--------------------------------+");
            System.out.print("Elige una opción: ");
            opcion = leerNum.nextInt();

            switch(opcion){
                case 1:
                    Cliente.agregarCliente(sucursal);
                    break;

                case 2:
                    Cliente.modificarCliente(sucursal);
                    break;

                case 3:
                    Cliente.mostrarInformacionTodosClientes(sucursal);
                    break;

                case 4:
                    Cliente.eliminarCliente(sucursal);
                    break;
                case 5:
                    System.out.println("Seleccione una opción:");
                    System.out.println("1. Aprobadas");
                    System.out.println("2. En Proceso");
                    System.out.println("3. Rechazada");
                    System.out.println("Seleccione una opción: ");
                    int opcionSolicitud = leerNum.nextInt();

                    switch(opcionSolicitud){
                        case 1 -> Tarjeta.verSolicitudesTodos(EstatusSolicitud.Aprobada, sucursal);
                        case 2 -> Tarjeta.verSolicitudesTodos(EstatusSolicitud.EnProceso, sucursal);
                        case 3 -> Tarjeta.verSolicitudesTodos(EstatusSolicitud.Rechazada, sucursal);
                        default -> System.out.println("Opción no válida.");
                    }
                    break;
                case 6:
                    Tarjeta.cambiarEstatusSolicitud(sucursal);
                    break;
                case 7:
                    System.out.println("Cerrando sesión...");
                    return;

                default:
                    break;
            }
        }while(true);
    }
}
