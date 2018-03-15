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
@SequenceGenerator(name = "gen_work",sequenceName = "seq_lab_work")
@Table(name = "lab_work")
public class LaboratoryWork extends Work {
	@Override
	public String doWork() {
		return "do lab work";
	}
}
