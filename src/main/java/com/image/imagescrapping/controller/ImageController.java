package com.image.imagescrapping.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class ImageController {

    @RequestMapping(value="/")
    public String index(){
        return "index";
    }
    @RequestMapping(value = {"/image"})
    public Map<String,String> getImage(){
        Map<String,String> map = new HashMap<>();
        map.put("hihi","example");
        return map;
    }
}
