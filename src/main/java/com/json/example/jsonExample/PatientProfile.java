package com.json.example.jsonExample;


import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

@Entity
@Data
@Table(name = "patient_profile")
public class PatientProfile implements Serializable {

    @Id
    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    /* This converter does the trick */
    @Convert(converter = StringMapConverter.class)
    private Map<String, Object> otherAttributes;

    //@Convert(converter = HashMapConverter.class)
    //private Map<String, Object> customerAttributes;

}
