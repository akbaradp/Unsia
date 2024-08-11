package com.example.puasa.controller;

import com.example.puasa.Entity.Programs;
import com.example.puasa.Utils.MessageModel;
import com.example.puasa.pojo.UserSimpanPojo;
import com.example.puasa.service.ProgramsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/programs")
public class ProgramsController {

    @Autowired
    private ProgramsService programsService;

    @PostMapping("/simpanPrograms")
    public ResponseEntity<MessageModel> simpanPrograms(@RequestBody Programs Programs){
        ResponseEntity responseEntity = programsService.simpanPrograms(Programs);
        return responseEntity;
    }

    @GetMapping("/getAll")
    public ResponseEntity<MessageModel> getAll(){
        ResponseEntity responseEntity = programsService.getAll();
        return responseEntity;
    }


}
