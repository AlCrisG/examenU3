package banco.menus;

import java.util.Scanner;

import banco.Banco;
import banco.Inversion;
import banco.Tarjeta;
import banco.utils.EstatusSolicitud;
import banco.utils.Sucursal;
import usuario.Cliente;
import usuario.Empleado;
import usuario.Inversionista;
import usuario.utils.Rol;

public class MenuGerenteSucursal {
    private static Scanner leerNum = new Scanner(System.in);
    private static Scanner leerCadenas = new Scanner(System.in);

    public static void mostrarMenuGerenteSucursal(Sucursal sucursal){
        int opcion = 0;

        do{
            System.out.println("+------------------------+");
            if(sucursal == Sucursal.Madero){
                System.out.println("|    MENU BANCO MADERO   |");
            } else{
                System.out.println("|  MENU BANCO ACUEDUCTO  |");
            }
            System.out.println("+------------------------+");
            System.out.println("| OPCION | DESCRIPCION   |");
            System.out.println("+------------------------+");
            System.out.println("|   1    | Registrar     |");
            System.out.println("|   2    | Modificar     |");
            System.out.println("|   3    | Consultar     |");
            System.out.println("|   4    | Eliminar      |");
            System.out.println("|   6    | Tarjetas      |");
            System.out.println("|   5    | Cerrar sesión |");
            System.out.println("+------------------------+");
            System.out.print("Elige una opción: ");
            opcion = leerNum.nextInt();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
            switch(opcion){
                case 1:
                    System.out.println("+-------------------------+");
                    System.out.println("|     MENU REGISTRAR      |");
                    System.out.println("+-------------------------+");
                    System.out.println("| OPCION | DESCRIPCION    |");
                    System.out.println("+-------------------------+");
                    System.out.println("|   1    | Clientes       |");
                    System.out.println("|   2    | Empleados      |");
                    System.out.println("|   3    | Inversionistas |");
                    System.out.println("|   4    | Regresar       |");
                    System.out.println("+------------------------+");
                    System.out.print("Elige una opción: ");
                    int opcionRegistrar = leerNum.nextInt();

                    switch(opcionRegistrar){
                        case 1:
                            Cliente.agregarCliente(sucursal);
                            break;
                        
                        case 2:
                            System.out.println("+-------------------------+");
                            System.out.println("|    REGISTRAR EMPLEADO   |");
                            System.out.println("+-------------------------+");
                            System.out.println("| OPCION | DESCRIPCION    |");
                            System.out.println("+-------------------------+");
                            System.out.println("|   1    | Gerente        |");
                            System.out.println("|   2    | Ejecutivo      |");
                            System.out.println("|   3    | Capturista     |");
                            System.out.println("|   4    | Regresar       |");
                            System.out.println("+------------------------+");
                            System.out.print("Elige una opción: ");
                            int opcionEmpleado = leerNum.nextInt();

                            switch(opcionEmpleado){
                                case 1 -> Empleado.agregarEmpleado(Rol.GerenteSucursal, sucursal);
                                case 2 -> Empleado.agregarEmpleado(Rol.EjecutivoCuenta, sucursal);
                                case 3-> Empleado.agregarEmpleado(Rol.Capturista, sucursal);
                            }
                            break;

                        case 3:
                            System.out.println("Ingrese la contraseña: ");
                            String password = leerCadenas.nextLine();

                            boolean contrasenaCorrecta = Banco.contraInversionistas(password, sucursal);

                            if(contrasenaCorrecta){
                                Inversionista.agregarInversionista(sucursal);
                            }
                            break;

                        case 4:
                            break;
                        
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                case 2:
                    System.out.println("+-------------------------+");
                    System.out.println("|     MENU MODIFICAR      |");
                    System.out.println("+-------------------------+");
                    System.out.println("| OPCION | DESCRIPCION    |");
                    System.out.println("+-------------------------+");
                    System.out.println("|   1    | Clientes       |");
                    System.out.println("|   2    | Empleados      |");
                    System.out.println("|   3    | Inversionistas |");
                    System.out.println("|   4    | Regresar       |");
                    System.out.println("+------------------------+");
                    System.out.print("Elige una opción: ");
                    int opcionModificar = leerNum.nextInt();

                    switch(opcionModificar){
                        case 1:
                            Cliente.modificarCliente(sucursal);
                            break;

                        case 2:
                        System.out.println("+-------------------------+");
                        System.out.println("|    MODIFICAR EMPLEADO   |");
                        System.out.println("+-------------------------+");
                        System.out.println("| OPCION | DESCRIPCION    |");
                        System.out.println("+-------------------------+");
                        System.out.println("|   1    | Gerente        |");
                        System.out.println("|   2    | Ejecutivo      |");
                        System.out.println("|   3    | Capturista     |");
                        System.out.println("|   4    | Regresar       |");
                        System.out.println("+------------------------+");
                        System.out.print("Elige una opción: ");
                        int opcionEmpleado = leerNum.nextInt();

                        switch(opcionEmpleado){
                            case 1 -> Empleado.modificarEmpleado(Rol.GerenteSucursal,sucursal);
                            case 2 -> Empleado.modificarEmpleado(Rol.EjecutivoCuenta, sucursal);
                            case 3-> Empleado.modificarEmpleado(Rol.Capturista, sucursal);
                        }
                            break;

                        case 3:
                            System.out.println("Ingrese la contraseña: ");
                            String password = leerCadenas.nextLine();

                            boolean contrasenaCorrecta = Banco.contraInversionistas(password, sucursal);

                            if(contrasenaCorrecta){
                                Inversionista.modificarInversionista(sucursal);
                            }
                            break;

                        case 4:
                            break;

                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("+-------------------------+");
                    System.out.println("|     MENU CONSULTAR      |");
                    System.out.println("+-------------------------+");
                    System.out.println("| OPCION | DESCRIPCION    |");
                    System.out.println("+-------------------------+");
                    System.out.println("|   1    | Clientes       |");
                    System.out.println("|   2    | Empleados      |");
                    System.out.println("|   3    | Inversionistas |");
                    System.out.println("|   4    | Inversiones    |");
                    System.out.println("|   5    | Regresar       |");
                    System.out.println("+------------------------+");
                    System.out.print("Elige una opción: ");
                    int opcionConsultar = leerNum.nextInt();
                    int consultar = 0;

                    if(opcionConsultar == 3 || opcionConsultar == 4){
                        System.out.println("Ingrese la contraseña: ");
                        String password = leerCadenas.nextLine();

                        boolean contrasenaCorrecta = Banco.contraInversionistas(password, sucursal);

                        if(!contrasenaCorrecta){
                            break;
                        }
                    }

                    if(opcionConsultar < 5 && opcionConsultar > 0){
                        System.out.println("+-------------------------+");
                        System.out.println("|     MENU CONSULTAR      |");
                        System.out.println("+-------------------------+");
                        System.out.println("| OPCION | DESCRIPCION    |");
                        System.out.println("+-------------------------+");
                        System.out.println("|   1    | Todos          |");
                        if(opcionConsultar == 2){
                            System.out.println("|   2    | Por ID o Rol   |");
                        }
                        else if(opcionConsultar == 4){
                            System.out.println("|   2    | Por inversor   |");
                        }
                        else{
                            System.out.println("|   2    | Buscar por ID  |");
                        }
                        System.out.println("|   3    | Regresar       |");
                        System.out.println("+------------------------+");
                        System.out.print("Elige una opción: ");
                        consultar = leerNum.nextInt();
                    }

                    switch(opcionConsultar){
                        //Consultar Clientes
                        case 1:
                            switch (consultar) {
                                case 1:
                                    Cliente.mostrarInformacionTodosClientes(sucursal);
                                    break;

                                case 2:
                                    Cliente.consultarClientePorID(sucursal);
                                    break;

                                case 3:
                                    break;

                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }
                            break;
                        //Consultar Empleados
                        case 2:
                        switch (consultar) {
                            case 1:
                                for(int i= 0; i < 3; i++){
                                    Rol rol = null;
                                    switch (i) {
                                        case 0 -> rol = Rol.Capturista;
                                        case 1 -> rol = Rol.EjecutivoCuenta;
                                        case 2 -> rol = Rol.GerenteSucursal;
                                    }
                                    Empleado.mostrarInformacionTodos(rol, sucursal);
                                }
                                break;

                            case 2:
                                Empleado.consultarEmpleados(sucursal);
                                break;

                            case 3:
                                break;
                            
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                        break;

                        case 3:
                            switch (consultar) {
                                case 1:
                                    Inversionista.mostrarInformacionTodosInversionistas(sucursal);
                                    break;

                                case 2:
                                    Inversionista.consultarInversionistaPorID(sucursal);
                                    break;

                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }
                            break;

                        case 4:
                            switch (consultar) {
                                case 1:
                                    Inversion.consultarTodas(sucursal);
                                    break;

                                case 2:
                                    System.out.println("Ingrese el ID del inversor: ");
                                    int id = leerNum.nextInt();
                                    Inversion.consultarPorInversor(id, sucursal);
                                    break;

                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }
                            break;

                        case 5:
                            break;

                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("+----------------------------+");
                    System.out.println("|        MENU ELIMINAR       |");
                    System.out.println("+----------------------------+");
                    System.out.println("|   OPCION | DESCRIPCION     |");
                    System.out.println("+----------------------------+");
                    System.out.println("|     1    | Clientes        |");
                    System.out.println("|     2    | Empleados       |");
                    System.out.println("|     3    | Inversionistas  |");
                    System.out.println("|     4    | Regresar        |");
                    System.out.println("+----------------------------+");
                    System.out.print("Elige una opción: ");
                    int opcionEliminar = leerNum.nextInt();

                    switch(opcionEliminar){
                        case 1:
                            Cliente.eliminarCliente(sucursal);
                            break;

                        case 2:
                            Empleado.eliminarEmpleado(sucursal);
                            break;

                        case 3:
                            System.out.println("Ingrese la contraseña: ");
                            String password = leerCadenas.nextLine();

                            boolean contrasenaCorrecta = Banco.contraInversionistas(password, sucursal);

                            if(contrasenaCorrecta){
                                Inversionista.eliminarInversionista(sucursal);
                            }
                            break;
                            
                        case 4:
                            break;
                            
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("+--------------------------------+");
                    System.out.println("|          MENU TARJETAS         |");
                    System.out.println("+--------------------------------+");
                    System.out.println("|   OPCION | DESCRIPCION         |");
                    System.out.println("+--------------------------------+");
                    System.out.println("|     1    | Ver solicitudes     |");
                    System.out.println("|     2    | Autorizar tarjetas  |");
                    System.out.println("|     3    | Regresar            |");
                    System.out.println("+--------------------------------+");
                    System.out.print("Elige una opción: ");
                    int opcionTarjetas = leerNum.nextInt();

                    switch(opcionTarjetas){
                        case 1:
                            System.out.println("Seleccione una opción:");
                            System.out.println("1. Aprobadas");
                            System.out.println("2. En Proceso");
                            System.out.println("3. Rechazada");
                            System.out.println("Seleccione una opción: ");
                            int opcionSolicitud = leerNum.nextInt();

                            switch(opcionSolicitud){
                                case 1 -> Tarjeta.verSolicitudesTodos(EstatusSolicitud.Aprobada);
                                case 2 -> Tarjeta.verSolicitudesTodos(EstatusSolicitud.EnProceso);
                                case 3 -> Tarjeta.verSolicitudesTodos(EstatusSolicitud.Rechazada);
                                default -> System.out.println("Opción no válida.");
                            }
                            break;

                        case 2:
                            Tarjeta.cambiarEstatusSolicitud();
                            break;

                        case 3:
                            break;

                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }

                    break;

                case 6:
                    System.out.println("Cerrando sesión...");
                    return;

                default:
                    break;
            }
        }while(true);
    }
}
