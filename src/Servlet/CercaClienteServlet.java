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
import Database.DatabaseQuary;

/**
 * Servlet implementation class CercaClienteServlet
 */
@WebServlet("/CercaClienteServlet")
public class CercaClienteServlet extends HttpServlet {
	static ArrayList<Cliente>listClienti;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CercaClienteServlet() {
        super();
        listClienti = new ArrayList<Cliente>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomePersona = request.getParameter("nomeCliente");
		try{
			listClienti = DatabaseQuary.cercaPersona(nomePersona);
			request.setAttribute("listaClienti", listClienti);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("RisultatoCliente.jsp").forward(request, response);
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
