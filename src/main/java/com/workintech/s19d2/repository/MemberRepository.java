package com.workintech.s19d2.repository;

import com.workintech.s19d2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {


    // List<[TUR]> [FONKSIYON_ADI]([PARAMETRELER]);
    @Query(value = "SELECT m FROM member m WHERE m.email = :email", nativeQuery = true)
    Optional<Member> findByEmail(String email);




}
