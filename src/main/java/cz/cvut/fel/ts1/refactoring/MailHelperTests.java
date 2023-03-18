package cz.cvut.fel.ts1.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MailHelperTests {
    private String to = "email@template.org";
    private String body = "Mail body";
    private String subject = "Mail subject";
    private boolean isSent = false;
    private MailHelper mailHelper;

    @BeforeEach
    public void SetMail() {
        mailHelper = new MailHelper();
        mailHelper.setMail(to, subject, body);
    }

    @Test
    public void setMail_setToHasCorrectValue_setCorrectValue() {
        Assertions.assertEquals(to, mailHelper.getMail().getTo());
    }

    @Test
    public void setMail_setSubjectHasCorrectValue_setCorrectValue() {
        Assertions.assertEquals(subject, mailHelper.getMail().getSubject());
    }

    @Test
    public void setMail_setBodyHasCorrectValue_setCorrectValue() {
        Assertions.assertEquals(body, mailHelper.getMail().getBody());
    }

    @Test
    public void setMail_setIsSent_false() {
        Assertions.assertEquals(to, mailHelper.getMail().isSent());
    }
}
