package project.ttsmessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class ContactService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMessage(Contact contact) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("message.trackini@gmail.com");
        msg.setSubject("Message de la part de " + contact.getNomprenom());
        msg.setText("Nom et prénom : " + contact.getNomprenom() + "\n" +
                "Email : " + contact.getEmail() + "\n" +
                "Message : " + contact.getMessage() + "\n");

        try {
            javaMailSender.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

