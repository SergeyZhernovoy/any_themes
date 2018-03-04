package ru.database.domain;

import lombok.Data;

@Data
public class Result {
    private Long id;
    private Work refWork;
    private Integer estimate;
    private Person issueOfWork;
    private Person matchOfWork;
}
