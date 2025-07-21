package base.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@ResponseBody
public class AdminController {
  @GetMapping("/sitecontrol")
  public String admin() {

    return "Admin Controller";
  }
  
}
