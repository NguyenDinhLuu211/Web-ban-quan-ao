package DAO;

import DB.DatabaseConnector;
import Model.Bill;
import Model.Product;
import Service.MD5Hash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDao {
    public static boolean addDB(int iduser, int idinfo, double total) {
        Connection connection = null;

        try {

            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO bill (id_user, id_info, `date`, total, status ) VALUES (?, ?, NOW(),?,0)");
            ps.setInt(1, iduser);
            ps.setInt(2, idinfo);
            ps.setDouble(3, total);


            int i = ps.executeUpdate();

            return i > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnector.closeConnection(connection);
        }
    }

    public static int getNewIDBill() {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT id FROM bill order by id desc limit 1");


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0;
    }

    public static List<Bill> RecentBill(int id_user) {
        Connection connection = null;
        List<Bill> bills = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from bill where status = 0 and id_user=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1,   id_user );
                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Bill bill = new Bill();
                        bill.setId(rs.getInt("id"));
                        bill.setId_user(rs.getInt("id_user"));
                        bill.setId_info(rs.getInt("id_info"));
                        bill.setDate(rs.getDate("date"));
                        bill.setTotal(rs.getDouble("total"));
                        bill.setStatus(rs.getInt("status"));
                        bills.add(bill);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return bills;
    }

    public static List<Bill> RecentBill() {
        Connection connection = null;
        List<Bill> bills = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from bill where status = 0";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Bill bill = new Bill();
                        bill.setId(rs.getInt("id"));
                        bill.setId_user(rs.getInt("id_user"));
                        bill.setId_info(rs.getInt("id_info"));
                        bill.setDate(rs.getDate("date"));
                        bill.setTotal(rs.getDouble("total"));
                        bill.setStatus(rs.getInt("status"));
                        bills.add(bill);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return bills;
    }
    public static List<Bill> RecentBillLimit() {
        Connection connection = null;
        List<Bill> bills = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from bill where status = 0 limit 5";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Bill bill = new Bill();
                        bill.setId(rs.getInt("id"));
                        bill.setId_user(rs.getInt("id_user"));
                        bill.setId_info(rs.getInt("id_info"));
                        bill.setDate(rs.getDate("date"));
                        bill.setTotal(rs.getDouble("total"));
                        bill.setStatus(rs.getInt("status"));
                        bills.add(bill);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return bills;
    }

    public static List<Bill> ConfirmBill(int id_user) {
        Connection connection = null;
        List<Bill> bills = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from bill where status = 1 and id_user=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1,   id_user );
                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Bill bill = new Bill();
                        bill.setId(rs.getInt("id"));
                        bill.setId_user(rs.getInt("id_user"));
                        bill.setId_info(rs.getInt("id_info"));
                        bill.setDate(rs.getDate("date"));
                        bill.setTotal(rs.getDouble("total"));
                        bill.setStatus(rs.getInt("status"));
                        bills.add(bill);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return bills;
    }

    public static List<Bill> ConfirmBill() {
        Connection connection = null;
        List<Bill> bills = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from bill where status = 1 ";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Bill bill = new Bill();
                        bill.setId(rs.getInt("id"));
                        bill.setId_user(rs.getInt("id_user"));
                        bill.setId_info(rs.getInt("id_info"));
                        bill.setDate(rs.getDate("date"));
                        bill.setTotal(rs.getDouble("total"));
                        bill.setStatus(rs.getInt("status"));
                        bills.add(bill);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return bills;
    }

    public static List<Bill> ShipBill(int id_user) {
        Connection connection = null;
        List<Bill> bills = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from bill where status = 2 and id_user=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1,   id_user );
                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Bill bill = new Bill();
                        bill.setId(rs.getInt("id"));
                        bill.setId_user(rs.getInt("id_user"));
                        bill.setId_info(rs.getInt("id_info"));
                        bill.setDate(rs.getDate("date"));
                        bill.setTotal(rs.getDouble("total"));
                        bill.setStatus(rs.getInt("status"));
                        bills.add(bill);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return bills;
    }

    public static List<Bill> ShipBill() {
        Connection connection = null;
        List<Bill> bills = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from bill where status = 2";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Bill bill = new Bill();
                        bill.setId(rs.getInt("id"));
                        bill.setId_user(rs.getInt("id_user"));
                        bill.setId_info(rs.getInt("id_info"));
                        bill.setDate(rs.getDate("date"));
                        bill.setTotal(rs.getDouble("total"));
                        bill.setStatus(rs.getInt("status"));
                        bills.add(bill);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return bills;
    }

    public static List<Bill> DeliveredBill(int id_user) {
        Connection connection = null;
        List<Bill> bills = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from bill where status = 3 and id_user=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1,   id_user );
                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Bill bill = new Bill();
                        bill.setId(rs.getInt("id"));
                        bill.setId_user(rs.getInt("id_user"));
                        bill.setId_info(rs.getInt("id_info"));
                        bill.setDate(rs.getDate("date"));
                        bill.setTotal(rs.getDouble("total"));
                        bill.setStatus(rs.getInt("status"));
                        bills.add(bill);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return bills;
    }

    public static List<Bill> DeliveredBill() {
        Connection connection = null;
        List<Bill> bills = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from bill where status = 3";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Bill bill = new Bill();
                        bill.setId(rs.getInt("id"));
                        bill.setId_user(rs.getInt("id_user"));
                        bill.setId_info(rs.getInt("id_info"));
                        bill.setDate(rs.getDate("date"));
                        bill.setTotal(rs.getDouble("total"));
                        bill.setStatus(rs.getInt("status"));
                        bills.add(bill);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return bills;
    }

    public static List<Bill> CancelBill(int id_user) {
        Connection connection = null;
        List<Bill> bills = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from bill where status = 4 and id_user=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1,   id_user );
                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Bill bill = new Bill();
                        bill.setId(rs.getInt("id"));
                        bill.setId_user(rs.getInt("id_user"));
                        bill.setId_info(rs.getInt("id_info"));
                        bill.setDate(rs.getDate("date"));
                        bill.setTotal(rs.getDouble("total"));
                        bill.setStatus(rs.getInt("status"));
                        bills.add(bill);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return bills;
    }

    public static List<Bill> CancelBill() {
        Connection connection = null;
        List<Bill> bills = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from bill where status = 4 ";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                try (ResultSet rs = statement.executeQuery()) {




                    while (rs.next()) {
                        Bill bill = new Bill();
                        bill.setId(rs.getInt("id"));
                        bill.setId_user(rs.getInt("id_user"));
                        bill.setId_info(rs.getInt("id_info"));
                        bill.setDate(rs.getDate("date"));
                        bill.setTotal(rs.getDouble("total"));
                        bill.setStatus(rs.getInt("status"));
                        bills.add(bill);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return bills;
    }

    public static boolean cancel(int idbill) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE bill SET status=4 where id =?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, idbill);



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

    public static boolean confirm(int idbill) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE bill SET status=1 where id =?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, idbill);



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

    public static boolean ship(int idbill) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE bill SET status=2 where id =?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, idbill);



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

    public static boolean delivered(int idbill) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE bill SET status=3 where id =?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, idbill);



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

    public static int totalBill() {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT count(*) as `count` FROM bill where datediff(date(now()),date)<=30");


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0;
    }

    public static int totalBillCancel() {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT count(*) as `count` FROM bill where `status`=4 and datediff(date(now()),date)<=30");


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0;
    }

    public static int totalProductSoldOut() {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT count(*) as `count` FROM products where amount_storage=0");


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0;
    }

    public static int totalIncome() {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT sum(total) as `sum` FROM bill where `status` =3 and DATEDIFF(Date(NOW()), date) <= 30");


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("sum");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0;
    }




    public static void main(String[] args) {
        System.out.println(totalBill());
    }



}
