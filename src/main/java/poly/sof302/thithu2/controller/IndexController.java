package poly.sof302.thithu2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import poly.sof302.thithu2.entities.Chitietmonhoc;
import poly.sof302.thithu2.service.IChiTietMonHocService;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    IChiTietMonHocService ctmhService;

    @GetMapping(value = {"/", "" ,"/index"})
    public String returnIndexPage(ModelMap model) {
        List<Chitietmonhoc> ctmhList = ctmhService.findAll();
        model.addAttribute("ctmhList", ctmhList);
        model.addAttribute("ctmh", new Chitietmonhoc());
        return "index";
    }

    @PostMapping("/add")
    public String addMonHoc(@ModelAttribute("ctmh") Chitietmonhoc ctmh){
        ctmhService.saveOrUpdate(ctmh);
        return "redirect:/index";
    }
}
