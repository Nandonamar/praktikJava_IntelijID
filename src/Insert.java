
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Insert {

        private static final String Driver = "com.mysql.cj.jdbc.Driver";
        private static final String URL = "jdbc:mysql://localhost:3306/mahasiswa";
        private static final String user = "root";
        private static final String password = "";

        public static void main(String[] args) {
                try {
                        insertTable();
                } catch (SQLException ex) {
                        ex.printStackTrace();
                }
        }

        public static void insertTable() throws SQLException {
                Connection connection = null;
                Statement statement = null;
                int count = 0;

                String insertTableSQL = "insert into profil_mahasiswa"
                        + "(id_mhs, nama_mhs, nim, prodi)" + "values"
                        + "(null, 'Yeremias N.Fernando','181552018151675', 'Informatika'" + ")";

                try {
                        connection = getDatabaseConnection();
                        statement = connection.createStatement();
                        System.out.println(insertTableSQL);
                        statement.executeUpdate(insertTableSQL);
                        count = statement.getUpdateCount();
                        System.out.println(count +" Record telah berhasil di masukkan ke tabel profil_mahasiswa!");

                } catch (SQLException e) {
                        System.out.println(e.getMessage());
                } finally {
                        if (statement != null) {
                                statement.close();
                        }
                        if (connection != null) {
                                connection.close();
                        }
                }
        }

        public static Connection getDatabaseConnection() {
                Connection connection = null;
                try {
                        Class.forName(Driver);
                } catch (ClassNotFoundException e) {
                        System.out.println(e.getMessage());
                }
                try {

                        connection =
                                DriverManager.getConnection(URL, user, password);
                        return connection;
                } catch (SQLException e) {
                        System.out.println(e.getMessage());
                }
                return connection;
        }
}
