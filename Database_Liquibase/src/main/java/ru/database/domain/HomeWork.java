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
@SequenceGenerator(name = "gen_work",sequenceName = "seq_home_work")
@Table(name = "home_work")
public class HomeWork extends Work{
	@Override
	public String doWork() {
		return "do home work";
	}
}
