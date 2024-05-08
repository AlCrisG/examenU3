import usuario.Cliente;
import usuario.utils.DatosComun;

public class Main{
    public static void main(String[] args) {
        Cliente.agregarCliente();
        
        BankSystem bank = new BankSystem();
        bank.ejecutarSistema();
    }
}