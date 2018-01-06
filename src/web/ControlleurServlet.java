package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metire.dao.ClientImpDao;
import metire.dao.IClient;
import metire.entities.Client;

@WebServlet("/ControlleurServlet")
public class ControlleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IClient metier;

	public ControlleurServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		metier = new ClientImpDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClientModel model = new ClientModel();
		request.setAttribute("model", model);
		String action = request.getParameter("action");
		String mode = request.getParameter("mode");
		if (action != null) {
			if (action.equals("Chercher")) {

				model.setMotCle(request.getParameter("motCle"));
				List<Client> clients = metier.clientParmc(model.getMotCle());
				model.setClients(clients);

			} else if (action.equals("delete")) {

				String ref = request.getParameter("ref");
				metier.supprimerClient(ref);
				model.setClients(metier.allClient());
			} else if (action.equals("Save") && mode.equals("ajouter")) {

				try {
					model.getClient().setRef_prod(request.getParameter("refProduit"));
					model.getClient().setDesignation(request.getParameter("designation"));
					model.getClient().setPrix(Double.parseDouble(request.getParameter("prix")));
					model.getClient().setQuantite(Integer.parseInt(request.getParameter("quantite")));					
					metier.addClient(model.getClient());
					model.setClient(new Client());
					model.setClients(metier.allClient());
				} catch (Exception e) {
					model.setErreur(e.getMessage());
				}
			} else if (action.equals("editer")) {

				Client client = metier.getClient(request.getParameter("ref"));
				model.setClient(client);
				model.setMode("edit");
				model.setClients(metier.allClient());
			} else if (action.equals("Save") && mode.equals("edit")) {

				try {
					model.getClient().setRef_prod(request.getParameter("refProduit"));
					model.getClient().setDesignation(request.getParameter("designation"));
					model.getClient().setPrix(Double.parseDouble(request.getParameter("prix")));
					model.getClient().setQuantite(Integer.parseInt(request.getParameter("quantite")));
					metier.updateClient(model.getClient());
					model.setClient(new Client());
					model.setClients(metier.allClient());
				} catch (Exception e) {
					model.setErreur(e.getMessage());
				}
			}
		}

		request.getRequestDispatcher("VueClient.jsp").forward(request, response);

	}

}
