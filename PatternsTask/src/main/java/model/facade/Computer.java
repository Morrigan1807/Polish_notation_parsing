package model.facade;

public class Computer {

    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.freeze();
        memory.load();
        cpu.jump();
        cpu.execute();
        hardDrive.read();
    }
}