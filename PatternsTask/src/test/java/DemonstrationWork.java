import ParameterizedTests.model.builder.Person;
import ParameterizedTests.model.chainofresponsibility.EmailLogger;
import ParameterizedTests.model.chainofresponsibility.Logger;
import ParameterizedTests.model.chainofresponsibility.StderrLogger;
import ParameterizedTests.model.chainofresponsibility.StdoutLogger;
import ParameterizedTests.model.facade.Computer;
import ParameterizedTests.model.factory.animal.Animal;
import ParameterizedTests.model.factory.creator.Creator;
import ParameterizedTests.model.factory.creator.MouseCreator;
import ParameterizedTests.model.factory.creator.RaccoonCreator;
import ParameterizedTests.model.iterator.Iterator;
import ParameterizedTests.model.iterator.NameRepository;
import ParameterizedTests.model.locator.MessagingService;
import ParameterizedTests.model.locator.ServiceLocator;
import ParameterizedTests.model.singleton.Singleton;
import ParameterizedTests.model.strategy.Context;
import ParameterizedTests.model.strategy.calculator.AddStrategy;
import ParameterizedTests.model.strategy.calculator.MultiplyStrategy;
import ParameterizedTests.model.strategy.calculator.SubtractStrategy;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemonstrationWork {

    @Test
    public void testBuilder() {
        Person mother = new Person.Builder()
                .withName("Jane")
                .withSurname("Doe")
                .withAge(32)
                .withHeight(165)
                .withWeight(70)
                .build();

        Person father = new Person.Builder()
                .withName("Jhon")
                .withSurname("Smith")
                .withAge(30)
                .build();

        Set<Person> parents = new HashSet<>();
        parents.add(mother);
        parents.add(father);

        Person child = new Person.Builder()
                .withName("Alice")
                .withParents(parents)
                .build();
    }

    @Test
    public void testChainOfResponsibility() {
        Logger firstLogger, secondLogger, thirdLogger;
        firstLogger = new StdoutLogger(Logger.DEBUG);
        secondLogger = firstLogger.setNext(new EmailLogger(Logger.NOTICE));
        thirdLogger = secondLogger.setNext(new StderrLogger(Logger.ERR));

        firstLogger.message("Entering function y.", Logger.DEBUG);

        firstLogger.message("Step1 completed.", Logger.NOTICE);

        firstLogger.message("An error has occurred.", Logger.ERR);
    }

    @Test
    public void testFacade() {
        Computer computer = new Computer();
        computer.startComputer();
    }

    @Test
    public void testFactory() {
        Creator[] creators = {new MouseCreator(), new RaccoonCreator()};

        for (Creator creator : creators) {
            Animal animal = creator.factoryMethod();
            animal.setAge(1);
        }
    }

    @Test
    public void testIterator() {
        String[] namesExpected = {"Robert", "John", "Julie", "Lora"};

        NameRepository nameRepository = new NameRepository();
        Iterator iterator = nameRepository.getIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(namesExpected[i], iterator.next());
            i++;
        }
    }

    @Test
    public void testLocator() {
        MessagingService service = ServiceLocator.getService("EmailService");
        String email = service.getMessageBody();

        MessagingService smsService = ServiceLocator.getService("SmsService");
        String sms = smsService.getMessageBody();

        MessagingService emailService = ServiceLocator.getService("EmailService");
        String newEmail = emailService.getMessageBody();
    }

    @Test
    public void testSingleton() {
        Singleton firstSingleton = Singleton.getInstance();
        Singleton secondSingleton = Singleton.getInstance();

        assertEquals(firstSingleton, secondSingleton);
    }

    @Test
    public void testStrategy() {
        Context context = new Context();

        context.setStrategy(new AddStrategy());
        assertEquals(7, context.executeStrategy(3, 4));

        context.setStrategy(new SubtractStrategy());
        assertEquals(6, context.executeStrategy(10, 4));

        context.setStrategy(new MultiplyStrategy());
        assertEquals(121, context.executeStrategy(11, 11));
    }
}
