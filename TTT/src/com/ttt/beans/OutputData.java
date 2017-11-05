package com.ttt.beans;

public class OutputData {
	
	String word;			//will store the word.
	int count;				//will store the count or frequency
	

	public OutputData(String word, int count) {
		super();
		this.word = word;
		this.count = count;
	}


	@Override
	public String toString() {
		return "OutputData [word=" + word + ", count=" + count + "]";
	}


	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public OutputData() {
		// TODO Auto-generated constructor stub
	}

}
