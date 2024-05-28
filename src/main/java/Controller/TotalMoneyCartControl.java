package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cart;
import Model.CartItem;
import Model.Product;
import Model.User;
import Dao.DAO;

@WebServlet(name = "TotalMoneyCartControl", urlPatterns = { "/totalMoneyCart" })
public class TotalMoneyCartControl extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User a = (User) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login");
            return;
        }
        int accountID = a.getId();
        DAO dao = new DAO();
        List<Cart> cartList = dao.getCartByAccountID(accountID);
        List<Product> productList = dao.getAllProduct();
        
        double totalMoney = 0;
        for (Cart cart : cartList) {
            for (CartItem cartItem : cart.getItems()) { // Iterate over cart items
                for (Product product : productList) {
                    if (cartItem.getProduct().getId() == product.getId()) {
                        totalMoney += product.getPrice() * cartItem.getQuantity();
                    }
                }
            }
        }

        double totalMoneyVAT = totalMoney + totalMoney * 0.1;
        
        PrintWriter out = response.getWriter();
        out.println(" <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng tiền hàng</strong><strong>" + totalMoney + "</strong></li>\r\n"
                + " <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Phí vận chuyển</strong><strong>Free ship</strong></li>\r\n"
                + " <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">VAT</strong><strong>10 %</strong></li>\r\n"
                + " <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng thanh toán</strong>\r\n"
                + " <h5 class=\"font-weight-bold\">" + totalMoneyVAT + "</h5>\r\n"
                + " </li>");
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
