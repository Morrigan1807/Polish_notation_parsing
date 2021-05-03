package util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Wait {

    public void waitPeopleResolveCaptcha() {
        sSleep(20);
    }

    public void sSleep(double sec) {
        msSleep(sec * 1000);
    }

    public void msSleep(double mSec) {
        try {
            Thread.sleep((int) (mSec));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
