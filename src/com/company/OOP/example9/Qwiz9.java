package com.company.OOP.example9;

import java.io.BufferedReader;
import java.io.FileReader;

class Expression {
	private int a;
	private int b;
	private String operator;

	public Expression() {
	}

	public Expression(int a, String op, int b) {
		this.a = a;
		this.b = b;
		this.operator = op;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public String getExp() {
		return operator;
	}

	public int evaluate() {
		switch (operator) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			default:
				break;
		}
		return 0;
	}

	
	public String toString(){
		return " ( " + a + " " + operator + " " + b + " ) ";
	}
}

class Qwiz9
{	
	public static void main(String[] args){
		int globalResult = 0;
		BufferedReader reader;
		Expression exp;
		try {
			reader = new BufferedReader(new FileReader("input.txt"));
			String line = reader.readLine();
			while (line != null) {
				if (globalResult <= 50) {
					line = reader.readLine();
					exp = new Expression(line.charAt(0)
							, String.valueOf(line.charAt(1))
							, line.charAt(2));

					int lineResult = exp.evaluate();
					globalResult += lineResult;
					System.out.println(exp.toString() + " total " + globalResult);
				} else {
					break;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
