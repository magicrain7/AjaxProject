package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetEmpServlet
 */
@WebServlet({ "/GetEmpServlet", "/GetEmpListServlet" })
public class GetEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetEmpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("list")) {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
//			response.getWriter().append("Served at: ").append(request.getContextPath());
			PrintWriter out = response.getWriter();
			// hr.employee(employee_id, first_name, email, salary)
//			out.write("[{\"id\":\"user1\", \"first_name\":\"Hong\",\"age\":\"30\"},");
//			out.write("{\"id\":\"user2\", \"first_name\":\"Park\",\"age\":\"20\"}]");
			EmpDAO dao = new EmpDAO();
			List<Employee> list = dao.getEmpList();
			int cnt = 0;
			int rowCnt = list.size();
			out.write("[");
			for(Employee emp : list) {
				// {"id":"data1","first_name":"data2","email":"data3":"salary":"data4"}
				out.write("{\"id\":\""+emp.getEmployeeId()+
						"\",\"first_name\":\""+emp.getFirstName()+
						"\",\"email\":\""+emp.getEmail()+
						"\",\"salary\":\""+emp.getSalary()+"\"}");
				if(++cnt != rowCnt)
					out.write(",");
			}
			out.write("]");
		}else if(action.equals("update")){
			String empId = request.getParameter("empId");
			String salary = request.getParameter("salary");
			
			EmpDAO dao = new EmpDAO();
			dao.updateEmp(empId, salary);
		}
		
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter out = response.getWriter();
//		// hr.employee(employee_id, first_name, email, salary)
////		out.write("[{\"id\":\"user1\", \"first_name\":\"Hong\",\"age\":\"30\"},");
////		out.write("{\"id\":\"user2\", \"first_name\":\"Park\",\"age\":\"20\"}]");
//		EmpDAO dao = new EmpDAO();
//		List<Employee> list = dao.getEmpList();
//		int cnt = 0;
//		int rowCnt = list.size();
//		out.write("[");
//		for(Employee emp : list) {
//			// {"id":"data1","first_name":"data2","email":"data3":"salary":"data4"}
//			out.write("{\"id\":\""+emp.getEmployeeId()+
//					"\",\"first_name\":\""+emp.getFirstName()+
//					"\",\"email\":\""+emp.getEmail()+
//					"\",\"salary\":\""+emp.getSalary()+"\"}");
//			if(++cnt != rowCnt)
//				out.write(",");
//		}
//		out.write("]");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
