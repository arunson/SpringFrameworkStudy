package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {
	private SelectTeamUi selectTeamUi;
	
	private InsertPlayerUi insertPlayerUi;
	
	private SelectPlayerUi selectPlayerUi;
	
	public void setSelectPlayerUi(SelectPlayerUi selectPlayerUi) {
		this.selectPlayerUi = selectPlayerUi;
	}

	public void setSelectTeamUi(SelectTeamUi selectTeamUi){
		this.selectTeamUi = selectTeamUi;
	}
	
	public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi){
		this.insertPlayerUi=insertPlayerUi;
	}
	
	protected void showMenu(){
		System.out.println(".....................");
		System.out.println("-선수 명단- -팀 목록-");
		System.out.println("");
		System.out.println("1.종료");
		System.out.println("2.팀 목록");
		System.out.println("3.선수 추가");
		System.out.println("4.선수 목록");
		System.out.println("");
		System.out.println("번호를 입력한 후 Enter키를 눌러주세요.");
		
	}
	
	protected int getMaxMenuNumber(){
		return 4;
	}
	
	protected int getMinMenuNumber(){
		return 1;
	}
	
	protected void execute(int number){
		switch (number){
		case 1:
			System.out.println("종료되었습니다.");
			System.exit(0);
		case 2:
			this.selectTeamUi.show();
			break;
		case 3:
			this.insertPlayerUi.show();
			break;
		case 4:
			this.selectPlayerUi.show();
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
