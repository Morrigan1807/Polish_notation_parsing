package ParameterizedTests.model.chainofresponsibility;

import lombok.extern.log4j.Log4j2;

@Log4j2
public
class EmailLogger extends Logger {

    public EmailLogger(int mask) {
        this.mask = mask;
    }

    protected void writeMessage(String msg) {
        log.info("Sending via email: " + msg);
    }
}
