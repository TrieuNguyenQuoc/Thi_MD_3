package controller;

import dao.StudenDao;
import modle.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentSeverlet", value = "/home")
public class StudentSeverlet extends HttpServlet {
    StudenDao studenDao;
    @Override
    public void init() {
        this.studenDao = new StudenDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice = request.getParameter("choice");
        if (choice == null) {
            choice = "";
        }
        switch (choice) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showUpdateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "search":
                showSearchResult(request, response);
            default:
                getStudentList(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice = request.getParameter("choice");
        if (choice == null) {
            choice = "";
        }
        switch (choice) {
            case "create":
                createNewStudent(request, response);
                getStudentList(request, response);
                break;
            case "edit":
                updateStudent(request, response);
                getStudentList(request, response);
                break;
            case "delete":
                delete(request, response);
                getStudentList(request, response);
                break;
            default:
                getStudentList(request, response);
                break;
        }
    }

    private void getStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Student> employeeList = studenDao.getAllStudent();
        request.setAttribute("studentList",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/home.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String sttuden = request.getParameter("id");
        request.setAttribute("id", sttuden);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String student = request.getParameter("id");
        request.setAttribute("id", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void createNewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = request.getIntHeader("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phone_number");
        String birth = request.getParameter("salary");
        int department_id = Integer.parseInt(request.getParameter("department_id"));
        Student student = new Student(id,name,email,address,phoneNumber,birth,department_id);
        studenDao.insertStudent(student);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("employee_id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phone_number");
        String birth = (request.getParameter("birth"));
        int casslroom = Integer.parseInt(request.getParameter("classroom"));
        Student studen = new Student(id,name,email,address,phoneNumber,birth,casslroom);
        studenDao.updateStudent(studen);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String studen_id = request.getParameter("studen_id");
        studenDao.deleteStudent(studen_id);
    }

    private void showSearchResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String searchKey = request.getParameter("searchKey");
        List<Student> resultStudentList = studenDao.searchStudent(searchKey);
        request.setAttribute("resultStuentList","resultStuentList");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/search_result.jsp");
        dispatcher.forward(request, response);
        List<Student> studentList = studenDao.searchStudent(searchKey);

    }

}
