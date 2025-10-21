package org.eci.arep.math_service.controller;

import org.eci.arep.math_service.LucasOperationResponse;
import org.eci.arep.math_service.service.MathService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/lucasseq")
    @ResponseStatus(HttpStatus.OK)
    public LucasOperationResponse getLucasSeq(@RequestParam long value){
        return mathService.getLucasSeqValue(value);
    }
}
