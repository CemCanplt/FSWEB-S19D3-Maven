package com.workintech.s19d2.repository;

import com.workintech.s19d2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    // List<[TUR]> [FONKSIYON_ADI]([PARAMETRELER]);
    @Query(value = "SELECT r FROM role r WHERE r.authority = :authority", nativeQuery = true)
    Optional<Role> findByAuthority(String authority);
}
