package sample1;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBeanImpl implements MessageBean, BeanNameAware, BeanFactoryAware,
InitializingBean, DisposableBean {
	private String name;
	private String greeting;
	private String beanName;
	private BeanFactory beanFactory;
	
	public MessageBeanImpl(){
		System.out.println("1.������ȣ��");
	}
	
	public void setGreeting(String greeting){
		this.greeting=greeting;
		System.out.println("2.�����޼������");
	}
	
	public void setBeanName(String beanName){
		this.beanName=beanName;
		System.out.println("3.bean �̸�����");
		System.out.println("->"+beanName);
	}
	
	public void setBeanFactory(BeanFactory beanFactory){
		System.out.println("4.bean ���丮����");
		this.beanFactory=beanFactory;
		System.out.println("->"+beanFactory.getClass());
	}
	
	public void init(){
		System.out.println("7.�ʱ�ȭ�޼������");
	}
	
	
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		String message = greeting + beanName + "!";
		System.out.println(message);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("����");
	}

	@Override
	public void afterPropertiesSet(){
		// TODO Auto-generated method stub
		System.out.println("6.������Ƽ�����Ϸ�");
	}
	
}
