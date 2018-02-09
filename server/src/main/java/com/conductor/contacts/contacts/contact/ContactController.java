package com.conductor.contacts.contacts.contact;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<ContactDTO> list() {
        return contactService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ContactDTO create(@RequestBody ContactDTO contact) {
        return contactService.save(contact);
    }

    @RequestMapping(path = "{id}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ContactDTO update(@RequestBody ContactDTO contact, @PathVariable Long id) {
        return contactService.update(id, contact);
    }

    @RequestMapping(path = "{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        contactService.remove(id);
    }


    @RequestMapping(path = "{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ContactDTO getOne(@PathVariable Long id) {
        return contactService.getOne(id);
    }

    @RequestMapping(path = "search",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<ContactDTO> search(@Param("name") String name) {
        return contactService.search(name);
    }

    @RequestMapping(path = "category/{categoryId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<ContactDTO> search(@PathVariable Long categoryId) {
        return contactService.findByCategoryId(categoryId);
    }

}
