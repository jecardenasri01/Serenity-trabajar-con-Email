package serenity;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import javax.mail.*;
import java.io.IOException;
import java.util.*;

public class Task_LeerCorreo implements Task {

    public static String correo;
    public static String clave;
    @Override
    public <T extends Actor> void performAs(T actor) {

        Properties props = new Properties();
        props.put("mail.imap.host", "outlook.office365.com");
        props.put("mail.imap.port", "993");
        props.put("mail.imap.ssl.enable", "true");

        Session session = Session.getInstance(props);


        Store store = null;
        try {
            store = session.getStore("imap");

            store.connect("outlook.office365.com", correo, clave);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Obtener los mensajes
            Message[] messages = inbox.getMessages();

            // Obtener el correo electrónico más reciente
            Message latestMessage = messages[messages.length - 1];

            // Imprimir el contenido del correo electrónico más reciente


            actor.should("Subject "+latestMessage.getSubject());
            actor.should("From: " + Arrays.toString(latestMessage.getFrom()));
            actor.should("Content: " + latestMessage.getContent());

            inbox.close(false);
            store.close();
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Task_LeerCorreo(String correo,String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public static Task_LeerCorreo withRobotUser(String correo,String clave) {
        return new Task_LeerCorreo(correo, clave);
    }
}
