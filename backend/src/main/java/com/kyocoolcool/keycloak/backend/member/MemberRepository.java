package com.kyocoolcool.keycloak.backend.member;

import com.kyocoolcool.keycloak.backend.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    List<Member> findProductsByName(String name);
}
