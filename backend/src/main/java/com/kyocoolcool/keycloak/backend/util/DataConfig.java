package com.kyocoolcool.keycloak.backend.util;

import com.kyocoolcool.keycloak.backend.member.Member;
import com.kyocoolcool.keycloak.backend.member.MemberRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

@Configuration
@Getter
@Setter
public class DataConfig {
    @Autowired
    MemberRepository memberRepository;

    private Map<Integer, Member> memberMap;

    @Bean
    public Data data() {
        List<Member> all = memberRepository.findAll();
        Data data = new Data();
        Map<Integer, Member> memberMap = all.stream().collect(Collectors.toMap(Member::getId, x ->x));
        data.setMembers(memberMap);
        return data;
    }
}
