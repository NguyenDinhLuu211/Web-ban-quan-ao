package Controller;

import Dao.ProductDao;
import Model.Cart;
import Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveItemCart", value = "/RemoveItemCart")
public class RemoveItemCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = ProductDao.getProductById(productId);

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        cart.removeItem(product);

        response.sendRedirect("CartShow");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
