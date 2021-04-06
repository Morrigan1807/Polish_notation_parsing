package ParameterizedTests.model.chainofresponsibility;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StdoutLogger extends Logger {

    public StdoutLogger(int mask) {
        this.mask = mask;
    }

    protected void writeMessage(String msg) {
        log.info("Writing to stdout: " + msg);
    }
}