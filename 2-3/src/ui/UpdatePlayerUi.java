package ui;

import org.apache.commons.lang.StringUtils;

import model.Player;
import model.Team;
import dao.PlayerDao;
import dao.TeamDao;

public class UpdatePlayerUi extends AbstractUi{
	private PlayerDao playerDao;
	private TeamDao teamDao;
	
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public void show() {
		// TODO Auto-generated method stub
		Player player=getPlayer();
		if (player == null){
			return;
		}
		
		String name=getName(player);
		if (StringUtils.isNotEmpty(name)){
			player.setName(name);
		}
		
		Team team = getTeam(player);
		if (team!=null){
			player.setTeam(team);
		}
		
		this.playerDao.updatePlayer(player);
		System.out.printf("선수ID '%s'인 선수, 선수명 '%s', 팀 '%s'로 수정함%n", 
				player.getId(), player.getName(), player.getTeam().getName());
	}
	
	protected Player getPlayer() {
		// TODO Auto-generated method stub
		final String playerId = "선수ID";
		showMenu(playerId);
		System.out.println("아무것도 입력안하고 Enter 누르면 메뉴로 돌아감.");
		
		String id = getInputedString();
		if (StringUtils.isEmpty(id)){
			return null;
		} else if (UiUtils.isNumeric(id, playerId)){
			Player player = this.playerDao.getPlayer(Integer.valueOf(id));

			if (player == null){
				System.out.printf("입력한 선수ID가 '%s'인 선수는  존재안함.%n", id);
				return getPlayer();
			}
			return player;
		}
		
		return getPlayer();
	}

	protected Team getTeam(Player player) {
		// TODO Auto-generated method stub
		final String teamId = "팀ID";
		showMenu(teamId);
		System.out.println("아무것도 입력안하고 Enter 누르면 변경 안됨.");
		System.out.printf("원래값: %s%n", player.getTeam().getId());
		player.getTeam().getName();
		
		String id = getInputedString();
		if (StringUtils.isEmpty(id)){
			return null;
		}
		
		if (UiUtils.isNumeric(id, teamId)){
			Team team = this.teamDao.getTeam(Integer.valueOf(id));
			if (team == null){
				System.out.printf("입력한 팀명 '%s'인팀 존재안함.%n", id);
				return getTeam(player);
			}
			return team;
		}
		
		return getTeam(player);
	}

	protected String getName(Player player) {
		// TODO Auto-generated method stub
		final String playerName = "선수명";
		showMenu(playerName);
		System.out.println("아무것도 입력안하고 Enter 누르면 변경 안됨.");
		System.out.printf("원래값: %s%n", player.getName());
		
		String name = getInputedString();
		if(StringUtils.isEmpty(name)){
			return null;
		}
		if (UiUtils.isSmallLength(name, playerName, 128)){
			return name;
		}
				
		return getName(player);
	}

	protected void showMenu(String wanted) {
		// TODO Auto-generated method stub
		System.out.println("..............");
		System.out.println("[선수 명단] [선수 갱신]");
		System.out.println("");
		System.out.printf("%s를 입력 한 후 Enter 눌러.",wanted);
		
	}
}
