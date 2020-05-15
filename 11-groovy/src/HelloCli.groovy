import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Grab("org.springframework.boot:spring-boot-starter-thymeleaf:2.1.8.RELEASE")
@Grab("org.webjars:jquery")
@Controller
class HelloCli {
    @RequestMapping("/")
    String home(Model model) {
       model.addAttribute("name", "HelloWorld Groovy")
        return "welcome"
    }
}
