import java.util.ArrayList;
import java.util.List;
public class main 
{

	public static void main(String[] args) 
	{
		List <Conta_Corrente> lista_cc = new ArrayList<>();
		Conta_Corrente cc= new Conta_Corrente(5.500, "7593");
		Conta_Corrente cc1= new Conta_Corrente(10.000, "7592");
		cc.transferencia(cc1, 4.000);
		System.out.println("Saldo do destinatario após receber a transferencia: " + cc1.getSaldo());
		System.out.println("Saldo do remetente após realizar a transferencia: " + cc.getSaldo());
		cc1.saque(6.000);
		System.out.println("Saldo após realizar o saque: " + cc1.getSaldo());
		cc.deposito("7593", 100);
		System.out.println("Saldo após o depósito: " + cc.getSaldo());
	}
}
