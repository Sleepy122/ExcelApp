package com.lively.io.ExcelApp.routes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lively.io.ExcelApp.tableGenerator.LivelyRepository;
import com.lively.io.ExcelApp.tableGenerator.DomainObjects.TransactionRecord;

@RestController
@RequestMapping(value = "/lively/api/v1")
public class Controller {

	@Autowired
	LivelyRepository livelyRepo;
	
	@GetMapping("/test/getRecord/{id}")
	public String getTransactionRecordData(@PathVariable Long id) {
		
		return  livelyRepo.find(id).toString();
	}
	
	@GetMapping("/test/getAllRecords")
	public ResponseEntity<List<TransactionRecord>> getAllRecords(){
		return new ResponseEntity<>(livelyRepo.list(), HttpStatus.OK);
	}
	
	@GetMapping("/test/deleteRecords/{id}")
	public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
			livelyRepo.delete(id);
		return new ResponseEntity<>("deleted", HttpStatus.OK);
	}
	
	@PostMapping("/test/updateRecord/")
	public ResponseEntity<String> updateRecord(@RequestParam TransactionRecord transactionRecord) {
		livelyRepo.update(transactionRecord.getId(), transactionRecord);
		return new ResponseEntity<>("updated", HttpStatus.OK);

	}
	
	@PostMapping("/test/createRecord")
	public ResponseEntity<String> createRecord(@RequestParam TransactionRecord transactionRecord) {
		livelyRepo.create(transactionRecord);
		return new ResponseEntity<>("created", HttpStatus.OK);

	}
}
