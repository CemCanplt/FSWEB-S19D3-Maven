package com.workintech.s19d2.dao;

import com.workintech.s19d2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // List<[TUR]> [FONKSIYON_ADI]([PARAMETRELER]);
    // @Query(value = "SELECT [METIN]", nativeQuery = true)



}
