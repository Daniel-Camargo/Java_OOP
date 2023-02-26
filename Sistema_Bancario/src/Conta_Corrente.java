import java.math.BigDecimal;
public class Conta_Corrente 
{
	private BigDecimal saldo;
	private String id;
	
	public BigDecimal getSaldo()
	{
		return saldo;
		
	}
	public void setSaldo(BigDecimal newSaldo)
	{
		this.saldo = newSaldo;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String newId)
	{
		this.id= newId;
	}
	public Conta_Corrente(BigDecimal saldo_inicial, String id)
	{
		if (saldo_inicial.compareTo(BigDecimal.ZERO) < 0)
		{
			throw new ArithmeticException("Não é possivel iniciar a conta com saldo negativo");
		}
		this.saldo=saldo_inicial;
		setId(id);
	}
	//Sobrecarga do construtor usando double
	public Conta_Corrente(double saldo_inicial, String id)
	{
		if (saldo_inicial < 0)
		{
			throw new ArithmeticException("Não é possivel iniciar a conta com saldo negativo");
		}
		this.saldo= BigDecimal.valueOf(saldo_inicial);
		setId(id);
	}
	//Sobrecarga do construtor usando int
	public Conta_Corrente(int saldo_inicial, String id)
	{
		if (saldo_inicial < 0)
		{
			throw new ArithmeticException("Não é possivel iniciar a conta com saldo negativo");
		}
		this.saldo= new BigDecimal(saldo_inicial);
		setId(id);
	}
	public void deposito(String id,BigDecimal valor)
	{	
		
		if (valor.compareTo(BigDecimal.ZERO) <= 0)
		{
			throw new ArithmeticException("O valor a ser depositado não pode ser nulo ou negativo");
		}
		this.saldo = saldo.add(valor);
	}
	//Sobrecarga do método depósito utilizando double
	public void deposito(String id,double valor)
	{
		if (valor <= 0)
		{
			throw new ArithmeticException("O valor a ser depositado não pode ser nulo ou negativo");
		}
		
		this.saldo = saldo.add(BigDecimal.valueOf(valor));
	}
	//Sobrecarga do método depósito utilizando int
	public void deposito(String id,int valor)
	{
		if (valor <= 0)
		{
			throw new ArithmeticException("O valor a ser depositado não pode ser nulo ou negativo");
		}
		this.saldo = saldo.add(BigDecimal.valueOf(valor));
	}
	public void transferencia(Conta_Corrente cc, BigDecimal valor_transferencia)
	{
		if (valor_transferencia.compareTo(saldo) == 1 )
		{
			throw new ArithmeticException("Saldo insuficiente");
		}
		saldo = saldo.subtract(valor_transferencia);
		cc.deposito(getId(), valor_transferencia);
	}
	//Sobrecarga do método de transferência utilizando double
	public void transferencia(Conta_Corrente cc, double valor_transferencia)
	{
		if (BigDecimal.valueOf(valor_transferencia).compareTo(saldo) == 1)
		{
			throw new ArithmeticException("Saldo insuficiente");
		}
		this.saldo = saldo.subtract(BigDecimal.valueOf(valor_transferencia));
		cc.deposito(getId(), valor_transferencia);
	}
	//Sobrecarga do método de transferência utilizando int
	public void transferencia(Conta_Corrente cc, int valor_transferencia)
	{
		if (BigDecimal.valueOf(valor_transferencia).compareTo(saldo) == 1)
		{
			throw new ArithmeticException("Saldo insuficiente");
		}
		this.saldo = saldo.subtract(BigDecimal.valueOf(valor_transferencia));
		cc.deposito(getId(), valor_transferencia);
	}
	public void saque(BigDecimal valor_saque)
	{
		if (valor_saque.compareTo(saldo) == 1 )
		{
			throw new ArithmeticException("Saldo insuficiente");
		}
		saldo = saldo.subtract(valor_saque);
	}
	// Sobrecarga do método saque utilizando double
	public void saque(double valor_saque)
	{
		if (BigDecimal.valueOf(valor_saque).compareTo(saldo) == 1 )
		{
			throw new ArithmeticException("Saldo insuficiente");
		}
		this.saldo = saldo.subtract(BigDecimal.valueOf(valor_saque));
	}
	// Sobrecarga do método saque utilizando int
	public void saque(int valor_saque)
	{
		if (BigDecimal.valueOf(valor_saque).compareTo(saldo) == 1 )
		{
			throw new ArithmeticException("Saldo insuficiente");
		}
		this.saldo = saldo.subtract(BigDecimal.valueOf(valor_saque));
	}
	
}
