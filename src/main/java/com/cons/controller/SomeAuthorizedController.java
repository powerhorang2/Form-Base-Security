package com.cons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cons.service.SomeAuthorizedService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SomeAuthorizedController {
    private final SomeAuthorizedService someAuthorizedService;
    
     @GetMapping("/admin")
    public String admin(){
        log.info("in the admin");
        return "ok";
    }
   
     @GetMapping("/admin/admin-service")
     public String adminPathAdminService() {
    	 log.info("in the admin admin");
    	 someAuthorizedService.adminCanAccess();
    	 return "ok";
     }
     
    @GetMapping("/general")
    public String general(){
        log.info("in the general");
        return "ok";
    }
    
    @GetMapping("/general/general-service")
    public String generalPathGeneralService(){
        log.info("in the general general");
        someAuthorizedService.generalCanAccess();
        return "ok";
    }
    
    @GetMapping("/anonymous-service")
    public String anonymousService(){
        someAuthorizedService.anonymousCanAccess();
        return "ok";
    }
}