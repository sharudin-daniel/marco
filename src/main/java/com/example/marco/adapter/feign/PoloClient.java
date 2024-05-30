package com.example.marco.adapter.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "polo", url = "http://localhost:8083")
public interface PoloClient {
    @RequestMapping(method = RequestMethod.GET)
    String getPolo();
}