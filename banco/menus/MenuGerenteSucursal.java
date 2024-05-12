package banco.menus;

import java.util.Scanner;

import banco.utils.Sucursal;
import usuario.Cliente;
import usuario.Empleado;
import usuario.Inversionista;
import usuario.utils.Rol;

public class MenuGerenteSucursal {
    private static Scanner leerNum = new Scanner(System.in);

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
                            Inversionista.agregarInversionista(sucursal);
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
                            Inversionista.modificarInversionista(sucursal);
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
                    System.out.println("|   4    | Regresar       |");
                    System.out.println("+------------------------+");
                    System.out.print("Elige una opción: ");
                    int opcionConsultar = leerNum.nextInt();
                    int consultar = 0;

                    if(opcionConsultar < 4 && opcionConsultar > 0){
                        System.out.println("+-------------------------+");
                        System.out.println("|     MENU CONSULTAR      |");
                        System.out.println("+-------------------------+");
                        System.out.println("| OPCION | DESCRIPCION    |");
                        System.out.println("+-------------------------+");
                        System.out.println("|   1    | Todos          |");
                        if(opcionConsultar == 2){
                            System.out.println("|   2    | Buscar por ID o Rol |");
                            System.out.println("|   3    | Regresar       |");
                        } else{
                            System.out.println("|   2    | Buscar por ID  |");
                            System.out.println("|   3    | Regresar       |");
                        }
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
                                    System.out.println("Método buscar por ID");
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
                                    Empleado.mostrarInformacionTodosEmpleados(rol, sucursal);
                                }
                            case 2:

                                System.out.println("Ingrese qué empleados quiere consultar");
                                System.out.println("1.- Gerentes");
                                System.out.println("2.- Ejecutivos");
                                System.out.println("3.- Capturistas");
                                int opcionConsultarEmpleadoXRol = leerNum.nextInt();
                                switch (opcionConsultarEmpleadoXRol) {
                                    case 1 -> Empleado.consultarEmpleados(Rol.GerenteSucursal, sucursal);
                                    case 2 -> Empleado.consultarEmpleados(Rol.EjecutivoCuenta, sucursal);
                                    case 3 -> Empleado.consultarEmpleados(Rol.Capturista, sucursal);
                                    default -> System.out.println("Opcion invalida");
                                }
                                
                                break;

                            case 3:
                                return;
                            
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                        break;

                        case 3:
                            Inversionista.mostrarInformacionTodosInversionistas(sucursal);
                            break;

                        case 4:
                            System.out.println("Mostrar inversionista por id");
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
                            System.out.println("Eliminar clientes");
                            break;

                        case 2:
                            System.out.println("Eliminar empleado");
                            break;

                        case 3:
                            System.out.println("Eliminar inversionistas");
                            break;
                            
                        case 4:
                            break;
                            
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("Cerrando sesión...");
                    return;

                default:
                    break;
            }
        }while(true);
    }
}
