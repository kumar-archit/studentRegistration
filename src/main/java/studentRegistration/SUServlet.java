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
 * Servlet implementation class SUServlet
 */
@WebServlet("/update")
public class SUServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDao studentDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SUServlet() {
        super();
        this.studentDao = new StudentDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/StudentUpdate.jsp");
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
		boolean isUpdated = false;
		try {
			isUpdated =  studentDao.updateStudent(student);
		} catch (Exception e) {
			System.out.println("Exception while updating Student: " +e.getMessage());
		}
		if(isUpdated) {
			request.setAttribute("status", "Successfully updated values for Student!");
		}else {
			request.setAttribute("status", "Failure while updating value for Student");
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("list");
		requestDispatcher.forward(request, response);		
		
	}

}
