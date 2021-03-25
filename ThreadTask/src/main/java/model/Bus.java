package model;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.Semaphore;

/*Добавь фиксацию того что тот или иной автобус прибыл на ту или иную остановку
(в алгоритме приложения, это нужно для проверки работы алгоритма)

Добавить тесты которые будут проверять то что автобусы которые были отосланы прибыли за ориентировочное время
Добавить тесты на проверку попадали ли автобусы на остановки

У каждого из автобусов должна быть различная скорость и различные остановки
(нужно сделать так чтобы автобусы при наличии разных маршрутов имели пункты пересечения)
Для проверки результата должен быть следующий тест:
Входные данные:
Автобусы:
1) Скорость 40 едениц. Маршрут Солигорск-Слуцк-Несвиж-Мир
2) Скорость 60 едениц. Маршрут Солигорск-Слуцк-Несвиж-Барановичи
3) Скорость 80 едениц. Маршрут Солигорск-Слуцк-Клецк-Барановичи
4) Скорость 100 едениц. Маршрут Солигорск-Слуцк-Несвиж-Полонечка
(Города можно изменить на номера остановок)

Автобусы выходят из депо не в одно и то же время
Каждый автобус проводит 2 секунды на остановке
(можно изменить в зависимости от скорости приезда автобусов, нужно убедиться что будут остановки где автобусы пересекутся).
Максимальное количество автобусов на остановке - 2 автобуса. Почитай про Semaphore (можно использовать для этого условия)

По коду:
- методы тесты должны быть: public void название теста
- разбивай методы на одно действие один метод*/

@Data
public class Bus implements Runnable {

    private static final int TIME_TO_BUS_STOP = 2;

    private static final Semaphore semaphore = new Semaphore(2, true);
    private static int iter = 0;
    private final int numberOfBus;
    private int timeToMoveToNextBusStop = 10;
    private List<BusStop> busRoute;
    private BusStop nextBusStop;
    private int timeInRoute;
    private long timeStartRout;
    private int delayBeforeStart;

    Bus() {
        numberOfBus = ++iter;
    }

    public void setBusRoute(List<BusStop> busRoute) {
        this.busRoute = busRoute;

        busRoute.forEach(BusStop::incrementNumOfBusesExpected);
    }

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(delayBeforeStart);

        timeStartRout = System.currentTimeMillis();

        goToNextBusStop();
    }

    private void goToNextBusStop() {

    }
}
