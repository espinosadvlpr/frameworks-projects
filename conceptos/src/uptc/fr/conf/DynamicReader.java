package uptc.fr.conf;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uptc.fr.db.ConnectionManager;

public class DynamicReader<T> {

    public List<T> findAll(Class<T> tClass) throws SQLException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        List<T> result = new ArrayList<>();
        Entity entityRef = tClass.getAnnotation(Entity.class);
        String table = entityRef.table();
        Connection connection = ConnectionManager.getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from " + table);
        while (rs.next()) {
            T t = tClass.getDeclaredConstructor().newInstance();
            Field[] fields = tClass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                Column columnName = fields[i].getAnnotation(Column.class);
                if (fields[i].getType().equals(Long.class)) {
                    fields[i].set(t, rs.getLong(columnName.name()));
                } else if (fields[i].getType().equals(int.class)) {
                    fields[i].set(t, rs.getInt(columnName.name()));
                } else if (fields[i].getType().equals(Date.class)) {
                    fields[i].set(t, rs.getDate(columnName.name()));
                } else {
                    fields[i].set(t, rs.getString(columnName.name()));
                }
            }
            result.add(t);
        }
        return result;
    }
}