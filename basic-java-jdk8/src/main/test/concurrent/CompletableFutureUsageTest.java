package concurrent;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * @Author: codefans
 * @Date: 2021-08-06 11:27
 */

public class CompletableFutureUsageTest {

    private CompletableFutureUsage completableFutureUsage;

    @Before
    public void before() {
        completableFutureUsage = new CompletableFutureUsage();
    }

    @Test
    public void sequenceTaskTest() throws ExecutionException, InterruptedException {

//        completableFutureUsage.sequenceTask(null);
        completableFutureUsage.sequenceExec();


    }

}
