package forms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormsGetPost
 */
@WebServlet("/form-get-post")
public class FormGetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("fn");
		String lastName = request.getParameter("ln");
		String email = request.getParameter("e");
		
		if(firstName == null || firstName.trim().isEmpty()) {
			firstName = "";
		}
		
		if(lastName == null || lastName.trim().isEmpty()) {
			lastName = "";
		}
		
		if(email == null || email.trim().isEmpty()) {
			email = "";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<title>Form Get Post</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>Form</h1>"
				+ "<form method=\"post\">"
				+ "First name: <input name=\"first_name\" value=\""+firstName+"\"><br>"
				+ "Last name: <input name=\"last_name\" value=\""+lastName+"\"><br>"
				+ "Email: <input name=\"email\" value=\""+email+"\"><br>"
				+ "<input type=\"submit\">"
				+ "</form>"
				+ "</body>"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		
		boolean isMissingValue = false;
		
		if(firstName == null || firstName.trim().isEmpty()) {
			firstName = "Empty string";
			isMissingValue = true;
		}
		
		if(lastName == null || lastName.trim().isEmpty()) {
			lastName = "Empty string";
			isMissingValue = true;
		}
		
		if(email == null || email.trim().isEmpty()) {
			email = "Empty string";
			isMissingValue = true;
		}
		
		if(isMissingValue) {
			response.sendRedirect("form-get-post?"
					+ "fn="+firstName+"&"
					+ "ln="+lastName+"&"
					+ "e="+email);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "<title>Form Get Post</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Result</h1>"
					+ "<ul>"
					+ "<li>First name: "+firstName+"</li>"
					+ "<li>Last name: "+lastName+"</li>"
					+ "<li>Email: "+email+"</li>"
					+ "</ul>"
					+ "</body>"
					+ "</html>");
		}
	}

}
