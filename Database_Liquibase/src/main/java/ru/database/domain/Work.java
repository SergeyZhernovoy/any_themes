package ru.database.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Work {
	private Long id;
	private String description;
	private LocalDate moment;

}
