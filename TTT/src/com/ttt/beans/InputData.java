package com.ttt.beans;

public class InputData {
	
	int num;				//variable which will store 'n' entered by the user
	

	@Override
	public String toString() {
		return "InputData [num=" + num + "]";
	}

	public InputData(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public InputData() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
