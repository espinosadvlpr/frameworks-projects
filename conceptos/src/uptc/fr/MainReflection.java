package uptc.fr;

import java.lang.reflect.Field;
import uptc.fr.model.AuthorEntity;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, SecurityException {
        AuthorEntity authorEntity = new AuthorEntity(201, "Carlos", "a@a.com");
        System.out.println(authorEntity.print());
        System.out.println(authorEntity);
        useReflection(authorEntity);
        System.out.println(authorEntity.print());
        System.out.println(authorEntity);
    }

    private static void useReflection(AuthorEntity author)
            throws IllegalAccessException, NoSuchFieldException, SecurityException {
        Field[] fields = AuthorEntity.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            System.out.println(fields[i].getName() + "\t" + fields[i].get(author));
        }
        Field name = AuthorEntity.class.getDeclaredField("nombre");
        name.setAccessible(true);
        name.set(author, "Juan");
    }
}
