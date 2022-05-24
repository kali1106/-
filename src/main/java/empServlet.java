import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class empServlet
 */
@WebServlet("/emp")
public class empServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		empDAO dao = new empDAO();
		ArrayList<empVO> list = dao.listMember();
		
		out.print("<html><head><title>Result from emp</title></head><bodt>");
		out.print("<table border=1><tr><th>employee_id</th><th>emp_name</th><th>namager_id</th><th>department_id</th><th>°¹¼ö</th></tr>"); //head line
		for(int i=0; i<list.size(); i++) {
			empVO mvo = list.get(i);
			int eid = mvo.getEmployee_id();
	         String emp_name = mvo.getEmp_name();
	         String m_name = mvo.getManager_name();
	         String d_name = mvo.getDepartment_name();
			
			 out.print("<tr><td>"+eid+"</td><td>"+emp_name+"</td><td>"+m_name+"</td><td>"+d_name+"</td><td>"+(i+1)+"</td></tr>");
		}
		out.print("</tabla></bodt></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
