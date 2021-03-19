package model.facade;

class Computer {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

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

class CPU {
    public void freeze() {}

    public void jump() { }

    public void execute() { }
}

class Memory {
    public void load() { }
}

class HardDrive {
    public byte[] read() {return new byte[]{0, 127};}
}



