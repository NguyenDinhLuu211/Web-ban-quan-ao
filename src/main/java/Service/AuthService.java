package Service;

import DB.DBConnection;
import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class AuthService {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conn = null;
    private DBConnection dbConnection = new DBConnection();

    public User findUser(String username, String email){
        User user = new User();
        String query = "select * from user where username=? or email=?";
        try {
            conn = dbConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            if (rs.next()){
                user.setId(rs.getInt("id"));
                return user;
            }
            //
            rs.close();
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void register(String username, String email, String password) {
        String query = "insert into user(username, email, password, " +
                "is_admin, is__active, created_at) " +
                "values (?,?,?, ?, ?, ?)";
        try {
            conn = dbConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setInt(4, 1);
            ps.setInt(5, 1);
            ps.setString(6, String.valueOf(LocalDateTime.now()));
            ps.executeUpdate();
            //
            ps.close();
            conn.close();
            System.out.println("Account register success");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public User login(String username, String password){
        User user = new User();
        String query = "select * from user where username=? or password=?";
        try {
            conn = dbConnection.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()){
                user.setId(rs.getInt("id"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setIsActive(rs.getInt("is__active"));
                user.setIsAdmin(rs.getInt("is_admin"));
                user.setPhone(rs.getString("phone"));
                user.setCreatedAt(rs.getString("created_at"));
                user.setFullName(rs.getString("full_name"));
                return user;
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new AuthService().findUser("vikang", "vk0808@gmail.com") == null);
//        new AuthService().register("vikang", "vik@gmail.com", "1111");
        System.out.println(new AuthService().login("vikang", "1111"));
    }
}
