package config;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalRestController {

    @RequestMapping("/user")
    Principal pricipal(Principal principal) {
        return principal;
    }
}
