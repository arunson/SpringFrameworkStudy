package sample1;

import org.springframework.beans.factory.config.*;

public class CustomBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		// TODO Auto-generated method stub
		System.out.println("8.�ʱ�ȭ �� bean�� ���� ó������.");
		return bean;
	}
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		// TODO Auto-generated method stub
		System.out.println("5.�ʱ�ȭ �� bean�� ���� ó������.");
		return bean;
	}
	
	
}
