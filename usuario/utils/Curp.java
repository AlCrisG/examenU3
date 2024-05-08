package usuario.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Curp {
    public static String crearCurp(String nombre, String primerApellido, String segundoApellido, Genero genero, LocalDate fechaNacimiento, Estado estado){
        String primeraLetra = Character.toString(primerApellido.charAt(0));
        String segundaLetra = primeraVocalPalabra(primerApellido);
        String terceraLetra = Character.toString(segundoApellido.charAt(0));
        String cuartaLetra = Character.toString(nombre.charAt(0));
        String numeros = numerosCurp(fechaNacimiento);
        String letraGenero;
        if(genero == Genero.Hombre){
            letraGenero = "H";
        } else{
            letraGenero = "M";
        }
        String codigoEntidad = codigoEntidad(estado);
        String consonantePApellido = consonante(primerApellido);
        String consonanteSApellido = consonante(segundoApellido);
        String consonanteNombre = consonante(nombre);
        String ultimosDos = ultimosDos();
        return primeraLetra + segundaLetra + terceraLetra + cuartaLetra + numeros + letraGenero + codigoEntidad + consonantePApellido + consonanteSApellido + consonanteNombre + ultimosDos;
    }

    private static String primeraVocalPalabra(String cadena){
        String segundaLetra = "*";
        boolean encontrada = false;
        int i = 1;
        while(!encontrada){
            if(cadena.toLowerCase().charAt(i) == 'a'){
                segundaLetra = "A";
                encontrada = true;
            } else if(cadena.toLowerCase().charAt(i) == 'e'){
                segundaLetra = "E";
                encontrada = true;
            } else if(cadena.toLowerCase().charAt(i) == 'i'){
                segundaLetra = "I";
                encontrada = true;
            } else if(cadena.toLowerCase().charAt(i) == 'o'){
                segundaLetra = "O";
                encontrada = true;
            } else if(cadena.toLowerCase().charAt(i) == 'u'){
                segundaLetra = "U";
                encontrada = true;
            }
            i++;
        }

        return segundaLetra;
    }

    private static String numerosCurp(LocalDate fechaNacimiento){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        return fechaNacimiento.format(formatter);
    }

    private static String codigoEntidad(Estado estado){
        String codigoEntidad = "";
        switch(estado){
            case Aguascalientes -> codigoEntidad = "AS";
            case BCN -> codigoEntidad = "BC";
            case BCS -> codigoEntidad = "BS";
            case Campeche -> codigoEntidad = "CC";
            case Coahuila -> codigoEntidad = "CL";
            case Colima -> codigoEntidad = "CM";
            case Chiapas -> codigoEntidad = "CS";
            case Chihuahua -> codigoEntidad = "CH";
            case CDMX -> codigoEntidad = "DF";
            case Durango -> codigoEntidad = "DG";
            case Guanajuato -> codigoEntidad = "GT";
            case Guerrero -> codigoEntidad = "GR";
            case Hidalgo -> codigoEntidad = "HG";
            case Jalisco -> codigoEntidad = "JC";
            case EdoMex -> codigoEntidad = "MC";
            case Michoacan -> codigoEntidad = "MN";
            case Morelos -> codigoEntidad = "MS";
            case Nayarit -> codigoEntidad = "NT";
            case NuevoLeon -> codigoEntidad = "NL";
            case Oaxaca -> codigoEntidad = "OC";
            case Puebla -> codigoEntidad = "PL";
            case Queretaro -> codigoEntidad = "QT";
            case QuintanaRoo -> codigoEntidad = "QR";
            case SLP -> codigoEntidad = "SP";
            case Sinaloa -> codigoEntidad = "SL";
            case Sonora -> codigoEntidad = "SR";
            case Tabasco -> codigoEntidad = "TC";
            case Tamaulipas -> codigoEntidad = "TS";
            case Tlaxcala -> codigoEntidad = "TL";
            case Veracruz -> codigoEntidad = "VZ";
            case Yucatan -> codigoEntidad = "YN";
            case Zacatecas -> codigoEntidad = "ZS";
            default -> codigoEntidad = "NE";
        }

        return codigoEntidad;
    }

    private static String consonante(String cadena){
        cadena = cadena.toLowerCase();
        String consonante = "*";
        boolean encontrada = false;
        int i = 1;
        while(!encontrada){
            if(cadena.charAt(i) != 'a' && cadena.charAt(i) != 'e' && cadena.charAt(i) != 'i' && cadena.charAt(i) != 'o' && cadena.charAt(i) != 'u'){
                consonante = Character.toString(cadena.charAt(i)).toUpperCase();
                encontrada = true;
            }
            i++;
        }

        return consonante;
    }

    private static String ultimosDos(){
        Random ran = new Random();
        String numeroAleatorio = String.valueOf(ran.nextInt(9)+1);

        return "A" + numeroAleatorio;
    }
}
