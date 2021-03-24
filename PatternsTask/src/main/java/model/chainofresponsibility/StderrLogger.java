package model.chainofresponsibility;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StderrLogger extends Logger {

    public StderrLogger(int mask) {
        this.mask = mask;
    }

    protected void writeMessage(String msg) {
        log.info("Sending to stderr: " + msg);
    }
}