package model.locator;

public class ServiceLocator {

    private static final Cache cache = new Cache();

    public static MessagingService getService(String serviceName) {

        MessagingService service = cache.getService(serviceName);

        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        MessagingService service1 = context.lookup(serviceName);
        cache.addService(service1);
        return service1;
    }
}