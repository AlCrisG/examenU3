package banco.menus;

import java.util.Scanner;

import banco.Tarjeta;
import banco.utils.Sucursal;
import usuario.Cliente;

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
            System.out.println("+------------------------------------------+");
            System.out.println("| OPCIÓN |          DESCRIPCIÓN            |");
            System.out.println("+------------------------------------------+");
            System.out.println("|   1    | Ver mis tarjetas                |");
            System.out.println("|   2    | Solicitar tarjeta de crédito    |");
            System.out.println("|   3    | Cerrar sesión                   |");
            System.out.println("+------------------------------------------+");
            System.out.print("Elige una opción: ");
            opcion = leerNum.nextInt();

            switch(opcion){
                case 1:
                    Cliente.listarTarjetas();
                    break;

                case 2:
                    System.out.println("Mostrar las tarjetas del cliente");
                    break;

                case 3:
                    System.out.println("Cerrando sesión...");
                    return;

                default:
                    break;
            }
        }while(true);
    }
}
