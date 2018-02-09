package com.conductor.contacts.contacts.contact;

import com.conductor.contacts.contacts.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ContactDTO> findAll() {
        return contactRepository.findAll()
                .stream()
                .map(contact -> modelMapper.map(contact, ContactDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ContactDTO getOne(Long id) {
        Contact contact = contactRepository.findOne(id);
        if(contact == null) {
            throw new NotFoundException();
        }

        return modelMapper.map(contact, ContactDTO.class);
    }

    @Override
    public ContactDTO save(ContactDTO contactDto) {
        Contact contact = modelMapper.map(contactDto, Contact.class);
        contact = contactRepository.save(contact);
        return modelMapper.map(contact, ContactDTO.class);
    }

    @Override
    public ContactDTO update(Long id, ContactDTO contactDTO) {
        boolean exists = contactRepository.exists(id);
        if(!exists) {
            throw new NotFoundException();
        }
        contactDTO.setId(id);
        return save(contactDTO);
    }

    @Override
    public void remove(Long id) {
        Contact contact = contactRepository.findOne(id);
        if(contact == null) {
            throw new NotFoundException();
        }
        contactRepository.delete(contact);
    }

    @Override
    public List<ContactDTO> search(String name) {
        return contactRepository.findAllByNameContains(name)
                .stream()
                .map(contact -> modelMapper.map(contact, ContactDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ContactDTO> findByCategoryId(Long categoryId) {
        return contactRepository.findAllByCategoryId(categoryId).stream()
                .map(contact -> modelMapper.map(contact, ContactDTO.class))
                .collect(Collectors.toList());
    }
}
