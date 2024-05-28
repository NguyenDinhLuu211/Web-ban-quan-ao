package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        // Kiểm tra sản phẩm đã tồn tại trong giỏ hàng chưa
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                // Nếu đã tồn tại, tăng số lượng
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }

        // Nếu chưa tồn tại, thêm sản phẩm mới vào giỏ hàng với số lượng là 1
        CartItem newItem = new CartItem();
        newItem.setProduct(product);
        newItem.setQuantity(1);
        items.add(newItem);
    }

    public void updateCart(Product product, int num) {
        // Kiểm tra sản phẩm đã tồn tại trong giỏ hàng chưa
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                // Nếu đã tồn tại, cập nhật số lượng theo giá trị mới
                item.setQuantity(item.getQuantity() + num);
                return;
            }
        }

        // Nếu sản phẩm không tồn tại, bạn có thể thêm sản phẩm mới vào giỏ hàng ở đây
    }

    public void removeItem(Product product) {
        // Sử dụng Iterator để loại bỏ một sản phẩm trong khi duyệt qua danh sách
        Iterator<CartItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getProduct().getId() == product.getId()) {
                // Nếu tìm thấy sản phẩm, loại bỏ nó khỏi danh sách
                iterator.remove();
                return;
            }
        }
    }

    public void clearCart() {
        // Xóa tất cả sản phẩm trong giỏ hàng
        items.clear();
    }

    public int getTotalQuantity() {
        // Tính tổng số lượng sản phẩm trong giỏ hàng
        int totalQuantity = 0;
        for (CartItem item : items) {
            totalQuantity += item.getQuantity();
        }
        return totalQuantity;
    }


    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        // Tính tổng giá tiền của tất cả sản phẩm trong giỏ hàng
        double totalPrice = 0;
        for (CartItem item : items) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            double productPrice = product.getPrice(); // Giả sử có một phương thức getPrice() trong lớp Product
            totalPrice += productPrice * quantity;
        }
        return totalPrice;
    }


}
