package com.lively.io.ExcelApp.tableGenerator.DomainObjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

@Value
@AllArgsConstructor
@Getter
@Builder
@ToString
public class TransactionRecord {
	private Long id;
	private String name;
	private float tithes;
	private float offering;
	private String accountNumber;
}
