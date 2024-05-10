package banco.menus;

import java.util.Scanner;

import banco.utils.Sucursal;
import usuario.Cliente;
import usuario.Empleado;
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
                            System.out.println("Registrar inversionista");
                            break;

                        case 4:
                            break;
                        
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;

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
                            System.out.println("Modificar cliente");
                            break;

                        case 2:
                            System.out.println("Modificar empleado");
                            break;

                        case 3:
                            System.out.println("Modificar inversionista");
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

                    switch(opcionConsultar){
                        case 1:
                            System.out.println("+-------------------------+");
                            System.out.println("|     MENU CONSULTAR      |");
                            System.out.println("+-------------------------+");
                            System.out.println("| OPCION | DESCRIPCION    |");
                            System.out.println("+-------------------------+");
                            System.out.println("|   1    | Todos          |");
                            System.out.println("|   2    | Buscar por ID  |");
                            System.out.println("|   3    | Regresar       |");
                            System.out.println("+------------------------+");
                            System.out.print("Elige una opción: ");
                            int consultarCliente = leerNum.nextInt();

                            switch (consultarCliente) {
                                case 1:
                                    Cliente.mostrarInformacionTodos(sucursal);
                                    break;

                                case 2:
                                    System.out.println("Método buscar por ID");
                                    break;
                            
                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }
                            break;

                        case 2:
                            System.out.println("Consultar empleado");
                            break;

                        case 3:
                            System.out.println("Consultar inversionistas");
                            break;

                        case 4:
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
