package org.eci.arep.math_service;

public class LucasOperationResponse {
    private String operation;
    private long input;
    private String output;

    public LucasOperationResponse(String operation, long input, String output) {
        this.operation = operation;
        this.input = input;
        this.output = output;
    }

    public LucasOperationResponse(){}

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public long getInput() {
        return input;
    }

    public void setInput(Long input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
