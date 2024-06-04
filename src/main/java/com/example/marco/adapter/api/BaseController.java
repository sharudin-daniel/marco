package com.example.marco.adapter.api;

import com.example.marco.adapter.feign.PoloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

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

    @GetMapping("/marco_polo/webclient")
    public String marcoPoloHandshakeWebClient() {
            var resp = WebClient.builder()
                    .baseUrl("http://polo:8083")
                    .build()
                    .get()
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        return "marco + " + resp;
    }
}
