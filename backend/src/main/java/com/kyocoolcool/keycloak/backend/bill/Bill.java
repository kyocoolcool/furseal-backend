package com.kyocoolcool.keycloak.backend.bill;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "bill")
@Getter
@Setter
@ToString
public class Bill {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "money")
    private Integer money;

    @Column(name = "buyer")
    private Integer buyer;

    @Column(name = "gainer")
    private Integer gainer;

    @Column(name = "way")
    private Character way;

    @Column(name = "status")
    private Integer status;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "gain_time")
    private Instant gainTime;

    @Column(name = "member_count")
    private Integer memberCount;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "transaction_time")
    private Instant transactionTime;
}