package Database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Cliente;
import Beans.Lavori;
import Beans.Ricavo;

public class DatabaseQuary {
	
	//Lavori
	private static String queryGetLavori;
	private static String queryGetLavoriByPagamento;
	private static String queryEliminaLavoro;
	private static String queryAddLavoro;
	private static String queryUpdatePagamento;
	private static String queryCercaLavoro;
	//Clienti
	private static String queryAddCliente;
	private static String queryGetClienti;
	private static String queryCercaCliente;
	private static String queryGetClientiById;
	private static String queryDelClienteById;
	//Ricavi
	private static String queryAggiungiRicavo;
	private static String queryGetRicavi;
	private static String queryGetRicaviByMese;
	private static String queryEliminaRicavo;
	private static String queryEliminaRicavoByMese;
	//ArrayList
	private static ArrayList<Lavori> listLavori;
	private static ArrayList<Cliente> listClienti;
	private static ArrayList<Ricavo> listRicavi;
	//classi
	
	public synchronized static ArrayList<Ricavo> getRicaviByMese(String mese) throws SQLException{
		Connection connection = null;
		PreparedStatement psListRicavi= null;
		listRicavi = new ArrayList<>();
		int mese2 = 1;
		if(mese.equalsIgnoreCase("Gennaio"))
		{
			mese2=1;
		}
		else if(mese.equalsIgnoreCase("Febbraio"))
		{
			mese2=2;
		}
		else if(mese.equalsIgnoreCase("Marzo"))
		{
			mese2=3;
		}
		else if(mese.equalsIgnoreCase("Aprile"))
		{
			mese2=4;
		}
		if(mese.equalsIgnoreCase("Maggio"))
		{
			mese2=5;
		}
		else if(mese.equalsIgnoreCase("Giugno"))
		{
			mese2=6;
		}
		else if(mese.equalsIgnoreCase("Luglio"))
		{
			mese2=7;
		}
		else if(mese.equalsIgnoreCase("Agosto"))
		{
			mese2=8;
		}
		else if(mese.equalsIgnoreCase("Settembre"))
		{
			mese2=9;
		}
		else if(mese.equalsIgnoreCase("Ottobre"))
		{
			mese2=10;
		}
		if(mese.equalsIgnoreCase("Novembre"))
		{
			mese2=11;
		}
		else if(mese.equalsIgnoreCase("Dicembre"))
		{
			mese2=12;
		}
		try{
			connection = Database.getConnection();
			psListRicavi = connection.prepareStatement(queryGetRicaviByMese);
			psListRicavi.setInt(1, mese2);
			ResultSet rs = psListRicavi.executeQuery();
			while(rs.next()){
				Ricavo pr = new Ricavo();
				pr.setIdRicavo(rs.getInt("idRicavo"));
				pr.setRicavo(rs.getBigDecimal("Ricavo"));
				pr.setMese(rs.getInt("Mese"));
				listRicavi.add(pr);
			}
		}
		finally {
			try {
				if(psListRicavi != null)
					psListRicavi.close();
				if(psListRicavi !=null)
					psListRicavi.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connection.close();
				Database.releaseConnection(connection);
			}
		}
		return listRicavi;
	}
	
	public synchronized static ArrayList<Ricavo> getRicavi() throws SQLException{
		Connection connection = null;
		PreparedStatement psListRicavi= null;
		listRicavi = new ArrayList<>();
		try{
			connection = Database.getConnection();
			psListRicavi = connection.prepareStatement(queryGetRicavi);
			ResultSet rs = psListRicavi.executeQuery();
			while(rs.next()){
				Ricavo pr = new Ricavo();
				pr.setIdRicavo(rs.getInt("idRicavo"));
				pr.setRicavo(rs.getBigDecimal("Ricavo"));
				pr.setMese(rs.getInt("Mese"));
				listRicavi.add(pr);
			}
		}
		finally {
			try {
				if(psListRicavi != null)
					psListRicavi.close();
				if(psListRicavi !=null)
					psListRicavi.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connection.close();
				Database.releaseConnection(connection);
			}
		}
		return listRicavi;
	}
	
