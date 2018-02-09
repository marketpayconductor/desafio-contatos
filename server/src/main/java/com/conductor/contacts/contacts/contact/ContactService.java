package com.conductor.contacts.contacts.contact;

import java.util.List;

public interface ContactService {

    List<ContactDTO> findAll();
    ContactDTO getOne(Long id);
    ContactDTO save(ContactDTO contact);
    ContactDTO update(Long id, ContactDTO contact);
    void remove(Long id);
    List<ContactDTO> search(String name);
    List<ContactDTO> findByCategoryId(Long categoryId);
}
