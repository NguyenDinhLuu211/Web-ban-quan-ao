package Controller;

import java.io.IOException;
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
import Model.SoLuongDaBan;
import Model.TongChiTieuBanHang;
import Model.User;
import Model.Email;
import Model.EmailUtils;
import Dao.DAO;

@WebServlet(name = "OrderControl", urlPatterns = { "/order" })
public class OrderControl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			for (CartItem cartItem : cart.getItems()) {
				for (Product product : productList) {
					if (cartItem.getProduct().getId() == product.getId()) {
						totalMoney += product.getPrice() * cartItem.getQuantity();
					}
				}

			}
		}

		double totalMoneyVAT = totalMoney + totalMoney * 0.1;

		double tongTienBanHangThem;
		int sell_ID;
		for (Cart cart : cartList) {
			for (CartItem cartItem : cart.getItems()) {
				for (Product product : productList) {
					if (cartItem.getProduct().getId() == product.getId()) {
						tongTienBanHangThem = product.getPrice() * cartItem.getQuantity();
						sell_ID = dao.getSellIDByProductID(product.getId());
						TongChiTieuBanHang t2 = dao.checkTongChiTieuBanHangExist(sell_ID);
						if (t2 == null) {
							dao.insertTongChiTieuBanHang(sell_ID, 0, tongTienBanHangThem);
						} else {
							dao.editTongBanHang(sell_ID, tongTienBanHangThem);
						}
					}
				}
			}

		}

		for (Cart cart : cartList) {
			for (CartItem cartItem : cart.getItems()) {
				for (Product product : productList) {
					if (cartItem.getProduct().getId() == product.getId()) {
						SoLuongDaBan s = dao.checkSoLuongDaBanExist(product.getId());
						if (s == null) {
							dao.insertSoLuongDaBan(product.getId(), cartItem.getQuantity());
						} else {
							dao.editSoLuongDaBan(product.getId(), cartItem.getQuantity());
						}
					}
				}
			}

		}

		dao.insertInvoice(accountID, totalMoneyVAT);
		TongChiTieuBanHang t = dao.checkTongChiTieuBanHangExist(accountID);
		if (t == null) {
			dao.insertTongChiTieuBanHang(accountID, totalMoneyVAT, 0);
		} else {
			dao.editTongChiTieu(accountID, totalMoneyVAT);
		}

		request.getRequestDispatcher("DatHang.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String emailAddress = request.getParameter("email");
			String name = request.getParameter("name");
			String phoneNumber = request.getParameter("phoneNumber");
			String deliveryAddress = request.getParameter("deliveryAddress");

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
				for (CartItem cartItem : cart.getItems()) {
					for (Product product : productList) {
						if (cartItem.getProduct().getId() == product.getId()) {
							totalMoney += product.getPrice() * cartItem.getQuantity();
						}
					}
				}

			}
			double totalMoneyVAT = totalMoney + totalMoney * 0.1;

			Email email = new Email();
			email.setFrom("dngphm999@gmail.com");
			email.setFromPassword("0915589883");
			email.setTo(emailAddress);
			email.setSubject("Dat hang thanh cong tu Fashion Family");
			StringBuilder sb = new StringBuilder();
			sb.append("Dear ").append(name).append("<br>");
			sb.append("Ban vua dat dang tu Fashion Family. <br> ");
			sb.append("Dia chi nhan hang cua ban la: <b>").append(deliveryAddress).append(" </b> <br>");
			sb.append("So dien thoai khi nhan hang cua ban la: <b>").append(phoneNumber).append(" </b> <br>");
			sb.append("Cac san pham ban dat la: <br>");
			for (Cart cart : cartList) {
				for(CartItem cartItem : cart.getItems()) {
					for (Product product : productList) {
						if (cartItem.getProduct().getId() == product.getId()) {
							sb.append(product.getName()).append(" | ").append("Price:").append(product.getPrice())
									.append("$").append(" | ").append("Amount:").append(cartItem.getQuantity()).append("<br>");
						}
					}
				}
				
			}
			sb.append("Tong Tien: ").append(String.format("%.02f", totalMoneyVAT)).append("$").append("<br>");
			sb.append("Cam on ban da dat hang tai Fashion Family<br>");
			sb.append("Chu cua hang");

			email.setContent(sb.toString());
			EmailUtils.send(email);
			request.setAttribute("mess", "Dat hang thanh cong!");

			dao.deleteCartByAccountID(accountID);
		} catch (Exception e) {
			request.setAttribute("error", "Dat hang that bai!");
			e.printStackTrace();
		}

		request.getRequestDispatcher("DatHang.jsp").forward(request, response);
	}
}
