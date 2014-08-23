package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {
	private SelectTeamUi selectTeamUi;
	
	public void setSelectTeamUi(SelectTeamUi selectTeamUi){
		this.selectTeamUi = selectTeamUi;
	}
	
	protected void showMenu(){
		System.out.println(".....................");
		System.out.println("-�������- -�޴�-");
		System.out.println("");
		System.out.println("1.����");
		System.out.println("2.�� ���");
		System.out.println("");
		System.out.println("��ȣ�� �Է��� �� EnterŰ�� �����ּ���.");
		
	}
	
	protected int getMaxMenuNumber(){
		return 2;
	}
	
	protected int getMinMenuNumber(){
		return 1;
	}
	
	protected void execute(int number){
		switch (number){
		case 1:
			System.out.println("����Ǿ����ϴ�.");
			System.exit(0);
		case 2:
			this.selectTeamUi.show();
			break;
		}
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MenuUi menuUi=context.getBean(MenuUi.class);
		while (true){
			menuUi.show();
		}
	}
}
