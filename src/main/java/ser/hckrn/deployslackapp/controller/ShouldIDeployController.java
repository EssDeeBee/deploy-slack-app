package ser.hckrn.deployslackapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ShouldIDeployController {

    @GetMapping("/should")
    public Mono<String> shouldIDeploy() {
        return WebClient.builder()
                .baseUrl("https://shouldideploy.today/api?tz=UTC")
                .build()
                .get()
                .exchangeToMono(response -> response.bodyToMono(String.class));
    }
}
