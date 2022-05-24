

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogingServlet
 */
@WebServlet("/Loging")
public class LogingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String userid=request.getParameter("userid");
		String password = request.getParameter("userpwd");
		MemberDAO dao= new MemberDAO();
		boolean result = dao.exist(userid,password);
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true);
			session.setAttribute("userid",userid);
			session.setAttribute("password", password);
			response.sendRedirect("Member");
		}
		else {
			response.sendRedirect("login3.html");
		}
		
	}

}
