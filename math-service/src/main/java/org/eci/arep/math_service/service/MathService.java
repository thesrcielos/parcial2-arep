package org.eci.arep.math_service.service;

import org.eci.arep.math_service.LucasOperationResponse;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

@Service
public class MathService {

    public MathService(){
    }
    public LucasOperationResponse getLucasSeqValue(long value){
        if (value < 0){
            return new LucasOperationResponse("Secuencia de Lucas", value, "");
        }
        List<Long> values = new ArrayList<>();
        calculateLucasSeq(values, value);
        StringBuilder res = new StringBuilder();
        for(Long num : values){
            res.append(num).append(", ");
        }
        res = new StringBuilder(res.substring(0, res.length() - 2));
        return new LucasOperationResponse("Secuencia de Lucas", value, res.toString());
    }

    private void calculateLucasSeq(List<Long> seq, long value){
        if (value >= 0){
            seq.add(2L);
        }
        if (value >= 1) {
            seq.add(1L);
        }

        for (int i = 2; i <= value; i++){
            seq.add(seq.get(i-1) + seq.get(i-2));
        }
    }
}
