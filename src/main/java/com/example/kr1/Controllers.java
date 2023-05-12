package com.example.kr1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controllers {
    @Autowired
    private RecordService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Record> listRecords = service.listAll(keyword);
        model.addAttribute("ListRecords", listRecords);
        model.addAttribute("keyword", keyword);
        return "index";
    }
    @RequestMapping("/gist")
    public String gist(Model model, @Param("keyword") String keyword) {
        List<Record> listRecords = service.listAll(keyword);
        model.addAttribute("listRecords", listRecords);
        model.addAttribute("keyword", keyword);
        return "gist";
    }

    @RequestMapping("/new")
    public String showNewRecordForm(Model model){
        Record record = new Record();
        model.addAttribute("record", record);
        return "new_record";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRecord(@ModelAttribute("record") Record record) {
        service.save(record);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditRecordForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_record");
        Record record = service.get(id);
        mav.addObject("record", record);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteRecord(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
