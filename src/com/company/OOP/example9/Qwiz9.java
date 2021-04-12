package com.company.OOP.example8;

class Expression
{
    private int a;
	private int b;
	private String operator;
	
	public Expression(){}
	public Expression(int a, int op,int b){
		this.a = a;
		this.b = b;
		this.operator = op;
	}
	
	public int getA(){
		return a;
	}
	public int getB(){
		return b;
	}
	public String getExp(){
		return operator;
	}
	
	public int evaluate(){
		switch (operator){
			case "+":
				return a+b;
				break;
			case "-":
				return a-b;
				break
			case "*":
				return a*b;
				break
				default:break;
		}
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
			while (line != null){
				if (globalResult <= 50){
					line = reader.readLine();
					exp = new Expression(String.valueOf(line.charAt(0))
									,line.charAt(1)
									,String.valueOf(line.charAt(2)));
			
					int lineResult = exp.evaluate();
					globalResult += lineResult;
					System.out.println(exp.toString() + " total " + globalResult);
				} else {
					break;
				}
			}
		}
	}
}
