package ru.alex.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alex.dao.PersonDao;
import ru.alex.model.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDao;

    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", personDao.findAll());

        return "/people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        Person person = personDao.findById(id);

        model.addAttribute("person", person);
        model.addAttribute("books", personDao.getAllBooks(id));

        return "/people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute Person person) {
        return "/people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        // Make validate if it needs

        if (bindingResult.hasErrors()) {
            return "/people/new";
        }

        personDao.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("person", personDao.findById(id));

        return "/people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult, @PathVariable int id) {
        // Make an email check

        if (bindingResult.hasErrors()) {
            return "/people/edit";
        }

        personDao.update(id, person);
        return "redirect:/people/{id}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        personDao.delete(id);

        return "redirect:/people";
    }
}
