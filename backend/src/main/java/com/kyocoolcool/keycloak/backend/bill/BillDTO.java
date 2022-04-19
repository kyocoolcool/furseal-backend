package com.kyocoolcool.keycloak.backend.bill;

import com.kyocoolcool.keycloak.backend.member.MemberDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
public class BillDTO {
    private Long billId;

    private String productName;

    private Integer memberCount;

    private Integer money;

    private String gainer;

    private String buyer;

    private Character way;

    private Integer status;

    private Instant gainTime;

    private Instant transactionTime;

    private Boolean deleted;

    private Integer tax;

    private Integer fee;
    
    private List<MemberDTO> members;

}