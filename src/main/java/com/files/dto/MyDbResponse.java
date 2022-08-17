package com.files.dto;

import lombok.Data;
import java.sql.Date;

@Data
public class MyDbResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String lastUpdateDate;
}