	public synchronized static ArrayList<Cliente> getClienti() throws SQLException{
		Connection connection = null;
		PreparedStatement psListLavori= null;
		listClienti = new ArrayList<>();
		
		try{
			connection = Database.getConnection();
			psListLavori = connection.prepareStatement(queryGetClienti);
			ResultSet rs = psListLavori.executeQuery();
			while(rs.next()){
				Cliente pr = new Cliente();
				pr.setIdCliente(rs.getInt("idCliente"));
				pr.setNomePersona(rs.getString("NomePersona"));
				pr.setNumeroTelefono(rs.getLong("NumeroTelefono"));
				listClienti.add(pr);
			}
		}
		finally {
			try {
				if(psListLavori != null)
					psListLavori.close();
				if(psListLavori !=null)
					psListLavori.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connection.close();
				Database.releaseConnection(connection);
			}
		}
		return listClienti;
	}
	
	public synchronized static ArrayList<Lavori> getLavori() throws SQLException{
		Connection connection = null;
		PreparedStatement psListLavori= null;
		listLavori = new ArrayList<>();
		
		try{
			connection = Database.getConnection();
			psListLavori = connection.prepareStatement(queryGetLavori);
			ResultSet rs = psListLavori.executeQuery();
			while(rs.next()){
				Lavori pr = new Lavori();
				pr.setIdLavoro(rs.getInt("idLavoro"));
				pr.setDescrizione(rs.getString("Descrizione"));
				pr.setDataPrenotazione(rs.getDate("DataPrenotazione"));
				pr.setSpeseMateriale(rs.getBigDecimal("SpeseMateriale"));
				pr.setPagamento(rs.getBigDecimal("Pagamento"));
				listLavori.add(pr);
			}

		}
		finally {
			try {
				if(psListLavori != null)
					psListLavori.close();
				if(psListLavori !=null)
					psListLavori.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connection.close();
				Database.releaseConnection(connection);
			}
		}
		return listLavori;
	}
	
	public synchronized static Cliente getClientiById(int indice) throws SQLException{
		Connection connection = null;
		PreparedStatement psListLavori= null;
		Cliente cliente = new Cliente();
		try{
			connection = Database.getConnection();
			psListLavori = connection.prepareStatement(queryGetClientiById);
			psListLavori.setInt(1, indice);
			ResultSet rs = psListLavori.executeQuery();
			while(rs.next()){
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNomePersona(rs.getString("NomePersona"));
				cliente.setNumeroTelefono(rs.getLong("NumeroTelefono"));
			}
		}
		finally {
			try {
				if(psListLavori != null)
					psListLavori.close();
				if(psListLavori !=null)
					psListLavori.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connection.close();
				Database.releaseConnection(connection);
			}
		}
		return cliente;
	}
	
	public synchronized static ArrayList<Lavori> getLavoriByPagamento() throws SQLException{
		Connection connection = null;
		PreparedStatement psListLavori= null;
		listLavori = new ArrayList<>();
		
		try{
			connection = Database.getConnection();
			psListLavori = connection.prepareStatement(queryGetLavoriByPagamento);

			ResultSet rs = psListLavori.executeQuery();

			while(rs.next()){
				Lavori pr = new Lavori();
				pr.setIdLavoro(rs.getInt("idLavoro"));
				pr.setDescrizione(rs.getString("Descrizione"));
				pr.setDataPrenotazione(rs.getDate("DataPrenotazione"));
				pr.setSpeseMateriale(rs.getBigDecimal("SpeseMateriale"));
				pr.setPagamento(rs.getBigDecimal("Pagamento"));
				listLavori.add(pr);
			}

		}
		finally {
			try {
				if(psListLavori != null)
					psListLavori.close();
				if(psListLavori !=null)
					psListLavori.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connection.close();
				Database.releaseConnection(connection);
			}
		}
		return listLavori;
	}
	
