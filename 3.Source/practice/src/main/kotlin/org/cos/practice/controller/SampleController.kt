package org.cos.practice.controller

import lombok.extern.log4j.Log4j2
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping

@Controller
@Log4j2
@RequestMapping("/sample/")
internal class SampleController {
    @GetMapping("/all")
    fun exAll() {
        //SampleController.log.info("exAll..........")
    }

    @GetMapping("/member")
    fun exMember() {
        //SampleController.log.info("exMember..........")
    }

    @GetMapping("/admin")
    fun exAdmin() {
        //SampleController.log.info("exAdmin..........")
    }
}