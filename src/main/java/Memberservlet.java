

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Memberservlet
 */
@WebServlet("/Member")
public class Memberservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Memberservlet() {
        super();
        
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
		
		response.setContentType("text/html; charset=utf-8");//출력에 한글이 깨지지 않게.
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.listMember();
		
		out.print("<html><head><title>Result from t_member</title></head><bodt>");
		out.print("<table border=1><tr><th>ID</th><th>비밀번호</th><th>이름</th><th>모바일</th><th>등록일</th></tr>"); //head line
		for(int i=0; i<list.size(); i++) {
			MemberVO mvo = list.get(i);
			 out.print("<tr><td>"+mvo.getId()+"</td><td>"+mvo.getPwd()+"</td><td>"+mvo.getName()+"</td><td>"
			+mvo.getMobile()+"</td><td>"+mvo.getJoinDate()+"</td><td><a href='update?id="+mvo.getId()+"'>수정</a>&nbsp;"+"<a href='delete?id="+mvo.getId()+"'>삭제</a></td></tr>");
		}
		out.print("</tabla><a href='addnew.html'>추가</a></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
