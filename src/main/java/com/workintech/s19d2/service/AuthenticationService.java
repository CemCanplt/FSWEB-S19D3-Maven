package com.workintech.s19d2.service;

import com.workintech.s19d2.repository.MemberRepository;
import com.workintech.s19d2.repository.RoleRepository;
import com.workintech.s19d2.entity.Member;
import com.workintech.s19d2.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthenticationService {

    private final static String ROLE_USER = "USER";
    private final static String ROLE_USER2 = "ADMIN";
    // Üye ve Rol Repo'ları genelde burada olur.
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public Member register(String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Optional<Member> memberOptional = memberRepository.findByEmail(email);

        if (memberOptional.isPresent()) {
            throw new RuntimeException("User with given email already exist");
        }

        List<Role> roles = new ArrayList<>();

//        Optional<Role> roleOptional = roleRepository.findByAuthority(ROLE_USER);
//        if (!roleOptional.isPresent()) {
//            Role roleEntity = new Role();
//
//            roleEntity.setAuthority(ROLE_USER);
//            roles.add(roleRepository.save(roleEntity));
//
//        } else {
//            roles.add(roleOptional.get());
//        }

        Optional<Role> roleOptional2 = roleRepository.findByAuthority(ROLE_USER2);
        if (!roleOptional2.isPresent()) {
            Role roleEntity = new Role();

            roleEntity.setAuthority(ROLE_USER2);
            roles.add(roleRepository.save(roleEntity));

        } else {
            roles.add(roleOptional2.get());
        }

        Member member = new Member();
        member.setEmail(email);
        member.setPassword(encodedPassword);
        member.setRoles(roles);
        return memberRepository.save(member);

        // Burada kullanıcıyı kaydetme işlemi yapılır.
        // Kullanıcıyı kaydettikten sonra, kullanıcıyı döndürür.

        // Role userRole = roleRepository.findByAuthority("HERHANGİ_BİR_OTORİTE").get();

        // ApplicationUser user = new ApplicationUser();

        // user.setUsername(username);
        // user.setEmail(email);
        // user.setPassword(encodedPassword);
        // user.setEnabled(true);
        // user.setAuthorities(BU_BİR_LIST_OLABİLİR);

    }
}
