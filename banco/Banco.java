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
        usuarios.get(Rol.GerenteSucursal).add(new Persona("Gerente", "Madero", "kkkk", "01/01/2002", "H","16", "1", "1",Rol.GerenteSucursal));
    }



    public Persona verificarInicioSesion(String usuario,String contra){
        for(Persona usuarioActual : usuarios.get(Rol.Cliente)){
            if(usuarioActual.getNombreUsuario().equals(usuario)){
                if(usuarioActual.getContra().equals(contra)){
                    return usuarioActual;
                }
            }
        }
        for(Persona usuarioActual : usuarios.get(Rol.EjecutivoCuenta)){
            if(usuarioActual.getNombreUsuario().equals(usuario)){
                if(usuarioActual.getContra().equals(contra)){
                    return usuarioActual;
                }
            }
        }
        for(Persona usuarioActual : usuarios.get(Rol.GerenteSucursal)){
            if(usuarioActual.getNombreUsuario().equals(usuario)){
                if(usuarioActual.getContra().equals(contra)){
                    return usuarioActual;
                }
            }
        }
        for(Persona usuarioActual : usuarios.get(Rol.Inversionista)){
            if(usuarioActual.getNombreUsuario().equals(usuario)){
                if(usuarioActual.getContra().equals(contra)){
                    return usuarioActual;
                }
            }
        }
        for(Persona usuarioActual : usuarios.get(Rol.Capturista)){
            if(usuarioActual.getNombreUsuario().equals(usuario)){
                if(usuarioActual.getContra().equals(contra)){
                    return usuarioActual;
                }
            }
        }
        return null;
    }
}
