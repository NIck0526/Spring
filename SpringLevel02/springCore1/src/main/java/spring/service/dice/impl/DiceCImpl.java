package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceCImpl implements Dice{
	private int value;
	
	public DiceCImpl() {
		System.out.println("::"+getClass().getName()+" ������ call....");
		
	}

	public void selectedNumber() {
		value= new Random().nextInt(6)+1;
		
	}

	public int getValue() {
		
		return  value;
	}
}
