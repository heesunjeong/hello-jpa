package hellojpa.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "userName", length = 20)
    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    /*private Long teamId;*/

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Member() {
    }

    public Member(String name, int age, MemberType memberType) {
        this(null, name, age, memberType, null);
    }

    public Member(String name, Team team) {
        this(null, name, 0, MemberType.USER, team);
    }

    public Member(Long id, String name, int age, MemberType memberType, Team team) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.memberType = memberType;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public Team getTeam() {
        return team;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
