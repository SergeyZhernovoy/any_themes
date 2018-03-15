package ru.database.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@SequenceGenerator(name = "gen_work",sequenceName = "seq_summer_work")
@Table(name = "summer_work")
public class SummerWork extends Work {
	@Override
	public String doWork() {
		return "do summer work";
	}
}
