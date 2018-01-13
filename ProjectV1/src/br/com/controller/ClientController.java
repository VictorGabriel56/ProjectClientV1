package br.com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.Client;
import br.com.service.ClientService;

/**
 * Servlet implementation class ClientRegister
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private ClientService service;
	
	public ClientController() {
		this.service = new ClientService();
	}

	
	private void listclient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Client> clients = this.service.list();
		request.setAttribute("clients",clients);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listClients.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("addClient.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		
		Client existClient = this.service.search(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addClient.jsp");
		request.setAttribute("client", existClient);
		dispatcher.forward(request, response);

	}

	private void saveClient(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
			
		String id = request.getParameter("id");
		
		if(id != null && !id.isEmpty()) {	
			Client client = this.service.search(Long.parseLong(id));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			client.setName(name);
			client.setEmail(email);			
			client.setId(Long.parseLong(id));
			this.service.update(client);
			request.setAttribute("cadastroSucesso","Cliente cadastrador com sucesso.");
			
			listclient(request, response);
			
		}
		
		if(id.isEmpty()) {
			
			Client newClient = new Client();
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			newClient.setName(name);
			newClient.setEmail(email);
			
			this.service.save(newClient);
			
			listclient(request, response);
		}
	}

	private void updateclient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		Client clientEdit = new Client();
		clientEdit.setId(id);
		clientEdit.setName(name);
		clientEdit.setEmail(email);
		
		this.service.update(clientEdit);
		listclient(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
		Long id = Long.parseLong(request.getParameter("id"));
		this.service.delete(id);
		listclient(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");

		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "save":
				saveClient(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateclient(request, response);
				break;
			default:
				listclient(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}	

}