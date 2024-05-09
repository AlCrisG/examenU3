import usuario.utils.DatosComun;
import usuario.Cliente;
import banco.Banco;
import banco.BankSystem;
public class Main{
    public static void main(String[] args) {        
        BankSystem bank = new BankSystem();
        bank.ejecutarSistema();
    }
}