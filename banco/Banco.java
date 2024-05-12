package banco;

import java.util.HashMap;

import banco.utils.Sucursal;

import java.util.ArrayList;

import usuario.utils.Rol;
import usuario.Persona;

public class Banco {
    public static HashMap<Rol, ArrayList<Persona>> usuarios = new HashMap<>();
    public static ArrayList<Inversion> inversiones = new ArrayList<>();
    private static String contraInverMadero = "123", contraInverAcueducto = "123";

    public Banco(){
        usuarios.put(Rol.Capturista, new ArrayList<>());
        usuarios.put(Rol.Cliente, new ArrayList<>());
        usuarios.put(Rol.EjecutivoCuenta, new ArrayList<>());
        usuarios.put(Rol.GerenteSucursal, new ArrayList<>());
        usuarios.put(Rol.Inversionista, new ArrayList<>());
        usuarios.get(Rol.GerenteSucursal).add(new Persona("Gerente", "Madero", "KKKK", "01/01/2002", "H", "Morelia","16", "", "1", "1",Rol.GerenteSucursal, Sucursal.Madero));
        usuarios.get(Rol.GerenteSucursal).add(new Persona("Gerente", "Acueducto", "KKKK", "01/01/2002", "H", "Morelia","16", "", "2", "2",Rol.GerenteSucursal, Sucursal.Acueducto));
    }



    public Persona verificarInicioSesion(String usuario,String contra, Sucursal sucursal){
        for(int i = 0; i < 5; i++){
            Rol rol = null;
            switch(i){
                case 0 -> rol = Rol.Capturista;
                case 1 -> rol = Rol.Cliente;
                case 2 -> rol = Rol.EjecutivoCuenta;
                case 3 -> rol = Rol.GerenteSucursal;
                case 4 -> rol = Rol.Inversionista;
            }

            for(Persona usuarioActual : usuarios.get(rol)){
                if(usuarioActual.getSucursal() == sucursal){
                    if(usuarioActual.getNombreUsuario().equals(usuario)){
                        if(usuarioActual.getContra().equals(contra)){
                            return usuarioActual;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean contraInversionistas(String contra, Sucursal sucursal){
        if(contra.equals(contraInverMadero) && sucursal == Sucursal.Madero){
            return true;
        }
        else if(contra.equals(contraInverAcueducto) && sucursal == Sucursal.Acueducto){
            return true;
        }
        else{
            System.out.println("Contraseña incorrecta.");
            return false;
        }
    }
}
