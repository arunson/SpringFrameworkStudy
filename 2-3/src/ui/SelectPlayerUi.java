package ui;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import model.Player;
import dao.PlayerDao;

public class SelectPlayerUi extends AbstractUiTemplate {
	private PlayerDao playerDao;
	private UpdatePlayerUi updatePlayerUi;
	private DeletePlayerUi deletePlayerUi;
	
	
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	public void setUpdatePlayerUi(UpdatePlayerUi updatePlayerUi) {
		this.updatePlayerUi = updatePlayerUi;
	}

	public void setDeletePlayerUi(DeletePlayerUi deletePlayerUi) {
		this.deletePlayerUi = deletePlayerUi;
	}

	public void show(){
		showHeader();
		Integer teamId=getTeamId();
		showPlayerList(this.playerDao.getPlayerList(teamId));
		System.out.println("Enter키를 눌러주세요.");
		getInputedString();
		super.show();
	}
	
	protected void showPlayerList(List<Player> playerList) {
		// TODO Auto-generated method stub
		System.out.println("...............");
		System.out.println("[선수 명단] [선수 목록]");
		if (!playerList.isEmpty()){
			Player player = playerList.get(0);
			System.out.printf("팀명: %s%n", player.getTeam().getName());
		}
		System.out.println("ID 이름");
		for (Player player : playerList){
			System.out.printf("%d %s%n",player.getId(),player.getName());
		}
	}

	protected Integer getTeamId() {
		// TODO Auto-generated method stub
		System.out.println("목록 표시 싶은 팀 ID 입력 Enter 눌러.");
		String teamId=getInputedString();
		if (StringUtils.isNotEmpty(teamId) && StringUtils.isNumeric(teamId)){
			return Integer.valueOf(teamId);
		}
		return getTeamId();
	}

	protected void showHeader() {
		// TODO Auto-generated method stub
		System.out.println("............");
		System.out.println("[선수 명단] [선수 목록]");
		System.out.println("");
		
	}

	@Override
	protected void showMenu() {
		// TODO Auto-generated method stub
		showHeader();
		System.out.println("1.선수 갱신 ");
		System.out.println("2. 선수 삭제    ");
		System.out.println("3. 메뉴로 돌아기기");
		System.out.println("");
		System.out.println("번호를 입력 Enter키를 눌러.");
	}

	@Override
	protected int getMaxMenuNumber() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	protected int getMinMenuNumber() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	protected void execute(int number) {
		// TODO Auto-generated method stub
		switch (number){
		case 1:
			updatePlayerUi.show();
			break;
		case 2:
			deletePlayerUi.show();
			break;
		default:
			return;
		}
	}
	
}
