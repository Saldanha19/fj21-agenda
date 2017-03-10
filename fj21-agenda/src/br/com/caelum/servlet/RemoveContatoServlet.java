package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/removeContato")
public class RemoveContatoServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request
			,HttpServletResponse response)
			throws IOException,ServletException{
		
		//Busca o Writer
		PrintWriter out = response.getWriter();
		
		//buscando os parametros no request
		Long id = Long.parseLong(request.getParameter("id"));
		
		// monta um objeto contato
		Contato contato = new Contato();
		contato.setId(id);
		
		// salva o contato
		ContatoDao dao = new ContatoDao();
		dao.exclui(contato);
		
		//imprime o nome do contato que foi adicionado
		out.println("<html>");
		out.println("<body>");
		out.println("Contato: " + contato.getId() + " removido com sucesso");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
