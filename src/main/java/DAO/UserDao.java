package DAO;



import DB.DatabaseConnector;
import Model.Product;
import Model.User;
import Service.MD5Hash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static List<User> getAllUser() {
        Connection connection = null;
        List<User> users = new ArrayList<>();
        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from user";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setName(rs.getString("name"));
                    user.setRole(rs.getInt("role"));
                    user.setActivate(rs.getInt("activate"));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseConnector.closeConnection(connection);
        }


        return users;
    }



    public static boolean registerUser(String name, String username, String password, String email) {
        Connection connection = null;

        try {
            String password_hash = MD5Hash.hashPassword(password);
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO user (username, password, email, `name`, `role`, activate ) VALUES (?, ?, ?,?,2,0)");
            ps.setString(1, username);
            ps.setString(2, password_hash);
            ps.setString(3, email);
            ps.setString(4, name);

            int i = ps.executeUpdate();

            return i > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnector.closeConnection(connection);
        }
    }

    public static boolean addDB(String name, String username, String password, String email) {
        Connection connection = null;

        try {

            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO user (username, password, email, `name`, `role`, activate ) VALUES (?, ?, ?,?,2,0)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, name);

            int i = ps.executeUpdate();

            return i > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnector.closeConnection(connection);
        }
    }

    public static boolean addDB2(String name, String username, String password, String email, int role) {
        Connection connection = null;

        try {

            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO user (username, password, email, `name`, `role`, activate ) VALUES (?, ?, ?,?,?,1)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, name);
            ps.setInt(5, role);

            int i = ps.executeUpdate();

            return i > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnector.closeConnection(connection);
        }
    }


    public static boolean loginUser(String username, String password) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Hash mật khẩu trước khi so sánh với cơ sở dữ liệu
            String hashedPassword = MD5Hash.hashPassword(password);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, hashedPassword);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnector.closeConnection(connection);
        }
    }

    public static int getNewIDUser() {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT id FROM user order by id desc limit 1");


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

    public static String getUserName(String username) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT name FROM user WHERE username=?");
            ps.setString(1, username);

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



    public static int getiduser(String username) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT id FROM user WHERE username=?");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0; // Trả về null nếu không tìm thấy
    }

    public static String getPasswd(int iduser) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT password FROM user WHERE id=?");
            ps.setInt(1, iduser);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("password");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public static String getEmail(String username) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT email FROM user WHERE username=?");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("email");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public static boolean updateActivateAccount(String username) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE user SET activate=1 WHERE username=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, username);

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

    public static int getNotActivateAccount(String username) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT activate FROM user WHERE username=?");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("activate");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 3; // Trả về null nếu không tìm thấy
    }

    public static boolean isUsernameExists(String username) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT COUNT(*) AS count FROM user WHERE username=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int count = rs.getInt("count");

                    // Nếu count > 0, username đã tồn tại
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        // Nếu có lỗi, giả sử username không tồn tại
        return false;
    }

    public static User getUserInfo(String username) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * from user where username=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setName(rs.getString("name"));
                    user.setRole(rs.getInt("role"));
                    user.setActivate(rs.getInt("activate"));
                    return user;
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

    public static boolean changePassword(String password ,int iduser) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE user SET password=? WHERE id=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, password);
                ps.setInt(2, iduser);

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

    public static boolean changePassword(String password ,String username) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE user SET password=? WHERE username=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, password);
                ps.setString(2, username);

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
        return false;
    }

    public static boolean updateInfoUser(String name, String email, int iduser) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "UPDATE user SET `name`=?, email=? WHERE id=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, name);
                ps.setString(2, email);
                ps.setInt(3, iduser);


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

    public static int getNewiduserAdmin() {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT max(id) +1 as new_id FROM user");


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("new_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection(connection);
        }

        return 0;
    }

    public static boolean RemoveUser(int iduser) {
        Connection connection = null;

        try {
            connection = DatabaseConnector.getConnection();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "delete from user where id =?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1,iduser);


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

    public static void main(String[] args) {
        System.out.println(getNewiduserAdmin());
    }













}

