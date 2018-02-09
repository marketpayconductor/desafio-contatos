package com.conductor.contacts.contacts.contact;

import com.conductor.contacts.contacts.category.CategoryDTO;
import lombok.Data;

@Data
public class ContactDTO {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;

    private CategoryDTO category;
}
