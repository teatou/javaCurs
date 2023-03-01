package com.example.kr1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import  org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controllers {
    @Autowired
    private MachineService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Machine> listMachines = service.listAll(keyword);
        model.addAttribute("ListMachines", listMachines);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewMachineForm(Model model){
        Machine machine = new Machine();
        model.addAttribute("machine", machine);
        return "new_machine";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveMachine(@ModelAttribute("machine") Machine machine) {
        service.save(machine);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditMachineForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_machine");
        Machine machine = service.get(id);
        mav.addObject("machine", machine);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteMachine(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
