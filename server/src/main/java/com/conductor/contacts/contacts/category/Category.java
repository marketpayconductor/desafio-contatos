package com.conductor.contacts.contacts.category;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "category")
@AttributeOverride(name = "id", column = @Column(name = "category_id"))
@Access(AccessType.FIELD)
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
}
