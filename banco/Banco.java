package banco;

import java.util.HashMap;
import java.util.ArrayList;

import usuario.utils.Rol;
import usuario.Persona;

public class Banco {
    public static HashMap<Rol, ArrayList<Persona>> usuarios = new HashMap<>();

    public Banco(){
        usuarios.put(Rol.Capturista, new ArrayList<>());
        usuarios.put(Rol.Cliente, new ArrayList<>());
        usuarios.put(Rol.EjecutivoCuenta, new ArrayList<>());
        usuarios.put(Rol.GerenteSucursal, new ArrayList<>());
        usuarios.put(Rol.Inversionista, new ArrayList<>());
    }
}
