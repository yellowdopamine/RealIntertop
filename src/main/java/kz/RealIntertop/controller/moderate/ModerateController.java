package kz.RealIntertop.controller.moderate;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/moderate")
public class ModerateController {
    @PreAuthorize("hasAnyRole('ROLE_MODER')")
    @GetMapping
    public String moderate(){
        return "/moderate/moder-page";
    }
}
