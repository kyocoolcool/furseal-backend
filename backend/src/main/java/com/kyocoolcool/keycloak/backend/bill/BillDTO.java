package com.kyocoolcool.keycloak.backend.bill;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
public class BillDTO {
    private Integer id;

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

}