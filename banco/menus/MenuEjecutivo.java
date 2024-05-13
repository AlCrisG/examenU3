package banco.menus;

import java.util.Scanner;

import banco.Banco;
import banco.utils.Sucursal;
import usuario.Cliente;
import usuario.utils.Rol;


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
            System.out.println("|   5    | Autorizar tarjetas    |");
            System.out.println("|   6    | Cerrar sesión         |");
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
                    System.out.println("Autorizar tarjetas");
                    break;
                case 6:
                    System.out.println("Cerrando sesión...");
                    return;

                default:
                    break;
            }
        }while(true);
    }

    private static void listarSolicitudes(){
        for(Cliente cliente : Banco.usuarios.get(Rol.Cliente)){
            ArrayList
        }
    }
}
