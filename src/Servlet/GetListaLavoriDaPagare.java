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
 * Servlet implementation class GetListaLavoriDaPagare
 */
@WebServlet("/GetListaLavoriDaPagare")
public class GetListaLavoriDaPagare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetListaLavoriDaPagare() {
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
			lista=DatabaseQuary.getLavoriByPagamento();
			for(int i=0;i<lista.size();i++)
			{
				Cliente a = null;
				a = DatabaseQuary.getClientiById(lista.get(i).getIdLavoro());
				lista2.add(a);
			}
			System.out.println(lista.toString());
			System.out.println(lista2.toString());
			request.setAttribute("listaLavori", lista);
			request.setAttribute("listaClienti", lista2);
			request.getRequestDispatcher("Pagamenti.jsp").forward(request, response);
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
