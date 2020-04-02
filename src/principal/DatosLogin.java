package principal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

//SDK de SAP para JAVA.
//Esto va a permitir utilizar funcionalidades de SAP Cloud platform para el desarrollo de aplicaciones.
import com.sap.security.auth.login.LoginContextFactory;
/**
 * Servlet implementation class DatosLogin
 */
@WebServlet("/DatosLogin")
public class DatosLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatosLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtener usuario remoto
		String user = request.getRemoteUser();
		
		//Validar si el usuario es diferente de Nulo
		if(user != null){
			response.getWriter().println("Hola usuario: "+user);
		}else {
			//Si el usuario es nulo, procedemos a crear un nuevo contexto de Login
			//Para pintar el formulario de autenticacion.
			LoginContext loginContext;
			try {
				loginContext = LoginContextFactory.createLoginContext("FORM");
				loginContext.login();
				response.getWriter().println("Hola usuario: "+request.getRemoteUser());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
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
