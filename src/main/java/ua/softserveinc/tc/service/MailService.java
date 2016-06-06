package ua.softserveinc.tc.service;

import ua.softserveinc.tc.entity.User;

/**
 * Created by Chak on 10.05.2016.
 */
public interface MailService {

    void sendMessage(String email, String subject, String text);

    void sendPaymentInfo(User user, String subject, Long sumTotal);

    void sendRegisterMessage(String subject, User user, String token);

    void sendChangePassword(String subject, User manager, String token);

    void buildConfirmRegisterManager(String subject, User user, String token);
}
