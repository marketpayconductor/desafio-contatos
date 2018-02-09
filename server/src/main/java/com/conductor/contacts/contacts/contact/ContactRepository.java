package com.conductor.contacts.contacts.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findAllByNameContains(String name);

    List<Contact> findAllByCategoryId(Long categoryId);

}
