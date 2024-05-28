package Controller;

import Model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShoppingCart", value = "/ShoppingCart")
public class ShoppingCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            request.setAttribute("errorMessage", "Vui lòng đăng nhập để tiếp tục");
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        } else {
            request.setAttribute("user", user);
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
