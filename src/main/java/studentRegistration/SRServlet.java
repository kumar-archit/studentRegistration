package studentRegistration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentRegistration.dao.StudentDao;
import studentRegistration.model.Student;

/**
 * Servlet implementation class SRServlet
 */
@WebServlet("/add")
public class SRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
    /**
     * Default constructor. 
     */
    public SRServlet() {
    	this.studentDao = new StudentDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/StudentRegister.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rollNo = request.getParameter("rollNo");
		double marks = Double.parseDouble(request.getParameter("marks")) ;
		String Name = request.getParameter("Name");
		
		
		Student student = new Student();
		student.setName(Name);
		student.setRollNo(rollNo);
		student.setMarks(marks);
		boolean isRegistered = false;
		try {
			isRegistered =  studentDao.registerStudent(student);
		} catch (Exception e) {
			System.out.println("Exception while registering Student: " +e.getMessage());
		}
		if(isRegistered) {
			request.setAttribute("status", "Successfully registered student");
		}else {
			request.setAttribute("status", "Failure while registering student");
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("list");
		requestDispatcher.forward(request, response);		
	}

}
