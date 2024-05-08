import java.util.Scanner;

public class BankSystem {
    public static Scanner leerNum = new Scanner(System.in);
    public static Scanner leerCad = new Scanner(System.in);

    public void ejecutarSistema(){
        
            boolean isCorrectPassword = false;
            int opcion=0;
            do {
                System.out.println("\n*** BIENVENIDO ***");
                System.out.println("¿A QUE SUCURSAL DESEA INGRESAR?:");
                System.out.println("1.- Madero");
                System.out.println("2.- Acueducto");
                System.out.println("3.- Salir");
                opcion = leerNum.nextInt();
    
                do {
                    
                    switch (opcion) {
                        case 1:
                            ejecutarSistemaMadero();
                            break;
                        case 2:
                            ejecutarSistemaAcueducto();
                            break;
                        case 3:

                            break;
                        default:
                            System.out.println("Opción no valida");
                            break;
                    }


                } while (!isCorrectPassword);

                
            } while (true);
        
    }


    public void ejecutarSistemaMadero(){
        final String CONTRABANCO1 = "BANCO1";

        boolean contraEsCorrecta = false;

        do {
            System.out.println("\n*** BIENVENIDO A LA SUCURSAL MADERO ***");
            System.out.println("Ingrese la contraseña");
            String password = leerCad.nextLine();

            if (password.equals(CONTRABANCO1)) {
                contraEsCorrecta = true;
                ejecutarMenuMadero();
            } else {
                System.out.println("\nContraseña incorrecta, intenta de nuevo");
            }
        } while (!contraEsCorrecta);
    }

    public void ejecutarMenuMadero(){
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
                                System.out.println("metodo registrar clientes");
                                break;
                            case 2:
                                System.out.println("metodo registrar enmpleados");
                                break;
                            case 3:
                                System.out.println("metodo registrar inverisonistas");
                                break;
                            case 4:
                                ejecutarMenuMadero();
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
                                ejecutarMenuMadero();
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }
                            break;
                        case 3:
                            
                            break;
                        case 4:
                            
                            break;
                        case 5:
                            
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
                ejecutarMenuAcueducto();
            } else {
                System.out.println("\nContraseña incorrecta, intenta de nuevo");
            }
        } while (!contraEsCorrecta);
    }

    public void ejecutarMenuAcueducto(){

    }
}
