package org.jpa.exam.repository;

import org.jpa.exam.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);

    @Query("SELECT m FROM Member m WHERE m.id = ?1")
    Member findOne(Long id);
}
