import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:flappybird.db";

    public static void connect() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
               String createTable = "CREATE TABLE IF NOT EXISTS scores (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "name TEXT, " +                     // ✅ Add name
                     "score INTEGER)";

                Statement stmt = conn.createStatement();
                stmt.execute(createTable);
                System.out.println("Connected to DB and table created.");
            }
        } catch (SQLException e) {
            System.out.println("Connect error: " + e.getMessage());
        }
    }

  public static void saveScore(String name, int score) {
    String sql = "INSERT INTO scores(name, score) VALUES(?, ?)";
    try (Connection conn = DriverManager.getConnection(DB_URL);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, name);
        pstmt.setInt(2, score);
        pstmt.executeUpdate();
        System.out.println("Saved: " + name + " - " + score);
    } catch (SQLException e) {
        System.out.println("Save error: " + e.getMessage());
    }
}

}
