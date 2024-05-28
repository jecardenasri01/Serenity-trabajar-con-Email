package serenity;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
public class Task_EnviarCorreo implements Task {
    public static String correo;
    public static String clave;
    public static String asunto;
    public static String cuerpoCorreo;
    @Override
    public <T extends Actor> void performAs(T actor) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(correo, clave);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            //destinatario
            message.setFrom(new InternetAddress(correo));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
            message.setSubject(asunto);
            message.setText(cuerpoCorreo);

            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    public Task_EnviarCorreo(String correo,String clave,String asunto,String cuerpoCorreo) {
        this.correo = correo;
        this.clave = clave;
        this.asunto = asunto;
        this.cuerpoCorreo = cuerpoCorreo;
    }
    public static Task_EnviarCorreo withRobotUser(String correo,String clave,String asunto,String cuerpoCorreo) {
        return new Task_EnviarCorreo(correo, clave, asunto, cuerpoCorreo);
    }
}
