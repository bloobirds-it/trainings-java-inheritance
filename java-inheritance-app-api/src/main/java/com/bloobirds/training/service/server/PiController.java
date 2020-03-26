package com.bloobirds.training.service.server;

import com.bloobirds.training.service.spec.PiService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class PiController {

    private final PiService piService;

    @JsonGet("/computePi")
    public ResponseEntity<Response> computePi() {
        double value = piService.computePi();
        Response response = Response.builder()
                .value(Double.toString(value))
                .build();
        return ResponseEntity.ok(response);

    }

    @Value
    @Builder
    public static class Response {
        private final String value;
    }

}
