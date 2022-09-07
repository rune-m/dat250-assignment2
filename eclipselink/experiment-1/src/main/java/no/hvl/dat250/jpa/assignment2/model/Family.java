package no.hvl.dat250.jpa.assignment2.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String description;

    @OneToMany(mappedBy = "family")
    private final List<Person> members = new ArrayList<Person>();
}