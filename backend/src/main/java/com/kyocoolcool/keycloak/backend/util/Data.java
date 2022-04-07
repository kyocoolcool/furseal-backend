package com.kyocoolcool.keycloak.backend.util;

import com.kyocoolcool.keycloak.backend.member.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Data {
    private Map<Integer, Member> members;
}
