package com.lively.io.ExcelApp.tableGenerator;

import java.util.List;

import com.lively.io.ExcelApp.tableGenerator.DomainObjects.TransactionRecord;

public interface LivelyRepository {
	TransactionRecord create(TransactionRecord transactionRecord);
	TransactionRecord find(Long id);
	List<TransactionRecord> list();
	TransactionRecord update(Long id, TransactionRecord transactionRecord);
	void delete(Long id);
}
