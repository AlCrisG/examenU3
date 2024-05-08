import usuario.utils.DatosComun;
import usuario.Cliente;
import banco.Banco;
import banco.BankSystem;
public class Main{
    public static void main(String[] args) {
        Cliente.agregarCliente();
        
        BankSystem bank = new BankSystem();
        bank.ejecutarSistema();
    }
}