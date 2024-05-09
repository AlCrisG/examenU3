package banco.menus;

import java.util.Scanner;

import banco.utils.Sucursal;
import usuario.Cliente;
import usuario.Empleado;
import usuario.utils.Rol;

public class MenuGerente {
    private static Scanner leerNum = new Scanner(System.in);

    public static int mostrarMenuGerenteSucursal(Sucursal sucursal){
                boolean opcionValida = true;
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
                int opcion = leerNum.nextInt();

                do {
                    opcionValida = true;
                    switch (opcion) {
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

                            switch (opcionRegistrar) {
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

                                    switch (opcionEmpleado){
                                        case 1 -> Empleado.agregarEmpleado(Rol.GerenteSucursal, sucursal);
                                        case 2 -> Empleado.agregarEmpleado(Rol.EjecutivoCuenta, sucursal);
                                        case 3-> Empleado.agregarEmpleado(Rol.Capturista, sucursal);
                                    }
                                    break;
                                case 3:
                                    System.out.println("metodo registrar inverisonistas");
                                    break;
                                case 4:
                                    mostrarMenuGerenteSucursal(sucursal);
                                    break;
                                default:
                                    System.out.println("Opcion no valida");
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

                            switch (opcionModificar) {
                                case 1:
                                    System.out.println("metodo modif clientes");
                                    break;
                                case 2:
                                    System.out.println("metodo modif enmpleados");
                                    break;
                                case 3:
                                    System.out.println("metodo modif inverisonistas");
                                    break;
                                case 4:
                                    mostrarMenuGerenteSucursal(sucursal);
                                    break;
                                default:
                                    System.out.println("Opcion no valida");
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

                            switch (opcionConsultar) {
                                case 1:
                                    System.out.println("metodo consultar clientes");
                                    break;
                                case 2:
                                    System.out.println("metodo consultar enmpleados");
                                    break;
                                case 3:
                                    System.out.println("metodo consultar inverisonistas");
                                    break;
                                case 4:
                                    mostrarMenuGerenteSucursal(sucursal);
                                    break;
                                default:
                                    System.out.println("Opcion no valida");
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

                        switch (opcionEliminar) {
                            case 1:
                                System.out.println("metodo eliminar clientes");
                                break;
                            case 2:
                                System.out.println("metodo eliminar enmpleados");
                                break;
                            case 3:
                                System.out.println("metodo eliminar inverisonistas");
                                break;
                            case 4:
                                mostrarMenuGerenteSucursal(sucursal);
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }


                            break;
                        case 5:
                        System.out.println("Cerrando sesión...");
                            break;
                        default:
                        System.out.println("Opcion no valida");
                            break;
                    }
                } while(!opcionValida);
                opcion = 5;
                return opcion;
    }
}
