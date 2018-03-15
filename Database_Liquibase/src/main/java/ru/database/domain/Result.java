package ru.database.domain;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "results")
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@OneToOne
	@JoinColumn(name = "id_work")
    private LaboratoryWork refWork;
    private Integer estimate;
    @OneToOne
    @JoinColumn(name = "id_issuer")
    private Person issueOfWork;
    @OneToOne
    @JoinColumn(name = "id_matcher")
    private Person matchOfWork;
}
