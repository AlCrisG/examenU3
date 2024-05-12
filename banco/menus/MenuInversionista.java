package banco.menus;
import java.util.Scanner;
import banco.utils.Sucursal;
import usuario.Inversionista;
import usuario.utils.UsuarioEnSesion;

public class MenuInversionista {
    
    static Scanner leerNum = new Scanner(System.in);
    public static void mostrarMenuInversionista(Sucursal sucursal){
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
            System.out.println("|   1    | Hacer una Inversion   |");
            System.out.println("|   2    | Cerrar sesión         |");
            System.out.println("+--------------------------------+");
            System.out.print("Elige una opción: ");
            opcion = leerNum.nextInt();

            switch(opcion){
                case 1:
                    Inversionista inversionista = (Inversionista) UsuarioEnSesion.getInstancia().getUsuarioActual();
                    Inversionista.hacerInversion(inversionista, sucursal);
                    break;

                case 2:
                    System.out.println("Cerrando sesión...");
                    return;

                default:
                    break;
            }
        }while(true);
    }
}
