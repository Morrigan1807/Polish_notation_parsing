package model.locator;

public class InitialContext {

    public MessagingService lookup(String serviceName) {
        if (serviceName.equalsIgnoreCase("EmailService")) {
            return new EmailService();
        } else if (serviceName.equalsIgnoreCase("SMSService")) {
            return new SMSService();
        }
        throw new NullPointerException();
    }
}
