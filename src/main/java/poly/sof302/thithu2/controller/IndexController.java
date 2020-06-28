package poly.sof302.thithu2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import poly.sof302.thithu2.entities.Chitietmonhoc;
import poly.sof302.thithu2.service.IChiTietMonHocService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    IChiTietMonHocService ctmhService;

    @GetMapping(value = {"/", "", "/index"})
    public String returnIndexPage(ModelMap model) {
        List<Chitietmonhoc> ctmhList = ctmhService.findAll();
        model.addAttribute("ctmhList", ctmhList);
        model.addAttribute("ctmh", new Chitietmonhoc());

        // Danh sách trên 5
        double diemCaoNhat = 0;
        Chitietmonhoc ctmhCaoNhat = null;
        List<Chitietmonhoc> ctmhListTren5 = new ArrayList<>();
        for (Chitietmonhoc ctmh : ctmhList) {
            double diemTB = (ctmh.getQuiz1() + ctmh.getQuiz2() + ctmh.getQuiz3()) / 3;
            if (diemTB > 5) {
                ctmhListTren5.add(ctmh);
                if (diemTB > diemCaoNhat) {
                    diemCaoNhat = diemTB;
                    ctmhCaoNhat = ctmh;
                }
            }
        }
        model.addAttribute("svDiemCaoNhat", ctmhCaoNhat);
        model.addAttribute("ctmhListTren5", ctmhListTren5);
        return "index";
    }

    @PostMapping("/add")
    public String addMonHoc(@ModelAttribute("ctmh") Chitietmonhoc ctmh) {
        ctmhService.saveOrUpdate(ctmh);
        return "redirect:/index";
    }
}
