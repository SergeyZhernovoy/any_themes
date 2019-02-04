package servlets;

import service_on_database.EmployeeService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeServlet extends HttpServlet {
    @EJB
    EmployeeService bean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("create")) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String salary = req.getParameter("salary");
            bean.create(Integer.parseInt(id), name, Long.parseLong(salary));
        }
    }
}
