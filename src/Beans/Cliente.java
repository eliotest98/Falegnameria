package Beans;

public class Cliente 
{
	private int idCliente;
	private String NomePersona;
	private long NumeroTelefono;
	public Cliente(int idCliente,String NomePersona, long NumeroTelefono) {
		this.idCliente=idCliente;
		this.NomePersona=NomePersona;
		this.NumeroTelefono=NumeroTelefono;
	}
	public Cliente(String NomePersona, long NumeroTelefono) {
		this.NomePersona=NomePersona;
		this.NumeroTelefono=NumeroTelefono;
	}
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomePersona() {
		return NomePersona;
	}
	public void setNomePersona(String nomePersona) {
		NomePersona = nomePersona;
	}
	public long getNumeroTelefono() {
		return NumeroTelefono;
	}
	public void setNumeroTelefono(long numeroTelefono) {
		NumeroTelefono = numeroTelefono;
	}
}
