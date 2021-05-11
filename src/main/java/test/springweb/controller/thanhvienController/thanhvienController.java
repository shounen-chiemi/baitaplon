package test.springweb.controller.thanhvienController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import test.springweb.entity2.thanhvien;
import test.springweb.service.thanhvienService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class thanhvienController {
    @Autowired
    private thanhvienService tvs;

    @RequestMapping("loginuser")
    public String indexAdmin(HttpServletRequest request, HttpServletResponse response, Model model){
        String taikhoan = request.getParameter("txtU");
        String matkhau = request.getParameter("txtP");

        thanhvien thanhvien = tvs.login(taikhoan,matkhau);
        if(Objects.nonNull(thanhvien)) {
            String name = thanhvien.getNhanvien().getHo() + " " + thanhvien.getNhanvien().getTendem() + " " + thanhvien.getNhanvien().getTen();
            model.addAttribute("thvien", name);
            request.getSession().setAttribute("thanhvien",name);
            return "admin/index-admin";
        }
        else
            return "index";
    }

    @RequestMapping("logout")
    public String index(HttpServletRequest request, RedirectAttributes redirect)
    {
        request.getSession().setAttribute("thanhvien",null);

        return "redirect:/index";
    }
}
