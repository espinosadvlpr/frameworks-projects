package uptc.fr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uptc.fr.db.ConnectionManager;
import uptc.fr.model.AuthorEntity;

public class MainDb {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from author");
        AuthorEntity author;
        while (rs.next()) {
            author = new AuthorEntity();
            author.setId(rs.getLong("aut_id"));
            author.setNombre(rs.getString("aut_name"));
            author.setCorreo(rs.getString("aut_email"));
            System.out.println(author.print());
        }
        rs.close();
        st.close();
    }
}
