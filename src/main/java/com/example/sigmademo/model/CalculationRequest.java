package com.example.sigmademo.model;

public class CalculationRequest {
    private int operand1;
    private int operand2;
    private String operator;
    
    @Override
	public String toString() {
		return "CalculationRequest [operand1=" + operand1 + ", operand2=" + operand2 + ", operator=" + operator + "]";
	}
	public CalculationRequest(int operand1, int operand2, String operator) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.operator = operator;
	}
	
    // Getters and setters
    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
