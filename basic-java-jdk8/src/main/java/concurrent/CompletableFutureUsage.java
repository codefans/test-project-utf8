package concurrent;

import com.codefans.reusablecode.util.DateUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @Author: codefans
 * @Date: 2021-08-06 11:26
 */

public class CompletableFutureUsage {

    private CompletableFuture cf;

    private static final int CORE_SIZE = Runtime.getRuntime().availableProcessors();

    private static final ExecutorService threadPool = new ThreadPoolExecutor(CORE_SIZE, CORE_SIZE * 2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100000), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "complatableFutureThreadPool");
        }
    }, new ThreadPoolExecutor.CallerRunsPolicy());

    public void sequenceTask(List<Callable<String>> taskList) {
//        CompletableFuture.supplyAsync()
//        Arrays.copyOf()
        // 第一个任务:
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> queryCode("中国石油"));
        // cfQuery成功后打印结果:
        cfQuery.thenAccept((result) -> {
            System.out.println("result: " + result);
        });

        String code = "22.3";
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((param) -> fetchPrice(code));

        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });


    }

    public void sequenceExec() throws ExecutionException, InterruptedException {

//        List<Supplier<T>> taskList

        Supplier<String> supplier01 = new Supplier<String>() {
            @Override
            public String get() {
                String res = "supplier01_" + DateUtils.formatYYYYMMDDHHMMSS_SSS(new Date());
                System.out.println(res);
                return res;
            }
        };
        Supplier<String> supplier02 = () -> {
            String str = "supplier02_" + DateUtils.formatYYYYMMDDHHMMSS_SSS(new Date());
            System.out.println(str);
            return str;
        };
        Supplier<String> supplier03 = () -> {
            String str = "supplier03_" + DateUtils.formatYYYYMMDDHHMMSS_SSS(new Date());
            System.out.println(str);
            return str;
        };
        Supplier<String> supplier04 = () -> {
            String str = "supplier04_" + DateUtils.formatYYYYMMDDHHMMSS_SSS(new Date());
            System.out.println(str);
            return str;
        };

        // 第一个任务:
        CompletableFuture<String> cf01 = CompletableFuture.supplyAsync(supplier01);
        CompletableFuture<String> cf02 = CompletableFuture.supplyAsync(supplier02);
        CompletableFuture<String> cf03 = CompletableFuture.supplyAsync(supplier03);
        CompletableFuture<String> cf04 = CompletableFuture.supplyAsync(supplier04);

        CompletableFuture cf = CompletableFuture.allOf(cf01, cf02, cf03, cf04);
//        cf.thenAccept((result)->{
//            System.out.println("all task finished!, result=" + result);
//        });
        System.out.println("all task finished!, result=" + cf.get());

    }

    private String queryCode(String str) {
        return "hello_" + str;
    }

    private Double fetchPrice(String code) {
        return new Double(code);
    }

}
