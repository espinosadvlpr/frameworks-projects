package uptc.fr;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import uptc.fr.conf.DynamicReader;
import uptc.fr.model.AuthorEntity;
import uptc.fr.model.MessageEntity;

public class MainDynamicReader {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, SQLException {
        List<MessageEntity> list = MessageReader();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).print());
        }
        List<AuthorEntity> list2 = AuthorReader();
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i).print());
        }
    }

    private static List<MessageEntity> MessageReader()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
        DynamicReader<MessageEntity> reader = new DynamicReader<>();
        return reader.findAll(MessageEntity.class);
    }

    private static List<AuthorEntity> AuthorReader()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
        DynamicReader<AuthorEntity> reader = new DynamicReader<>();
        return reader.findAll(AuthorEntity.class);
    }
}