package banco.menus;

import java.util.Scanner;

import banco.utils.Sucursal;
import usuario.Empleado;
import usuario.utils.Rol;

public class MenuCapturista {
    
    static Scanner leerNum = new Scanner(System.in);
    public static void mostrarMenuCapturista(Sucursal sucursal){
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
            System.out.println("|   1    | Registrar ejecutivos  |");
            System.out.println("|   2    | Modificar ejecutivos  |");
            System.out.println("|   3    | Cerrar sesión         |");
            System.out.println("+--------------------------------+");
            System.out.print("Elige una opción: ");
            opcion = leerNum.nextInt();

            switch(opcion){
                case 1:
                    Empleado.agregarEmpleado(Rol.EjecutivoCuenta, sucursal);
                    break;

                case 2:
                    Empleado.modificarEmpleado(Rol.EjecutivoCuenta, sucursal);
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
