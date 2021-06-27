package studentRegistration;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentRegistration.dao.StudentDao;
import studentRegistration.model.Student;

/**
 * Servlet implementation class SLServlet
 */
@WebServlet("/list")
public class SLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLServlet() {
        super();
    	this.studentDao = new StudentDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Student> listOfStudent = null;
		try {			
			listOfStudent = studentDao.getAllStudent();
			for(Student student: listOfStudent) {
				response.getWriter().println(student.toString());
			}
		} catch (Exception e) {
			System.out.println("Exception while listing Student: " +e.getMessage());
		}
		request.setAttribute("styles", listOfStudent);
        
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/StudentDetails.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
