package com.yurishchev.hystrixspring;

import com.netflix.hystrix.examples.basic.CommandWithFallbackViaNetwork;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("singleton")
public class HystrixCommandDemoService {

    @FailFast
    public String executeFailFast() {
        return service();
    }

    @FailSilent
    public String executeFailSilent() {
        return service();
    }

    @FailStatic(value = "Dummy Fallback")
    public String executeFailStatic() {
        return service();
    }

    public String executeFallbackViaNetwork() {
        return new CommandWithFallbackViaNetwork(1).execute();
    }

    private String service() {
        if (Math.random() < 0.5) throw new RuntimeException("Failure!");
        else return "Dummy RPC was called!";
    }
}
