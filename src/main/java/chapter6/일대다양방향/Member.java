package chapter6.일대다양방향;

import javax.persistence.*;

/**
 * 예제 실행시 주석 해제
 */
//@Entity
public class Member {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	private String username;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
	private Team team;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;

		// 무한루프에 빠지지 않도록
		if (!team.getMembers().contains(this)) {
			team.getMembers().add(this);
		}
	}
}