	public synchronized static boolean updatePagamento	(int idLavoro,BigDecimal Pagamento) throws SQLException{
		Connection connection = null;
		PreparedStatement psDelProdotto = null;

		try{
			connection = Database.getConnection();
			psDelProdotto = connection.prepareStatement(queryUpdatePagamento);
			psDelProdotto.setBigDecimal(1, Pagamento);
			psDelProdotto.setInt(2, idLavoro);

			psDelProdotto.executeUpdate();

			connection.commit();
		} finally {
			try{
				if(psDelProdotto != null)
					psDelProdotto.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	
	public synchronized static boolean delRicaviByMese(String mese) throws SQLException{
		Connection connection = null;
		PreparedStatement psDelProdotto = null;
		int mese2 = 1;
		if(mese.equalsIgnoreCase("Gennaio"))
		{
			mese2=1;
		}
		else if(mese.equalsIgnoreCase("Febbraio"))
		{
			mese2=2;
		}
		else if(mese.equalsIgnoreCase("Marzo"))
		{
			mese2=3;
		}
		else if(mese.equalsIgnoreCase("Aprile"))
		{
			mese2=4;
		}
		if(mese.equalsIgnoreCase("Maggio"))
		{
			mese2=5;
		}
		else if(mese.equalsIgnoreCase("Giugno"))
		{
			mese2=6;
		}
		else if(mese.equalsIgnoreCase("Luglio"))
		{
			mese2=7;
		}
		else if(mese.equalsIgnoreCase("Agosto"))
		{
			mese2=8;
		}
		else if(mese.equalsIgnoreCase("Settembre"))
		{
			mese2=9;
		}
		else if(mese.equalsIgnoreCase("Ottobre"))
		{
			mese2=10;
		}
		if(mese.equalsIgnoreCase("Novembre"))
		{
			mese2=11;
		}
		else if(mese.equalsIgnoreCase("Dicembre"))
		{
			mese2=12;
		}
		try{
			connection = Database.getConnection();
			psDelProdotto = connection.prepareStatement(queryEliminaRicavoByMese);
			psDelProdotto.setInt(1, mese2);
			psDelProdotto.executeUpdate();
			
			connection.commit();
		} finally {
			try{
				if(psDelProdotto != null)
					psDelProdotto.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	
	public synchronized static boolean delRicavi() throws SQLException{
		Connection connection = null;
		PreparedStatement psDelProdotto = null;

		try{
			connection = Database.getConnection();
			psDelProdotto = connection.prepareStatement(queryEliminaRicavo);

			psDelProdotto.executeUpdate();
			
			connection.commit();
		} finally {
			try{
				if(psDelProdotto != null)
					psDelProdotto.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	
	public synchronized static boolean delClienteById(int idCliente) throws SQLException{
		Connection connection = null;
		PreparedStatement psDelProdotto = null;
		try{
			connection = Database.getConnection();
			psDelProdotto = connection.prepareStatement(queryDelClienteById);
			psDelProdotto.setInt(1, idCliente);

			psDelProdotto.executeUpdate();

			connection.commit();
		} finally {
			try{
				if(psDelProdotto != null)
					psDelProdotto.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	
	public synchronized static boolean delLavoro(int idLavoro) throws SQLException{
		Connection connection = null;
		PreparedStatement psDelProdotto = null;

		try{
			connection = Database.getConnection();
			psDelProdotto = connection.prepareStatement(queryEliminaLavoro);
			psDelProdotto.setInt(1, idLavoro);

			psDelProdotto.executeUpdate();

			connection.commit();
		} finally {
			try{
				if(psDelProdotto != null)
					psDelProdotto.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	
	public synchronized static Lavori cercaLavoro(int nomePersona) throws SQLException{
		Connection connection = null;
		PreparedStatement psListProdotti= null;
		Lavori pr = new Lavori();
		try{
			connection = Database.getConnection();
			psListProdotti = connection.prepareStatement(queryCercaLavoro);

			psListProdotti.setInt(1, nomePersona);
			ResultSet rs = psListProdotti.executeQuery();
			while(rs.next()){
				pr.setIdLavoro(rs.getInt("idLavoro"));
				pr.setDescrizione(rs.getString("Descrizione"));
				pr.setDataPrenotazione(rs.getDate("DataPrenotazione"));
				pr.setSpeseMateriale(rs.getBigDecimal("SpeseMateriale"));
				pr.setPagamento(rs.getBigDecimal("Pagamento"));
			}
		}
		finally {
			try {
				if(psListProdotti != null)
					psListProdotti.close();
				if(psListProdotti !=null)
					psListProdotti.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connection.close();
				Database.releaseConnection(connection);
			}
		}
		return pr;
	}
	
	public synchronized static ArrayList<Cliente> cercaPersona(String nomePersona) throws SQLException{
		Connection connection = null;
		PreparedStatement psListProdotti= null;
		listClienti = new ArrayList<Cliente>();
		try{
			connection = Database.getConnection();
			psListProdotti = connection.prepareStatement(queryCercaCliente);

			psListProdotti.setString(1, nomePersona);
			ResultSet rs = psListProdotti.executeQuery();

			while(rs.next()){
				Cliente pr = new Cliente();
				pr.setIdCliente(rs.getInt("idCliente"));
				pr.setNomePersona(rs.getString("NomePersona"));
				pr.setNumeroTelefono(rs.getLong("NumeroTelefono"));
				listClienti.add(pr);
			}
		}
		finally {
			try {
				if(psListProdotti != null)
					psListProdotti.close();
				if(psListProdotti !=null)
					psListProdotti.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connection.close();
				Database.releaseConnection(connection);
			}
		}
		return listClienti;
	}
	
	public synchronized static boolean addCliente(Cliente cliente) throws SQLException{
		Connection connection = null;
		PreparedStatement psAddLavoro = null;

		try{
			connection = Database.getConnection();
			psAddLavoro = connection.prepareStatement(queryAddCliente);
			psAddLavoro.setString(1, cliente.getNomePersona());
			psAddLavoro.setLong(2, cliente.getNumeroTelefono());
			System.out.println(psAddLavoro.toString());

			psAddLavoro.executeUpdate();
			connection.commit();
			System.out.println("Insert Cliente Connessione...");
		} finally {
			try{
				if(psAddLavoro != null)
					psAddLavoro.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	
	public synchronized static boolean addLavoro(Lavori lav) throws SQLException{
		Connection connection = null;
		PreparedStatement psAddLavoro = null;

		try{
			connection = Database.getConnection();
			psAddLavoro = connection.prepareStatement(queryAddLavoro);
			psAddLavoro.setString(1, lav.getDescrizione());
			psAddLavoro.setDate(2, lav.getDataPrenotazione());
			psAddLavoro.setBigDecimal(3, lav.getSpeseMateriale());
			System.out.println(psAddLavoro.toString());

			psAddLavoro.executeUpdate();
			connection.commit();
			System.out.println("Insert Lavoro Connessione...");
		} finally {
			try{
				if(psAddLavoro != null)
					psAddLavoro.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	
	public synchronized static boolean aggiungiRicavo(Ricavo ric) throws SQLException{
		Connection connection = null;
		PreparedStatement psAddRicavo = null;

		try{
			connection = Database.getConnection();
			psAddRicavo = connection.prepareStatement(queryAggiungiRicavo);
			psAddRicavo.setBigDecimal(1, ric.getRicavo());
			psAddRicavo.setInt(2, ric.getMese());
			System.out.println(psAddRicavo.toString());
			psAddRicavo.executeUpdate();
			connection.commit();
			System.out.println("Insert Lavoro Connessione...");
		} finally {
			try{
				if(psAddRicavo != null)
					psAddRicavo.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	
	static {
		queryGetLavori = "SELECT * FROM papa.lavori";
		queryGetClienti = "SELECT * FROM papa.clienti";
		queryGetLavoriByPagamento = "SELECT * FROM papa.lavori WHERE Pagamento=0";
		queryEliminaLavoro = "DELETE FROM papa.lavori WHERE idLavoro = ?";
		queryCercaCliente ="SELECT * FROM papa.clienti WHERE NomePersona = ?";
		queryAddLavoro ="INSERT INTO papa.lavori (Descrizione, DataPrenotazione, SpeseMateriale) VALUES (?,?,?)";
		queryUpdatePagamento = "UPDATE papa.lavori SET Pagamento = ? WHERE (idLavoro = ?)";
		queryAggiungiRicavo = "INSERT INTO papa.ricavi (Ricavo,Mese) VALUES (?,?)";
		queryAddCliente = "INSERT INTO papa.clienti (NomePersona, NumeroTelefono) VALUES (?,?)";
		queryCercaLavoro = "SELECT * FROM papa.lavori WHERE idLavoro = ?";
		queryGetClientiById = "SELECT * FROM papa.clienti WHERE idCliente = ?";
		queryGetRicavi = "SELECT * FROM papa.ricavi";
		queryGetRicaviByMese = "SELECT * FROM papa.ricavi WHERE Mese=?";
		queryEliminaRicavo = "DELETE FROM papa.ricavi";
		queryEliminaRicavoByMese ="DELETE FROM papa.ricavi WHERE Mese=?";
		queryDelClienteById = "DELETE FROM papa.clienti WHERE idCliente =?";
	}
}