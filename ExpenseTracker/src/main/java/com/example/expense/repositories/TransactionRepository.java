package com.example.expense.repositories;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.expense.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{




	@Query("SELECT c.cat_type, c.cat_name, SUM(t.amount) AS totalAmount " +
		       "FROM Transaction t " +
		       "JOIN t.category c " +
		       "WHERE t.tdate BETWEEN :fromDate AND :toDate " +
		       "GROUP BY c.cat_type, c.cat_name")
		List<Object[]> getTransactionReport(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);

}