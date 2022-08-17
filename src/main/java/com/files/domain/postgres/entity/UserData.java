package com.files.domain.postgres.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "userdata")
public class UserData {
    @Id
    @Column(name = "user_id")
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="date_of_birth")
    private String dateOfBirth;

    @Column(name="last_update_date")
    private String lastUpdateDate;
}

