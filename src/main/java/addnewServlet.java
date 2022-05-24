

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addnewServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/addnew" })
public class addnewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addnewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userid=(String) session.getAttribute("userid");
		if(userid==null||userid.equals("")) {
			response.sendRedirect("login3.html");
			return;
		}
		MemberVO mvo = new MemberVO();
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("password"));
		mvo.setName(request.getParameter("name"));
		mvo.setMobile(request.getParameter("mobile"));
		mvo.setJoinDate(request.getParameter("joindate"));
		MemberDAO dao = new MemberDAO();
	      dao.addnewMember(mvo);
	      PrintWriter out = response.getWriter();
	      out.print("<html><script>document.location='http://localhost:8080/pro07/Member';</script></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
