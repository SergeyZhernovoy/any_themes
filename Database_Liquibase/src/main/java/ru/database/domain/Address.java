package ru.database.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Address implements Serializable {
	private static final long serialVersionUID = 5375077975994305468L;
	private String description;
	@NonNull
	private String fias;
	private Integer house;
	private Integer flat;
}
