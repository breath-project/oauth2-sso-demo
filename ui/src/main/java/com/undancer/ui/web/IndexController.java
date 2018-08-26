package com.undancer.ui.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/")
public class IndexController {
    @GetMapping
    public Object home(Principal principal) {
        return "hello, " + principal.getName();
    }
}
