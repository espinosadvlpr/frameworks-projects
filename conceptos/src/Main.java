import uptc.fr.model.AuthorEntity;
import uptc.fr.model.MessageEntity;

import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MessageEntity mensaje1 = new MessageEntity();
        mensaje1.setId(123);
        System.out.println(mensaje1.getId());
        MessageEntity mensaje2 = new MessageEntity(123, 100, "Hola", new Date());
        System.out.println(mensaje2);

        AuthorEntity authorEntity = new AuthorEntity(201, "Carlos", "a@a.com");
        System.out.println(authorEntity);
    }
}