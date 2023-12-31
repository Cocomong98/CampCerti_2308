package com.example.jspstarter.controller;

import com.example.jspstarter.Dao.CampDao;
import com.example.jspstarter.Vo.CampVo;
import com.example.jspstarter.view.PdfDownView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.*;

@Controller
@Slf4j
public class DemoController {

    @Autowired
    private CampDao campDao;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/form")
    public String form(@RequestParam String name, Model model) {
        model.addAttribute("name", name);


        System.out.print("form에서 addlist로 이동");
        return "addList";
    }

    @GetMapping("/addList")
    public String addList() {
        System.out.print("addlist 이동");
        return "addList";
    }

    @GetMapping("/updateform/{id}")
    public String updateform(@PathVariable("id")int id, Model model) {
        System.out.println("updateform 이동");
        model.addAttribute("user",campDao.getOneUser(id));
        return "updateform";
    }

    // form에서 submit을 누를 시 동작, Vo가 정보를 받아간다
    @PostMapping("/addList")
    public String addToList(CampVo vo, RedirectAttributes redirectAttributes) {
        int result = campDao.insertUser(vo);

        redirectAttributes.addFlashAttribute("userAdded", vo);

        System.out.println("addlist에서 camp로 이동");
        return "redirect:/camp";
    }

    @GetMapping("/camp")
    public String camp(Model model) {
        model.addAttribute("userList",campDao.getAllUser());
        return "camp";
    }

    @GetMapping("/form")
    public String form() {
        System.out.println("form으로 이동");
        return "form";
    }

    @PostMapping("/updateform/updateOk")
    public String updateOk(CampVo vo, RedirectAttributes redirectAttributes) {
        int result = campDao.updateUser(vo);

        redirectAttributes.addFlashAttribute("userUpdated", vo);
        System.out.println("updateOk를 통해 camp으로 이동");
        return "redirect:/camp";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id, Model model) {
        model.addAttribute("user",campDao.deleteUser(id));

        System.out.println("delete 통해 camp으로 이동");
        return "redirect:/camp";
    }

    @GetMapping("/pdf/{id}")
    public ModelAndView pdf(@PathVariable("id") int id) {
        CampVo user = campDao.getOneUser(id);

        Map<String, Object> model = new HashMap<>();
        model.put("user", user);

        System.out.println("PDF 만드는 중...");

        log.info("User information: {}", user);

        System.out.println("여기까지가 로그");

        return new ModelAndView(new PdfDownView(), model);
    }

    @GetMapping("/downLogs")
    public String logAndRedirect(Model model) {
        log.trace("trace message");
        log.debug("debug message");
        log.info("info message"); // default
        log.warn("warn message");
        log.error("error message");

        List<String> logMessages = new ArrayList<>();
        logMessages.add("trace message");
        logMessages.add("debug message");
        logMessages.add("info message");
        logMessages.add("warn message");
        logMessages.add("error message");
        model.addAttribute("logMessages", logMessages);

        // /downLogs 로 리다이렉트
        return "downLogs";
    }


}
