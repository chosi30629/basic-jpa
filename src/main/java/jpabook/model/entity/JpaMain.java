package jpabook.model.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        tx.commit();
    }

}

/*
    1. h2 서버모드 실행
        cd h2/bin
        chmod +x h2.sh
        ./h2.sh

    2. h2 버전과 pom.xml의 라이브러리 버전이 맞아야함
 */