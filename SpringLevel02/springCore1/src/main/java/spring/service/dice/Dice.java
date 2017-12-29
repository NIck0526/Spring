package spring.service.dice;
/*
 * DiceA, DiceB, DiceC 각각의 객체에서
 * 추릴수 있는 가장 공통적인, 핵심적인 로직을 담는다.
 * 추상화 기능으로
 * ::
 * selectedNumber()
 * getValue()
 */
	
public interface Dice {
	void selectedNumber();
	int getValue();
	
}
