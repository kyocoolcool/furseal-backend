package com.kyocoolcool.keycloak.backend.bill;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillRepository extends CrudRepository<Bill, Long> {

    public List<Bill> findAllByDeletedIs(Boolean deleted);
}
