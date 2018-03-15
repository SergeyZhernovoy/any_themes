package ru.database.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Work implements ExecuteWork {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_work")
	private Long id;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date moment;

}
