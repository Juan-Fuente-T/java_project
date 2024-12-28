package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//OTRO MODO DE HACERLO
//@Controller
//public class OwnerController {
//    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
//    public String listOwners(){
//        return "owners/index";
//    }
//}
//OTRO MODO DE HACERLO
@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}