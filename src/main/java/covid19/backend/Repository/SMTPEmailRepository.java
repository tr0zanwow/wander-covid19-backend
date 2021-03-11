package covid19.backend.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.thymeleaf.context.Context;
import org.thymeleaf.exceptions.TemplateInputException;
import org.thymeleaf.spring5.SpringTemplateEngine;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Repository
public class SMTPEmailRepository {
    Logger logger = LoggerFactory.getLogger(SMTPEmailRepository.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    SpringTemplateEngine thymeleafTemplateEngine;

    public void sendMail(String emailId, String tokenUrl) throws MessagingException, TemplateInputException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom("Wander Covid19 <contact@pranilrathod.dev>");
        helper.setTo(emailId);
        helper.setSubject("Wander | Covid 19 Tracker - Email Verification");
        Context thymeleafContext = new Context();
        thymeleafContext.setVariable("tokenUrl", tokenUrl);
        String htmlBody = thymeleafTemplateEngine.process("email_verification_template.html", thymeleafContext);
        helper.setText(htmlBody, true);
        logger.info(htmlBody);
        mailSender.send(message);
    }
}
