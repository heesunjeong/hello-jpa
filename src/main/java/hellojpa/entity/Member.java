package hellojpa.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userName", length = 20)
    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Member() {
    }

    public Member(String name, int age, MemberType memberType) {
        this.name = name;
        this.age = age;
        this.memberType = memberType;
    }

    public Member(Long id, String name, int age, MemberType memberType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.memberType = memberType;
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
}
