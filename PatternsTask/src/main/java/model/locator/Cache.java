package model.locator;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private List<MessagingService> services = new ArrayList<>();

    public MessagingService getService(String serviceName) {
        for (MessagingService messagingService : services) {
            if (messagingService.getServiceName().equals(serviceName)) {
                return messagingService;
            }
        }
        return null;
    }

    public void addService(MessagingService newService) {
        services.add(newService);
    }
}
