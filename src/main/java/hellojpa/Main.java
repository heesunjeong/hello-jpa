package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.MemberType;
import hellojpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team("조이팀");
            em.persist(team);

            Member member = new Member("정조이", team);
            em.persist(member);

            ///////

            em.flush();
            em.clear();

            Member savedMember = em.find(Member.class, member.getId());
            // 참조를 사용해서 연관관계 조회
            Team savedTeam = savedMember.getTeam();

            savedTeam.getMembers().size(); // 역방향 조회
            for(Member member1: savedTeam.getMembers()) {
                System.out.println("member = " + member1.toString());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
