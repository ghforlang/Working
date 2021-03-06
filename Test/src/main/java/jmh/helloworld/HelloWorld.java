package jmh.helloworld;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/4 9:58
 */
public class HelloWorld {

    @Benchmark
    @Warmup
    public void wellHelloThere() {
        System.out.println("hello world");
        // this method was intentionally left blank.
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(HelloWorld.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
