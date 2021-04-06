package ParameterizedTests.model.locator;

public class EmailService implements MessagingService {

    public String getMessageBody() {
        return "email message";
    }

    public String getServiceName() {
        return "EmailService";
    }
}