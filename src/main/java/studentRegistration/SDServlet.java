package studentRegistration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentRegistration.dao.StudentDao;

/**
 * Servlet implementation class SDServlet
 */
@WebServlet("/delete")
public class SDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDao studentDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SDServlet() {
        super();
        this.studentDao = new StudentDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//SLServlet
		
		RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("/WEB-INF/views/StudentDelete.jsp");
		requestDispatcher2.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double rollNo = Double.parseDouble(request.getParameter("rollNo"));
		boolean isDeleted = false;
		try {
			isDeleted =  studentDao.deleteStudent(rollNo);
		} catch (Exception e) {
			System.out.println("Exception while deleting Student: " +e.getMessage());
		}
		if(isDeleted) {
			request.setAttribute("status", "Successfully deleted entry for student!");
		}else {
			request.setAttribute("status", "Failure while deleting entry for student.");
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("list");
		requestDispatcher.forward(request, response);		
		
	}

}
