package employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DelEmpServlet")
public class DelEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DelEmpServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String empId = request.getParameter("eid");
		String salary = request.getParameter("salary");
		System.out.println(empId + ", " + salary);
		
		EmpDAO dao = new EmpDAO();
		dao.deleteEmp(empId);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
