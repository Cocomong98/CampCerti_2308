package com.example.jspstarter.controller;

import com.example.jspstarter.Dao.CampDao;
import com.example.jspstarter.Vo.CampVo;
import com.example.jspstarter.view.PdfDownView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/downLogs")
    public String downLogs() {
        System.out.println("downlogs 이동");
        return "downLogs";
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


    //@GetMapping("/pdf")
//    @RequestMapping(value="pdf", method=RequestMethod.GET)
//    public String pdf(Model model){
//
//        System.out.print("pdf를 통해 출력으로 이동");
//
//        List<String> list = new ArrayList<String>();
//        list.add("Java");
//        list.add("파이썬");
//        list.add("R");
//        list.add("C++");
//        list.add("자바스크립트");
//        list.add("Ruby");
//        list.add("스칼라");
//        list.add("클로져");
//        list.add("자바");
//
//        //뷰에게 전달할 데이터 저장
//        model.addAttribute("list",list);
//
//        //출력할 뷰 이름 리턴
//        return "pdf";
//    }
    @RequestMapping(value = "pdf", method = RequestMethod.GET)
    public ModelAndView pdf() {
        List<String> list = new ArrayList<String>();
        list.add("캠프 수료증");
        list.add("캠프명");
        list.add("웹 서비스 캠프");
        list.add("수료자명");
        list.add("김수료");
        list.add("캠프 기간");
        list.add("230610~230810");
        list.add("한동대학교");

        Map<String, Object> model = new HashMap<>();
        model.put("list", list);

        return new ModelAndView(new PdfDownView(), model);
    }

}
