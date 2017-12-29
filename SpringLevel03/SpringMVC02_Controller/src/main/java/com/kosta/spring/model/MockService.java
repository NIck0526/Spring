package com.kosta.spring.model;
/*
 * Mock 객체
 * ::
 * 실제 프로젝트에서 돌아가는 동일한 코드가 아니라
 * 테스트를 위한 가상의 로직을 담고 있는 객체
 */
public class MockService {
	public String registerCar(CarVO car) {
		System.out.println("자동차가 등록되었습니다!!!"+car);
		return "자동차 등록 성공!!::모델명 ::"+car.getModel();
	}
}
