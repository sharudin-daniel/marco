package com.example.marco.adapter.api;

import com.example.marco.adapter.feign.PoloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BaseController {

    private final PoloClient poloClient;

    @GetMapping
    public String life() {
        return "marco";
    }


    @GetMapping("/marco_polo")
    public String marcoPoloHandshake() {
        var poloResp = poloClient.getPolo();
        return "marco + " + poloResp;
    }
}
