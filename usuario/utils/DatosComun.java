package usuario.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatosComun {
    private static Scanner leerCadenas = new Scanner(System.in);
    private static Scanner leerNumeros = new Scanner(System.in);

    public static ArrayList obtenerDatosComun(){
        ArrayList<String> datosComun = new ArrayList<>(); 

        System.out.println("Ingrese nombre: ");
        String nombre = leerCadenas.nextLine();

        System.out.println("Ingrese apellido paterno: ");
        String primerApellido = leerCadenas.nextLine();

        System.out.println("Ingrese apellido materno: ");
        String segundoApellido = leerCadenas.nextLine();

        System.out.println("Ingrese fecha de nacimiento: ");
        String fecha = leerCadenas.nextLine();

        boolean respuestaValida;
        String genero;
        do{
            respuestaValida = true;
            System.out.println("Género [H/M]: ");
            genero = leerCadenas.nextLine().toUpperCase();

            if(!(genero.equals("H") || genero.equals("M"))){
                respuestaValida = false;
                System.out.println("Ingrese una opción válida.");
            }
        }while(!respuestaValida);

        String estado = obtenerEstado();

        System.out.println("Ciudad: ");
        String ciudad = leerCadenas.nextLine();

        System.out.println("Dirección (Calle y número): ");
        String direccion = leerCadenas.nextLine();

        datosComun.addAll(Arrays.asList(nombre, primerApellido, segundoApellido, fecha, genero, estado, ciudad, direccion));
        return datosComun;
    }

    private static String obtenerEstado(){
        int option;

        do{
            System.out.println("======================================================");
            System.out.println("||  1 | Aguascalientes      ||  2 | Baja California ||");
            System.out.println("||  3 | Baja California Sur ||  4 | Campeche        ||");
            System.out.println("||  5 | Coahuila            ||  6 | Colima          ||");
            System.out.println("||  7 | Chiapas             ||  8 | Chihuahua       ||");
            System.out.println("||  9 | Ciudad de México    || 10 | Durango         ||");
            System.out.println("|| 11 | Guanajuato          || 12 | Guerrero        ||");
            System.out.println("|| 13 | Hidalgo             || 14 | Jalisco         ||");
            System.out.println("|| 15 | Edo. de México      || 16 | Michoacán       ||");
            System.out.println("|| 17 | Morelos             || 18 | Nayarit         ||");
            System.out.println("|| 19 | Nuevo León          || 20 | Oaxaca          ||");
            System.out.println("|| 21 | Puebla              || 22 | Querétaro       ||"); 
            System.out.println("|| 23 | Quintana Roo        || 24 | San Luis Potosí ||"); 
            System.out.println("|| 25 | Sinaloa             || 26 | Sonora          ||"); 
            System.out.println("|| 27 | Tabasco             || 28 | Tamaulipas      ||"); 
            System.out.println("|| 29 | Tlaxcala            || 30 | Veracruz        ||"); 
            System.out.println("|| 31 | Yucatán             || 32 | Zacatecas       ||"); 
            System.out.println("||                                                  ||"); 
            System.out.println("|| 33 | Nacido en el extranjero                     ||");
            System.out.println("======================================================");
            System.out.println("Seleccione un estado: ");
            
            option = leerNumeros.nextInt();

            if(option < 1 || option > 33){
                System.out.println("Seleccione una opción válida.");
            }
        }while(option < 1 || option > 33);

        return Integer.toString(option);
    }
}
