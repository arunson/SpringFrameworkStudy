package ui;

import java.util.List;

import model.Team;
import dao.TeamDao;

public class SelectTeamUi extends AbstractUi {

    private TeamDao teamDao;

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void show() {
        // �� ��� ǥ��
        showTeamList(this.teamDao.getTeamList());
        System.out.println("Enter를 눌러주세요.");
        getInputedString();
    }

    protected void showTeamList(List<Team> teamList) {
        System.out.println("--------------------");
        System.out.println("");
        System.out.println("ID    이름");
        for (Team team : teamList) {
        	// ��ID�� ���� ǥ��
        	System.out.printf("%d  %s%n", team.getId(), team.getName());
		}
    }
}

