package com.kyocoolcool.keycloak.backend.member;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByName(String name);
}
