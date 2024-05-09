package banco;
import java.util.Scanner;

import banco.utils.Sucursal;
import usuario.Cliente;
import usuario.Empleado;
import usuario.Persona;
import usuario.utils.Rol;
import usuario.utils.UsuarioEnSesion;

public class BankSystem {
    public static Scanner leerNum = new Scanner(System.in);
    public static Scanner leerCad = new Scanner(System.in);
    Banco banco = new Banco();

    public void ejecutarSistema(){    
            int opcion=0;
            do {
                System.out.println("\n*** BIENVENIDO ***");
                System.out.println("¿A QUE SUCURSAL DESEA INGRESAR?:");
                System.out.println("1.- Madero");
                System.out.println("2.- Acueducto");
                System.out.println("3.- Salir");
                opcion = leerNum.nextInt();
        
                switch (opcion) {
                    case 1:
                        ejecutarSistemaMadero();
                        break;
                    case 2:
                        ejecutarSistemaAcueducto();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }
            } while (true);
        
    }


    public void ejecutarSistemaMadero(){

        boolean datosCorrectos = false;

        do {
            System.out.println("BIENVENIDO AL SISTEMA DE LA BIBLIOTECA");
            System.out.println("Inicia sesión para continuar");

            System.out.println("Ingresa tu usuario: ");
            String usuario = leerCad.nextLine();

            System.out.println("Ingresa tu contrasena: ");
            String contraMadero = leerCad.nextLine();

            Persona usuarioActual = banco.verificarInicioSesion(usuario, contraMadero);

            if (usuarioActual != null) {
                UsuarioEnSesion.getInstancia().setUsuario(usuarioActual);
                datosCorrectos = true;
                seleccionarMenu();
            } else {
                System.out.println("Usuario o contrasena incorrectos. Intenta de nuevo.");
            }

        } while (!datosCorrectos);
    }

    private void seleccionarMenu() {
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()) {
            case Cliente -> mostrarMenuCliente();
            case EjecutivoCuenta -> mostrarMenuEjecutivoCuenta();
            case GerenteSucursal -> mostrarMenuMaderoGerenteSucursal();
            case Capturista -> mostrarMenuMaderoCapturista();
            case Inversionista -> mostrarMenuMaderoInversionista();
        }
    }

    public void mostrarMenuCliente(){

}

    public void mostrarMenuEjecutivoCuenta(){

    }

    public void mostrarMenuMaderoCapturista(){

    }

    public void mostrarMenuMaderoInversionista(){

    }

    public void mostrarMenuMaderoGerenteSucursal(){
            do {
                boolean opcionValida = true;
                System.out.println("+------------------------+");
                System.out.println("|    MENU BANCO MADERO   |");
                System.out.println("+------------------------+");
                System.out.println("| OPCION | DESCRIPCION   |");
                System.out.println("+------------------------+");
                System.out.println("|   1    | Registrar     |");
                System.out.println("|   2    | Modificar     |");
                System.out.println("|   3    | Consultar     |");
                System.out.println("|   4    | Eliminar      |");
                System.out.println("|   5    | Regresar      |");
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
                                    Cliente.agregarCliente(Sucursal.Madero);
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
                                        case 1 -> Empleado.agregarEmpleado(Rol.GerenteSucursal, Sucursal.Madero);
                                        case 2 -> Empleado.agregarEmpleado(Rol.EjecutivoCuenta, Sucursal.Madero);
                                        case 3-> Empleado.agregarEmpleado(Rol.Capturista, Sucursal.Madero);
                                    }
                                    break;
                                case 3:
                                    System.out.println("metodo registrar inverisonistas");
                                    break;
                                case 4:
                                    mostrarMenuMaderoGerenteSucursal();
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
                                    mostrarMenuMaderoGerenteSucursal();
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
                                    mostrarMenuMaderoGerenteSucursal();
                                    break;
                                default:
                                    System.out.println("Opcion no valida");
                                    break;
                            }

                            break;
                        case 4:
                        System.out.println("+----------------------------+");
                        System.out.println("|     MENU ELIMINAR MADERO   |");
                        System.out.println("+----------------------------+");
                        System.out.println("|    OPCION | DESCRIPCION    |");
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
                                mostrarMenuMaderoGerenteSucursal();
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }


                            break;
                        case 5:
                            ejecutarSistemaMadero();
                            break;
                        default:
                        System.out.println("Opcion no valida");
                            break;
                    }
                } while(!opcionValida);
            } while (true);
    }


    public void ejecutarSistemaAcueducto(){
        final String CONTRABANCO2 = "BANCO2";

        boolean contraEsCorrecta = false;

        do {
            System.out.println("\n*** BIENVENIDO A LA SUCURSAL ACUEDUCTO ***");
            System.out.println("Ingrese la contraseña");
            String password = leerCad.nextLine();

            if (password.equals(CONTRABANCO2)) {
                contraEsCorrecta = true;
                mostrarMenuAcueductoGerenteSucursal();
            } else {
                System.out.println("\nContraseña incorrecta, intenta de nuevo");
            }
        } while (!contraEsCorrecta);
    }

    public void mostrarMenuAcueductoGerenteSucursal(){
        do {
            boolean opcionValida = true;
            System.out.println("+------------------------+");
            System.out.println("|  MENU BANCO ACUEDUCTO  |");
            System.out.println("+------------------------+");
            System.out.println("| OPCION | DESCRIPCION   |");
            System.out.println("+------------------------+");
            System.out.println("|   1    | Registrar     |");
            System.out.println("|   2    | Modificar     |");
            System.out.println("|   3    | Consultar     |");
            System.out.println("|   4    | Eliminar      |");
            System.out.println("|   5    | Regresar      |");
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
                                Cliente.agregarCliente(Sucursal.Acueducto);
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
                                    case 1 -> Empleado.agregarEmpleado(Rol.GerenteSucursal, Sucursal.Acueducto);
                                    case 2 -> Empleado.agregarEmpleado(Rol.EjecutivoCuenta, Sucursal.Acueducto);
                                    case 3-> Empleado.agregarEmpleado(Rol.Capturista, Sucursal.Acueducto);
                                }
                                break;
                            case 3:
                                System.out.println("metodo registrar inverisonistas");
                                break;
                            case 4:
                                mostrarMenuAcueductoGerenteSucursal();
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
                                mostrarMenuAcueductoGerenteSucursal();
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
                                mostrarMenuAcueductoGerenteSucursal();
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }

                        break;
                    case 4:
                    System.out.println("+-------------------------------+");
                    System.out.println("|         MENU ELIMINAR         |");
                    System.out.println("+-------------------------------+");
                    System.out.println("|      OPCION | DESCRIPCION     |");
                    System.out.println("+-------------------------------+");
                    System.out.println("|     1    | Clientes           |");
                    System.out.println("|     2    | Empleados          |");
                    System.out.println("|     3    | Inversionistas     |");
                    System.out.println("|     4    | Regresar           |");
                    System.out.println("+-------------------------------+");
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
                            mostrarMenuAcueductoGerenteSucursal();
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }


                        break;
                    case 5:
                        ejecutarSistemaAcueducto();
                        break;
                    default:
                    System.out.println("Opcion no valida");
                        break;
                }
            } while(!opcionValida);
        } while (true);
    }
}
