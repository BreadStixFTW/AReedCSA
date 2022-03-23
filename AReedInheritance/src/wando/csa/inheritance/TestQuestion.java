package wando.csa.inheritance;

import java.util.*;

public abstract class TestQuestion {
	protected String question;
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String toString() {
		return this.question;
	}
	
	protected abstract void readQuestion(Scanner inputs);
}
