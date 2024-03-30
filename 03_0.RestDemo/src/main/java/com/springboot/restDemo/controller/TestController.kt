package com.springboot.restDemo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {


    @GetMapping("/say-hello")
    fun test(): String {
        return "Hello world from Kotlin!!"
    }


}