package com.evan.payment.controller;


import com.evan.payment.service.PaymentService;
import entities.Payment;
import entities.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @ClassName PaymentController
 * @Author Evan
 * @date 2020.06.06 00:32
 */

@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public Result createPayment(@RequestBody Payment payment) {
        log.info("port:{},插入的数据为：{}", port, payment);
        int i = paymentService.create(payment);
        log.info("插入结果" + i);

        if (i > 0) {
            return new Result(200, "插入成功" + port, i);
        } else {
            return new Result(444, "插入失败", null);
        }
    }

    @GetMapping("/payment/{id}")
    public Result getPayment(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);

        if (paymentById != null) {
            return new Result(200, "查询成功" + port, paymentById);
        } else {
            return new Result(444, "查询失败", null);
        }
    }

    /**
     * Eureka Server Discovery
     *
     * @return
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            log.info("*****element:" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() +
                    "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return port + "";
    }

}
