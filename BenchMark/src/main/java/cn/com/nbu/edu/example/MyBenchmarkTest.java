package cn.com.nbu.edu.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/8/6 20:46
 */

@BenchmarkMode({Mode.AverageTime,Mode.Throughput,Mode.SampleTime,Mode.SingleShotTime,Mode.All})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class MyBenchmarkTest {

    @Benchmark
    public int sleepAWhile(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MyBenchmarkTest.class.getSimpleName())
                .forks(1)
                .warmupIterations(3)
                .measurementIterations(3)
                .build();

        new Runner(opt).run();
    }
}
