package ru.database.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@MappedSuperclass
@SequenceGenerator(name = "gen_work",sequenceName = "seq_work")
public class Work {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_work")
	private Long id;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDate moment;

}
