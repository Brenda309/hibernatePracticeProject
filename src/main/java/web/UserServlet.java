package web;

import dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class UserServlet  extends HttpServlet {
    //    private static final long serialVersionUID = 1 L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewFrom(request, response);
                    break;

                    case "/insert":
                        insertUser(request, response);
                        break;
                case "/delete":
                    deleteUser(request, response);
                    break;

                case "/edit":
                   showEditFrom(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;

                default:
                   listUser(request, response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }

    protected void listUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
    List<User> listUser = userDao.getAllUser();
    request.setAttribute("ListUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request,response);
    }
    protected void showNewFrom (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
       RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
       dispatcher.forward(request, response);
    }

}