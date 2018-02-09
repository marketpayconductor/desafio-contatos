package com.conductor.contacts.contacts.contact;


import com.conductor.contacts.contacts.category.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact")
@AttributeOverride(name = "id", column = @Column(name = "contact_id"))
@Access(AccessType.FIELD)
public class Contact {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
