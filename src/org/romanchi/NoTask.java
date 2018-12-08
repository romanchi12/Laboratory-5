package org.romanchi;

import java.util.logging.Logger;

public class NoTask implements Task {
    private static final Logger logger = Logger.getLogger(NoTask.class.getName());
    @Override
    public void execute() {
        logger.info("No task");
    }
}
