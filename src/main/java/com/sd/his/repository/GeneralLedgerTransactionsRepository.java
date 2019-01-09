package com.sd.his.repository;

import com.sd.his.model.GeneralLedgerTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneralLedgerTransactionsRepository extends JpaRepository<GeneralLedgerTransaction, Long> {


}