package com.yurishchev.hystrixspring.controller;

import com.netflix.hystrix.HystrixRequestLog;
import com.netflix.hystrix.examples.demo.HystrixCommandDemo;
import com.yurishchev.hystrixspring.HystrixCommandDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ExecutionException;

@Controller
public class HystrixDemoController {

    private final HystrixCommandDemoService hystrixDemoService;

    @Autowired
    public HystrixDemoController(HystrixCommandDemoService hystrixDemoService) {
        this.hystrixDemoService = hystrixDemoService;
    }

    @RequestMapping("/failfast")
    public ModelAndView failFast() {
        String result = hystrixDemoService.executeFailFast();
        return new ModelAndView("demo", "result", result);
    }

    @RequestMapping("/failsilent")
    public ModelAndView failSilent() {
        String result = hystrixDemoService.executeFailSilent();
        return new ModelAndView("demo", "result", result);
    }

    @RequestMapping("/failstatic")
    public ModelAndView failStatic() {
        String result = hystrixDemoService.executeFailStatic();
        return new ModelAndView("demo", "result", result);
    }

    @RequestMapping("/fallbackvianetwork")
    public ModelAndView fallbackViaNetwork() {
        String result = hystrixDemoService.executeFallbackViaNetwork();
        return new ModelAndView("demo", "result", result);
    }

    @RequestMapping("/hystrixdemo")
    public ModelAndView hystrixWebDemo() throws ExecutionException, InterruptedException {
        new HystrixCommandDemo().executeSimulatedUserRequestForOrderConfirmationAndCreditCardPayment();
        String result = HystrixRequestLog.getCurrentRequest().getExecutedCommandsAsString();
        return new ModelAndView("demo", "result", result);
    }
}
