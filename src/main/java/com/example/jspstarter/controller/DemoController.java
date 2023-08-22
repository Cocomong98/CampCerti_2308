package com.example.jspstarter.controller;

import com.example.jspstarter.Dao.CampDao;
import com.example.jspstarter.Vo.CampVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
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
        System.out.print("updateform 이동");
        model.addAttribute("user",campDao.getOneUser(id));
        return "updateform";
    }

    // form에서 submit을 누를 시 동작, Vo가 정보를 받아간다
    @PostMapping("/addList")
    public String addToList(CampVo vo) {
        int result = campDao.insertUser(vo);

        System.out.print("addlist에서 camp로 이동");
        return "camp";
    }

    @GetMapping("/downLogs")
    public String downLogs() {
        System.out.print("downlogs 이동");
        return "downLogs";
    }

    @GetMapping("/camp")
    public String camp(Model model) {
        model.addAttribute("userList",campDao.getAllUser());
        return "camp";
    }

    @GetMapping("/form")
    public String form() {
        System.out.print("form으로 이동");
        return "form";
    }

    @PostMapping("/updateOk")
    public String updateOk() {

        return "camp";
    }
}
