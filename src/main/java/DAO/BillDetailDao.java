package DAO;

import DB.DatabaseConnector;
import Model.Bill;
import Model.BillDetail;
import Model.CartItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDetailDao {
    public static void addDB(List<CartItem> cartItems,int id_bill) {
        Connection connection = null;

        try {

            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO bill_detail (id_bill, id_product, amount, price ) VALUES (?, ?, ?,?)");
            for (CartItem cd : cartItems){
                ps.setInt(1, id_bill);
                ps.setInt(2, cd.getProduct().getId());
                ps.setDouble(3, cd.getQuantity());
                ps.setDouble(4, cd.getProduct().getPrice());
                ps.executeUpdate();
                ProductDao.downAmountShop(cd.getQuantity(), cd.getProduct().getId());
            }









        } catch (SQLException e) {
            e.printStackTrace();


        } finally {
            DatabaseConnector.closeConnection(connection);
        }
    }

    public static List<BillDetail> getBillDetail(int id_bill) {
        Connection connection = null;
        List<BillDetail> billDetails = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from bill_detail where id_bill = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1,   id_bill );
                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        BillDetail billDetail = new BillDetail();
                        billDetail.setId_bill(rs.getInt("id_bill"));
                        billDetail.setId_product(rs.getInt("id_product"));
                        billDetail.setAmount(rs.getInt("amount"));
                        billDetail.setPrice(rs.getDouble("price"));
                        billDetails.add(billDetail);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return billDetails;
    }

    public static String getNameProduct(int id_product) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT products.name FROM products join bill_detail on bill_detail.id_product = products.id WHERE bill_detail.id_product=?");
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

    public static int getstatusBill(int id_bill) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT status FROM bill WHERE id=?");
            ps.setInt(1, id_bill);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("status");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0;
    }

    public static int getIdInfo(int id_bill) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT bill.id_info FROM bill join bill_detail on bill.id = bill_detail.id_bill WHERE bill_detail.id_bill=?");
            ps.setInt(1, id_bill);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_info");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0; // Trả về null nếu không tìm thấy
    }

    public static int getIDUser(int id_bill) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT bill.id_user FROM bill join bill_detail on bill.id = bill_detail.id_bill WHERE bill_detail.id_bill=?");
            ps.setInt(1, id_bill);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_user");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0; // Trả về null nếu không tìm thấy
    }

    public static String getNameUser(int id_user) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT name FROM user WHERE id=?");
            ps.setInt(1, id_user);

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

    public static String getPhone(int id_info) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT phone FROM info_deliver WHERE id=?");
            ps.setInt(1, id_info);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("phone");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public static Date getDate(int id_bill) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT date FROM bill WHERE id=?");
            ps.setInt(1, id_bill);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDate("date");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public static String getAddress(int id_info) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT address FROM info_deliver WHERE id=?");
            ps.setInt(1, id_info);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("address");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public static String getWard(int id_info) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT ward FROM info_deliver WHERE id=?");
            ps.setInt(1, id_info);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("ward");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public static String getDistrict(int id_info) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT district FROM info_deliver WHERE id=?");
            ps.setInt(1, id_info);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("district");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public static String getProvince(int id_info) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT province FROM info_deliver WHERE id=?");
            ps.setInt(1, id_info);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("province");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public static double getgrandTotal(int id_bill) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT total FROM bill WHERE id=?");
            ps.setInt(1, id_bill);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0; // Trả về null nếu không tìm thấy
    }

    public static void main(String[] args) {
        System.out.println(getProvince(27));
    }
}
