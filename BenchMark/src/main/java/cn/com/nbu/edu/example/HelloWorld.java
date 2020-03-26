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
 * @create on 2018/8/6 19:43
 */
@State(Scope.Thread)
public class HelloWorld {

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void printHelloWorld(){
        System.out.println("hello World");
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(HelloWorld.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
