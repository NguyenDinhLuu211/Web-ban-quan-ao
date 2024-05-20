package Controller;

import Service.ProductManagementService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddProductController", value = "/admin/doc/AddProductController")
public class AddProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // 7. Xu li du lieu
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String color = request.getParameter("color");
        String size = request.getParameter("size");
        String quantity = request.getParameter("quantity");
        String price = request.getParameter("price");
        String thumbnail = request.getParameter("ImageUpload");
        String content = request.getParameter("mota");
        if (name.isEmpty() || category.isEmpty() || color.isEmpty() || quantity.isEmpty()
                || size.isEmpty() || price.isEmpty() || thumbnail.isEmpty() || content.isEmpty()) {
            request.getRequestDispatcher("form-add-product.jsp").forward(request, response);
        } else {
            int categoryParsed = Integer.parseInt(category);
            int colorParsed = Integer.parseInt(color);
            int sizeParsed = Integer.parseInt(size);
            int quantityParsed = Integer.parseInt(quantity);
            double priceParsed = Double.parseDouble(price);
            ProductManagementService service = new ProductManagementService();
            // 8. Gui thong tin den service
            service.addProduct(categoryParsed, name, thumbnail, content, priceParsed,
                    colorParsed, sizeParsed, quantityParsed);
            // 10. Quay lai trang
            response.sendRedirect("table-data-product.jsp");
        }
    }
}