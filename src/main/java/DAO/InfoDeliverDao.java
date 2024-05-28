package DAO;

import DB.DatabaseConnector;
import Model.InfoDeliver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoDeliverDao {

    public static boolean addInfoDeliver(int iduser) {
        Connection connection = null;

        try {

            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO info_deliver (id_user, phone, province, district, ward, address, is_use ) VALUES (?, NULL, NULL,NULL,NULL,NULL,1)");
            ps.setInt(1,iduser );


            int i = ps.executeUpdate();

            return i > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnector.closeConnection(connection);
        }
    }

    public static boolean addInfoDeliver2(int iduser, String phone, String province, String district, String ward, String address) {
        Connection connection = null;

        try {

            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO info_deliver (id_user, phone, province, district, ward, address, is_use ) VALUES (?, ?, ?,?,?,?,0)");
            ps.setInt(1,iduser );
            ps.setString(2,phone );
            ps.setString(3,province );
            ps.setString(4,district );
            ps.setString(5,ward );
            ps.setString(6,address );



            int i = ps.executeUpdate();

            return i > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnector.closeConnection(connection);
        }
    }

    public static boolean updateInfoDeliver(String phone, String province, String district, String ward, String address,int id_user) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE info_deliver SET phone=?, province=?, district=?, ward=?, address=? WHERE id_user=? and is_use =1";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, phone);
                ps.setString(2, province);
                ps.setString(3, district);
                ps.setString(4, ward);
                ps.setString(5, address);
                ps.setInt(6, id_user);

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

    public static InfoDeliver getInfoDeliver(int id_user) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from info_deliver where id_user=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id_user);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    InfoDeliver infoDeliver = new InfoDeliver();
                    infoDeliver.setId(rs.getInt("id"));
                    infoDeliver.setId_user(rs.getInt("id_user"));
                    infoDeliver.setPhone(rs.getString("phone"));
                    infoDeliver.setProvince(rs.getString("province"));
                    infoDeliver.setDistrict(rs.getString("district"));
                    infoDeliver.setWard(rs.getString("ward"));
                    infoDeliver.setAddress(rs.getString("address"));
                    return infoDeliver;
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

    public static int getNewIDInfo() {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT id FROM info_deliver order by id desc limit 1");


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

    public static String getPhone(int id_user) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT phone FROM info_deliver WHERE id_user=? and is_use=1");
            ps.setInt(1, id_user);

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

    public static String getProvince(int id_user) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT province FROM info_deliver WHERE id_user=? and is_use =1");
            ps.setInt(1, id_user);

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

    public static String getDistrict(int id_user) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT district FROM info_deliver WHERE id_user=? and is_use =1");
            ps.setInt(1, id_user);

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

    public static String getWard(int id_user) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT ward FROM info_deliver WHERE id_user=? and is_use =1");
            ps.setInt(1, id_user);

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

    public static String getAddress(int id_user) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT address FROM info_deliver WHERE id_user=? and is_use =1");
            ps.setInt(1, id_user);

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




}
