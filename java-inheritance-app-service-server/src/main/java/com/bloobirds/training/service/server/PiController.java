package com.bloobirds.training.service.server;

import com.bloobirds.training.service.spec.PiRemoteResponse;
import com.bloobirds.training.service.spec.PiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class PiController {

    private final PiService piService;

    @JsonGet("/computePi")
    public ResponseEntity<PiRemoteResponse> computePi() {
        double value = piService.computePi();
        PiRemoteResponse response = PiRemoteResponse.of(Double.toString(value));
        return ResponseEntity.ok(response);

    }

}
