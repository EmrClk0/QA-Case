package Loggers;


import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class ScenarioLogger implements TestWatcher {
        Log log = new Log();


    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        String testName = context.getDisplayName();
        String reasonMessage = reason.get();
        log.info(testName+" disabled Reason: "+reasonMessage);

    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        log.info(testName+" passed successfully");

    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String causeMessageause = cause.getMessage();
        log.warn(testName+" Abordted! Cause: "+causeMessageause);

    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String failCause = cause.getMessage();
        log.error(testName+" FAILED!!!!  Cause: "+failCause);

    }
    public void  test(String s){
        log.error(s);
    }

    public static void main(String[] args) {
        ScenarioLogger scenarioLogger = new ScenarioLogger();
        scenarioLogger.test("sdfsdfsdgfsdfhgdfgdf12312312313");

    }


}
