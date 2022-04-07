package com.kyocoolcool.keycloak.backend.bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {

    public List<Bill> findAllByDeletedIs(Boolean deleted);
}
