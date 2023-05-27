package uptc.fr;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import uptc.fr.conf.DynamicReader;
import uptc.fr.model.AuthorEntity;

public class MainDynamicReader {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, SQLException {
        DynamicReader<AuthorEntity> reader = new DynamicReader<>();
        List<AuthorEntity> authorList = reader.findAll(AuthorEntity.class);
        for (int i = 0; i < authorList.size(); i++) {
            System.out.println(authorList.get(i).print());
        }
    }
}