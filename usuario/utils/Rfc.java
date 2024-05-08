package usuario.utils;

import java.util.Random;

public class Rfc {
    public static String crearRfc(String curp){
        curp = curp.substring(0,10) + homoclave();
        return curp;
    }

    private static String homoclave(){
        Random ran = new Random();
        String homoclave = "";

        for(int i = 0; i<3; i++){
            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
            int index = ran.nextInt(34);

            homoclave = homoclave + Character.toString(letras.charAt(index));
        }

        return homoclave;
    }
}
