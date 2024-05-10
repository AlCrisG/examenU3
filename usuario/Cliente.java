package usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import banco.Banco;
import banco.utils.Sucursal;
import usuario.utils.DatosComun;
import usuario.utils.Rol;

public class Cliente extends Persona{
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String primerApellido, String segundoApellido, String fecha, String genero, String ciudad, String estado, String direccion, String nombreUsuario, String contra, LocalDate fechaRegistro, Sucursal sucursalRegistro){
        super(nombre, primerApellido, segundoApellido, fecha, genero, ciudad, estado, direccion, nombreUsuario, contra, Rol.Cliente, sucursalRegistro);
        this.fechaRegistro = fechaRegistro;
    }

    public static void agregarCliente(Sucursal sucursal){
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun();

        Sucursal sucursalRegistro = sucursal;

        String nombre = datosComun.get(0);
        String primerApellido = datosComun.get(1);
        String segundoApellido = datosComun.get(2);
        String fecha = datosComun.get(3);
        String genero = datosComun.get(4);
        String estado = datosComun.get(5);
        String ciudad = datosComun.get(6);
        String direccion = datosComun.get(7);
        String nombreUsuario = datosComun.get(8);
        String contra = datosComun.get(9);

        Banco.usuarios.get(Rol.Cliente).add(new Cliente(nombre, primerApellido, segundoApellido, fecha, genero, ciudad, estado, direccion, nombreUsuario, contra, LocalDate.now(), sucursalRegistro));
    }

    public static void mostrarInformacionTodosClientes(Sucursal sucursal){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int cont = 0;
        if(Banco.usuarios.get(Rol.Cliente).isEmpty()){
            System.out.println("No se han agregado usuarios de dicho rol.");
        }
        else{
            for(Persona persona : Banco.usuarios.get(Rol.Cliente)){
                Cliente cliente = (Cliente) persona;
                if(cliente.getSucursal() == sucursal){
                    Persona.mostrarInformacion(Rol.Cliente, sucursal);
                    System.out.printf("Fecha de registro: %s%n", cliente.fechaRegistro.format(formatter));
                    cont++;
                }
            }
            if(cont == 0){
                System.out.println("No se han agregado usuarios de dicho rol.");
            } else{
                System.out.println("======================================================");
            }
        }
    }
}
