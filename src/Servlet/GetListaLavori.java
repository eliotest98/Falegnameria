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
 * Servlet implementation class GetListaLavori
 */
@WebServlet("/GetListaLavori")
public class GetListaLavori extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetListaLavori() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Lavori> lista = new ArrayList<>();
		ArrayList<Cliente> lista2 = new ArrayList<>();
		try {
			
			lista=DatabaseQuary.getLavori();
			lista2 = DatabaseQuary.getClienti();
			System.out.println(lista);
			request.setAttribute("listaLavori", lista);
			request.setAttribute("listaClienti", lista2);
			request.getRequestDispatcher("Lavori.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
