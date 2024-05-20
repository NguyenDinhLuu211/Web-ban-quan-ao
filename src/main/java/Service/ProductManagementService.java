package Service;

import DB.DBConnection;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ProductManagementService {
    private PreparedStatement ps;
    private ResultSet rs;
    private DBConnection dbConnection = new DBConnection();
    private Connection conn;

    // 9. Luu vao database
    public void addProduct(int categoryId, String name, String thumbnail
            , String content, double price, int colorId, int sizeId, int quantity) {
        String query = "insert into product(category_id, name, thumbnail" +
                ", content, price, discount, status, created_at, updated_at)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = dbConnection.getConnection();
            ps = conn.prepareStatement(query);
            //
            ps.setInt(1, categoryId);
            ps.setString(2, name);
            ps.setString(3, "http://localhost:8888/CNPM_Thu2_Ca1_Nhom10_war/images/" + thumbnail);
            ps.setString(4, content);
            ps.setDouble(5, price);
            ps.setDouble(6, 0);
            ps.setInt(7, 1);
            ps.setString(8, String.valueOf(LocalDateTime.now()));
            ps.setString(9, String.valueOf(LocalDateTime.now()));
            ps.executeUpdate();
            ps.close();

            //
            int productId = 0;
            String queryGetIdProduct = "select * from product order by id desc limit 1";
            ps = conn.prepareStatement(queryGetIdProduct);
            rs = ps.executeQuery();
            if (rs.next()) {
                productId = rs.getInt("id");
            }
            rs.close();
            ps.close();

            //
            String queryInsertColorSize = "insert into product_color_size(product_id, color_id, size_id" +
                    ", quantity, created_at) values (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(queryInsertColorSize);
            ps.setInt(1, productId);
            ps.setInt(2, colorId);
            ps.setInt(3, sizeId);
            ps.setInt(4, quantity);
            ps.setString(5, String.valueOf(LocalDateTime.now()));
            ps.executeUpdate();
            ps.close();
            conn.close();

            System.out.println("Add product success");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
