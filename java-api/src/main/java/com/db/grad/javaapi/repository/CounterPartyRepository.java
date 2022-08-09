package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.grad.javaapi.model.CounterParty;

@Repository
public interface CounterPartyRepository extends JpaRepository<CounterParty, Long>{
	@Query(value = "select * from counter_party where id in (select t.counter_party_id from trade t where t.id = :trade_id)",
			nativeQuery = true)
	CounterParty findCounterPartyByTradeId(long trade_id);
}
