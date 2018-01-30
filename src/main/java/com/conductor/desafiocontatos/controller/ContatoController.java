package com.conductor.desafiocontatos.controller;

import com.conductor.desafiocontatos.model.Contato;
import com.conductor.desafiocontatos.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller class responsible for handler HTTP requests.
 *
 * @author: Cássio Espíndola
 */
@Controller
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(Contato contato) {
        ModelAndView mv = new ModelAndView("/create");
        mv.addObject("contato", contato);
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("contato") Contato contato, BindingResult result) {
        contatoService.save(contato);
        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllContatos() {
        ModelAndView mv = new ModelAndView("/index");
        mv.addObject("contatos", contatoService.getAllContatos());
        return mv;
    }

    @RequestMapping(path = "edit/{id}", method = RequestMethod.POST)
    public String editContato(@ModelAttribute Contato contato) {
        contatoService.save(contato);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editContato(@PathVariable(value = "id") Long contatoId) {
        ModelAndView mav = new ModelAndView("edit");
        mav.addObject("contato", contatoService.getContatoById(contatoId));
        return mav;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteContato(@PathVariable(value = "id") Long contatoId, HttpServletResponse response) {
        contatoService.deleteContato(contatoId);
        return "redirect:/";
    }
}
