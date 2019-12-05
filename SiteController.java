package mobyDickensBookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping(value = "/contact-us")
    public String contactUs() {
        return "contactUs";
    }

    @GetMapping(value = "/search")
    public String search() {
        return "search";
    }

}
