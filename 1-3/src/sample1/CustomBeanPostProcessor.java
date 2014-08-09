package sample1;

import org.springframework.beans.factory.config.*;

public class CustomBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		// TODO Auto-generated method stub
		System.out.println("8.초기화 후 bean에 대한 처리실행.");
		return bean;
	}
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		// TODO Auto-generated method stub
		System.out.println("5.초기화 전 bean에 대한 처리실행.");
		return bean;
	}
	
	
}
