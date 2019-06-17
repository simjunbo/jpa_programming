package chapter6.일대다단방향;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 예제 실행시 주석 해제
 */
//@Entity
public class Team {
	@Id @GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;

	private String name;

	@OneToMany
	@JoinColumn(name = "TEAM_ID") // Member 테이블의 Team_id (fk)
	private List<Member> members = new ArrayList<Member>();

	public Team(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

}
