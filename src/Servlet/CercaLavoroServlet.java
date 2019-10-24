package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Cliente;
import Beans.Lavori;
import Database.DatabaseQuary;

/**
 * Servlet implementation class CercaLavoroServlet
 */
@WebServlet("/CercaLavoroServlet")
public class CercaLavoroServlet extends HttpServlet {
	static ArrayList<Cliente>listClienti;
	static ArrayList<Lavori>listLavori;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CercaLavoroServlet() {
    	super();
        listClienti = new ArrayList<Cliente>();
        listLavori = new ArrayList<Lavori>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomePersona = request.getParameter("nomeLavoro");
		try{
			//System.out.println("NomeProdotto:" +nomeProdotto);
			listClienti = DatabaseQuary.cercaPersona(nomePersona);
			//System.out.println(listProdotti.toString());
			request.setAttribute("listaClienti", listClienti);
			int nome;
			for(int i=0;i<listClienti.size();i++)
			{
				if(listClienti.get(i).getNomePersona().equalsIgnoreCase(nomePersona));
				{
					nome=listClienti.get(i).getIdCliente();
					listLavori.add(DatabaseQuary.cercaLavoro(nome));
					System.out.println(nome);
				}
			}
			System.out.println(listClienti);
			System.out.println(listLavori);
			request.setAttribute("listaLavori", listLavori);
			if(listClienti.toString() == "[]"){
				request.setAttribute("vis", "nulla");
			} else{
				request.setAttribute("vis", "visible");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
			request.getRequestDispatcher("Risultato.jsp").forward(request, response);

		return;
}	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
