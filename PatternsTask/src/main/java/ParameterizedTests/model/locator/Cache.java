package ParameterizedTests.model.locator;

import java.util.Arrays;
import java.util.List;

public class Cache {

    private final List<MessagingService> services = Arrays.asList(new EmailService(), new SMSService());

    public MessagingService getService(String serviceName) {
        for (MessagingService messagingService : services) {
            if (messagingService.getServiceName().equals(serviceName)) {
                return messagingService;
            }
        }
        throw new NullPointerException();
    }

    public void addService(MessagingService newService) {
        services.add(newService);
    }
}
