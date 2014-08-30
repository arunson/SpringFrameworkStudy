package ui;

import model.Player;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;

public class DeletePlayerUi extends AbstractUi {
	private PlayerDao playerDao;
	
	public void setPlayerDao(PlayerDao dao){
		this.playerDao=dao;
	}

	public void show() {
		// TODO Auto-generated method stub
		showMenu();
		
		String id = getInputedString();
		
		if (StringUtils.isEmpty(id)){
			return;
		} else if (UiUtils.isNumeric(id, "선수ID")){
			Player player = this.playerDao.getPlayer(Integer.valueOf(id));
			if (player == null){
				System.out.printf("입력한 선수ID '%s'인 선수는 존재하지 않습니다.%n", id);
				show();
			} else{
				this.playerDao.deletePlayer(player);
				System.out.printf("선수ID '%s'라는 선수를 삭제합니다.%n", id);
			}
		} else {
			show();
		}
		
	}

	protected void showMenu() {
		// TODO Auto-generated method stub
		System.out.println(".............. ");
		System.out.println("[선수 명단] [선수 삭제]");
		System.out.println("");
		System.out.println("선수ID를 입력한 후 Enter를 눌러주세요.");
		System.out.println("아무것도 입력하지 않고 Enter를 누르면 메뉴로 돌아갑니다.");
	}

}
