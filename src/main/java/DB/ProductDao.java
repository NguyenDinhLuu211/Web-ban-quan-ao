package Dao;

import DB.DatabaseConnector;
import Model.Product;
import Model.TypeProduct;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public static List<Product> getAllProduct() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from products";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setId_type(rs.getInt("id_type"));
                    product.setName(rs.getString("name"));
                    product.setDiscount(rs.getInt("discount"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDescribe(rs.getString("describe"));
                    product.setStatus((rs.getInt("status")));
                    product.setAmount_shop(rs.getInt("amount_shop"));
                    product.setAmount_storage(rs.getInt("amount_storage"));
                    product.setId_vendor(rs.getInt("id_vendor"));
                    product.setDate(rs.getString("date"));
                    product.setImport_price(rs.getDouble("import_price"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return products;
    }

    public static List<Product> getDiscountProduct() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from products where discount !=0 limit 8";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setId_type(rs.getInt("id_type"));
                    product.setName(rs.getString("name"));
                    product.setDiscount(rs.getInt("discount"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDescribe(rs.getString("describe"));
                    product.setStatus((rs.getInt("status")));
                    product.setAmount_shop(rs.getInt("amount_shop"));
                    product.setAmount_storage(rs.getInt("amount_storage"));
                    product.setId_vendor(rs.getInt("id_vendor"));
                    product.setDate(rs.getString("date"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi, giả sử username không tồn tại
        return products;
    }

    public static List<Product> getNewProduct() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from products where date >= DATE_SUB(CURRENT_DATE, INTERVAL 1 MONTH) ORDER BY date DESC limit 8";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setId_type(rs.getInt("id_type"));
                    product.setName(rs.getString("name"));
                    product.setDiscount(rs.getInt("discount"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDescribe(rs.getString("describe"));
                    product.setStatus((rs.getInt("status")));
                    product.setAmount_shop(rs.getInt("amount_shop"));
                    product.setAmount_storage(rs.getInt("amount_storage"));
                    product.setId_vendor(rs.getInt("id_vendor"));
                    product.setDate(rs.getString("date"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi, giả sử username không tồn tại
        return products;
    }



    public static List<Product> getAllDiscountProduct() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from products where discount !=0";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setId_type(rs.getInt("id_type"));
                    product.setName(rs.getString("name"));
                    product.setDiscount(rs.getInt("discount"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDescribe(rs.getString("describe"));
                    product.setStatus((rs.getInt("status")));
                    product.setAmount_shop(rs.getInt("amount_shop"));
                    product.setAmount_storage(rs.getInt("amount_storage"));
                    product.setId_vendor(rs.getInt("id_vendor"));
                    product.setDate(rs.getString("date"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi, giả sử username không tồn tại
        return products;
    }

    public static List<Product> getProductByCategory(int id_type) {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from products where id_type = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id_type);
                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Product product = new Product();
                        product.setId(rs.getInt("id"));
                        product.setId_type(rs.getInt("id_type"));
                        product.setName(rs.getString("name"));
                        product.setDiscount(rs.getInt("discount"));
                        product.setPrice(rs.getDouble("price"));
                        product.setDescribe(rs.getString("describe"));
                        product.setStatus((rs.getInt("status")));
                        product.setAmount_shop(rs.getInt("amount_shop"));
                        product.setAmount_storage(rs.getInt("amount_storage"));
                        product.setId_vendor(rs.getInt("id_vendor"));
                        product.setDate(rs.getString("date"));
                        products.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi, giả sử username không tồn tại
        return products;
    }

    public static List<Product> getProductByid(int id) {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from products where id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Product product = new Product();
                        product.setId(rs.getInt("id"));
                        product.setId_type(rs.getInt("id_type"));
                        product.setName(rs.getString("name"));
                        product.setDiscount(rs.getInt("discount"));
                        product.setPrice(rs.getDouble("price"));
                        product.setDescribe(rs.getString("describe"));
                        product.setStatus((rs.getInt("status")));
                        product.setAmount_shop(rs.getInt("amount_shop"));
                        product.setAmount_storage(rs.getInt("amount_storage"));
                        product.setId_vendor(rs.getInt("id_vendor"));
                        product.setDate(rs.getString("date"));
                        products.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi, giả sử username không tồn tại
        return products;
    }

    public static List<Product> SearchProduct(String searchTerm) {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from products where name like ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "%" + searchTerm + "%");
                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Product product = new Product();
                        product.setId(rs.getInt("id"));
                        product.setId_type(rs.getInt("id_type"));
                        product.setName(rs.getString("name"));
                        product.setDiscount(rs.getInt("discount"));
                        product.setPrice(rs.getDouble("price"));
                        product.setDescribe(rs.getString("describe"));
                        product.setStatus((rs.getInt("status")));
                        product.setAmount_shop(rs.getInt("amount_shop"));
                        product.setAmount_storage(rs.getInt("amount_storage"));
                        product.setId_vendor(rs.getInt("id_vendor"));
                        product.setDate(rs.getString("date"));
                        products.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi, giả sử username không tồn tại
        return products;
    }

    public static List<Product> FilterProduct(String sortingOption) {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "";
            switch (sortingOption) {
                case "lowtohigh":
                    sql = "SELECT * FROM products ORDER BY price ASC";
                    break;
                case "hightolow":
                    sql = "SELECT * FROM products ORDER BY price DESC";
                    break;
                case "atoz":
                    sql = "SELECT * FROM products ORDER BY name ASC";
                    break;
                case "ztoa":
                    sql = "SELECT * FROM products ORDER BY name DESC";
                    break;
            }
            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setId_type(rs.getInt("id_type"));
                    product.setName(rs.getString("name"));
                    product.setDiscount(rs.getInt("discount"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDescribe(rs.getString("describe"));
                    product.setStatus((rs.getInt("status")));
                    product.setAmount_shop(rs.getInt("amount_shop"));
                    product.setAmount_storage(rs.getInt("amount_storage"));
                    product.setId_vendor(rs.getInt("id_vendor"));
                    product.setDate(rs.getString("date"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi, giả sử username không tồn tại
        return products;
    }






    public static List<TypeProduct> getAllType() {
        Connection connection = null;
        List<TypeProduct> typeProducts = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from type_product";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    TypeProduct typeProduct = new TypeProduct();
                    typeProduct.setId(rs.getInt("id"));
                    typeProduct.setName(rs.getString("name"));

                    typeProducts.add(typeProduct);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi, giả sử username không tồn tại
        return typeProducts;
    }

    public static Product getProductById(int productID) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from products where id =?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1,productID);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setId_type(rs.getInt("id_type"));
                    product.setName(rs.getString("name"));
                    product.setDiscount(rs.getInt("discount"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDescribe(rs.getString("describe"));
                    product.setStatus((rs.getInt("status")));
                    product.setAmount_shop(rs.getInt("amount_shop"));
                    product.setAmount_storage(rs.getInt("amount_storage"));
                    product.setId_vendor(rs.getInt("id_vendor"));
                    product.setDate(rs.getString("date"));
                    return product;

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi, giả sử username không tồn tại
        return null;
    }



    private static void testGetAllProduct() {
        List<Product> products = ProductDao.getProductByid(1);

        // Kiểm tra xem danh sách sản phẩm có rỗng hay không
        if (products != null) {
            System.out.println("Danh sách sản phẩm:");
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("Có lỗi xảy ra khi lấy danh sách sản phẩm.");
        }
    }

    private static void testGetAllTypeProduct() {
        List<TypeProduct> products = ProductDao.getAllType();

        // Kiểm tra xem danh sách sản phẩm có rỗng hay không
        if (products != null) {
            System.out.println("Danh sách sản phẩm:");
            for (TypeProduct product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("Có lỗi xảy ra khi lấy danh sách sản phẩm.");
        }
    }

    public static String getImageUrl(int id) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT images.url FROM images join products on images.id_product = products.id WHERE products.id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("url");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public static int getIdType(int id_product) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("select id_type from products where id=?");
            ps.setInt(1, id_product);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_type");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0; // Trả về null nếu không tìm thấy
    }

    public static String getNameProduct(int id_product) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("select name from products where id =?");
            ps.setInt(1, id_product);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("name");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public static int getDiscount(int id_product) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("select discount from products where id =?");
            ps.setInt(1, id_product);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("discount");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0; // Trả về null nếu không tìm thấy
    }

    public static int getPrice(int id_product) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("select price from products where id =?");
            ps.setInt(1, id_product);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("price");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0; // Trả về null nếu không tìm thấy
    }

    public static int getAmountShop(int id_product) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("select amount_shop from products where id =?");
            ps.setInt(1, id_product);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("amount_shop");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0; // Trả về null nếu không tìm thấy
    }

    public static int getAmountStorage(int id_product) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("select amount_storage from products where id =?");
            ps.setInt(1, id_product);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("amount_storage");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0; // Trả về null nếu không tìm thấy
    }

    public static String getDescribe(int id_product) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("select `describe` from products where id =?");
            ps.setInt(1, id_product);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("describe");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return ""; // Trả về null nếu không tìm thấy
    }

    public static boolean updateProduct(int id_type, String name, int discount, int price, String describe, int id_product) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE products SET id_type=?, `name`=?, discount=?, price=?, `describe`=? WHERE id=? ";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, id_type);
                ps.setString(2, name);
                ps.setInt(3, discount);
                ps.setInt(4, price);
                ps.setString(5, describe);
                ps.setInt(6, id_product);

                int rowsAffected = ps.executeUpdate();

                // Kiểm tra xem có dòng nào được cập nhật không
                if (rowsAffected > 0) {
                    // Cập nhật thành công
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi hoặc không có dòng nào được cập nhật
        return false;
    }

    public static boolean updateIMGProduct(String url, int id_product) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE images SET url=? WHERE id_product=? ";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, url);
                ps.setInt(2, id_product);


                int rowsAffected = ps.executeUpdate();

                // Kiểm tra xem có dòng nào được cập nhật không
                if (rowsAffected > 0) {
                    // Cập nhật thành công
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi hoặc không có dòng nào được cập nhật
        return false;
    }

    public static boolean upAmountShop(int amount_up, int idP) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE products SET amount_shop=amount_shop+? WHERE id=? ";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1,amount_up);
                ps.setInt(2, idP);


                int rowsAffected = ps.executeUpdate();

                // Kiểm tra xem có dòng nào được cập nhật không
                if (rowsAffected > 0) {
                    // Cập nhật thành công
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi hoặc không có dòng nào được cập nhật
        return false;
    }

    public static boolean downAmountShop(int amount_up, int idP) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE products SET amount_shop=amount_shop-? WHERE id=? ";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1,amount_up);
                ps.setInt(2, idP);


                int rowsAffected = ps.executeUpdate();

                // Kiểm tra xem có dòng nào được cập nhật không
                if (rowsAffected > 0) {
                    // Cập nhật thành công
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi hoặc không có dòng nào được cập nhật
        return false;
    }


    public static boolean downAmountStorage(int amount_down, int idP) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE products SET amount_storage=amount_storage-? WHERE id=? ";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1,amount_down);
                ps.setInt(2, idP);


                int rowsAffected = ps.executeUpdate();

                // Kiểm tra xem có dòng nào được cập nhật không
                if (rowsAffected > 0) {
                    // Cập nhật thành công
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi hoặc không có dòng nào được cập nhật
        return false;
    }

    public static boolean upAmountStorage(int amount_down, int idP) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE products SET amount_storage=amount_storage+? WHERE id=? ";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1,amount_down);
                ps.setInt(2, idP);


                int rowsAffected = ps.executeUpdate();

                // Kiểm tra xem có dòng nào được cập nhật không
                if (rowsAffected > 0) {
                    // Cập nhật thành công
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi hoặc không có dòng nào được cập nhật
        return false;
    }
    public static int getID_vendor(int id_product) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("select id_vendor from products where id =?");
            ps.setInt(1, id_product);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_vendor");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0; // Trả về null nếu không tìm thấy
    }

    public static int getImport_price(int id_product) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("select import_price from products where id =?");
            ps.setInt(1, id_product);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("import_price");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0; // Trả về null nếu không tìm thấy
    }

    public static boolean deleteProduct( int idP) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "delete from products where id=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1,idP);



                int rowsAffected = ps.executeUpdate();

                // Kiểm tra xem có dòng nào được cập nhật không
                if (rowsAffected > 0) {
                    // Cập nhật thành công
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi hoặc không có dòng nào được cập nhật
        return false;
    }

    public static int getnewId() {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("select Max(id)+1 as new_id from products ");


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("new_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0; // Trả về null nếu không tìm thấy
    }

    public static boolean addProduct(int id_type, String name, int discount, int price, String describe, int amount_shop, int amount_storage, int id_vendor, int import_price) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "insert into products (id_type, `name`, discount, price, `describe`, status, amount_shop, amount_storage, id_vendor, `date`,import_price) values (?,?,?,?,?,1,?,?,?,NOW(),?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1,id_type);
                ps.setString(2, name);
                ps.setInt(3,discount);
                ps.setInt(4,price);
                ps.setString(5,describe);
                ps.setInt(6,amount_shop);
                ps.setInt(7,amount_storage);
                ps.setInt(8,id_vendor);
                ps.setInt(9,import_price);


                int rowsAffected = ps.executeUpdate();

                // Kiểm tra xem có dòng nào được cập nhật không
                if (rowsAffected > 0) {
                    // Cập nhật thành công
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi hoặc không có dòng nào được cập nhật
        return false;
    }

    public static boolean addIMGProduct(String url, int idP) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "insert into images (url, id_product) values (?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1,url);
                ps.setInt(2, idP);



                int rowsAffected = ps.executeUpdate();

                // Kiểm tra xem có dòng nào được cập nhật không
                if (rowsAffected > 0) {
                    // Cập nhật thành công
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi hoặc không có dòng nào được cập nhật
        return false;
    }
    public static boolean addType(String name) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "insert into type_product (name) values (?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1,name);




                int rowsAffected = ps.executeUpdate();

                // Kiểm tra xem có dòng nào được cập nhật không
                if (rowsAffected > 0) {
                    // Cập nhật thành công
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi hoặc không có dòng nào được cập nhật
        return false;
    }

    public static String getNameType(int id) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("select `name` from type_product where id =? ");
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("name");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public static boolean updateType(String name, int id) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE type_product SET name=? WHERE id=? ";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, name);
                ps.setInt(2, id);


                int rowsAffected = ps.executeUpdate();

                // Kiểm tra xem có dòng nào được cập nhật không
                if (rowsAffected > 0) {
                    // Cập nhật thành công
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi hoặc không có dòng nào được cập nhật
        return false;
    }

    public static boolean RemoveType(int id) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "delete from type_product where id =?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1,id);


                int rowsAffected = ps.executeUpdate();

                // Kiểm tra xem có dòng nào được cập nhật không
                if (rowsAffected > 0) {
                    // Cập nhật thành công
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }



        // Nếu có lỗi hoặc không có dòng nào được cập nhật
        return false;
    }

    public static List<Product> getHotSelect() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "select id_product from bill_detail JOIN bill ON bill_detail.id_bill = bill.id WHERE DATEDIFF(Date(NOW()),bill.date)<= 30 GROUP BY id_product HAVING sum(amount) > 5";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    products.add(getProductById(rs.getInt(1)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi, giả sử username không tồn tại
        return products;
    }







    public static void main(String[] args) {
        System.out.println(getNameType(1));;

    }

}
