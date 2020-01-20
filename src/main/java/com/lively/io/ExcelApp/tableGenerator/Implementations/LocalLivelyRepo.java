package com.lively.io.ExcelApp.tableGenerator.Implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lively.io.ExcelApp.tableGenerator.LivelyRepository;
import com.lively.io.ExcelApp.tableGenerator.DomainObjects.TransactionRecord;

public class LocalLivelyRepo implements LivelyRepository {
	private HashMap<Long,TransactionRecord> entries = new HashMap<>();
	
	private long currentId = 1L;

	@Override
	public TransactionRecord create(TransactionRecord transactionRecord) {
		Long id = currentId++;
		
		TransactionRecord newRecord = TransactionRecord.builder()
				.accountNumber(transactionRecord.getAccountNumber())
				.id(transactionRecord.getId())
				.name(transactionRecord.getName())
				.tithes(transactionRecord.getTithes())
				.offering(transactionRecord.getOffering())
				.build();
		entries.put(currentId, newRecord);
		return newRecord;
	}

	@Override
	public TransactionRecord find(Long id) {
		
		return entries.get(id);
	}

	@Override
	public List<TransactionRecord> list() {
	    //entries.entrySet().iterator() .forEachRemaining(longTimeEntryEntry -> list.add(longTimeEntryEntry.getValue() ));
		// need to test this
		
		return entries.entrySet().stream()
			//	.filter(e -> e.getValue()) you could filter for records of a certain type
				.map(Map.Entry::getValue)
				.collect(Collectors.toList());
	}

	@Override
	public TransactionRecord update(Long id, TransactionRecord transactionRecord) {
		TransactionRecord updater = entries.get(id);
		updater.builder()
		.id(transactionRecord.getId())
		.name(transactionRecord.getName())
		.tithes(transactionRecord.getTithes())
		.offering(transactionRecord.getOffering())
		.build();
		return updater;
	}

	@Override
	public void delete(Long id) {
		entries.remove(id);
	}
	
}
