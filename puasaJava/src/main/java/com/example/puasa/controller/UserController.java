package com.example.puasa.controller;

import com.example.puasa.Entity.Users;
import com.example.puasa.Utils.MessageModel;
import com.example.puasa.pojo.*;
import com.example.puasa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/simpanNamaKegiatan")
    public ResponseEntity<MessageModel> simpanNamaKegiatan(@RequestBody UserSimpanPojo user){
        ResponseEntity responseEntity = userService.simpanNamaKegiatan(user);
        return responseEntity;
    }

    @PostMapping("/editNamaKegiatan")
    public ResponseEntity<MessageModel> editNamaKegiatan(@RequestBody UserEditPojo userEditPojo){
        ResponseEntity responseEntity = userService.editNamaKegiatan(userEditPojo);
        return responseEntity;
    }

    @GetMapping("getById")
    public ResponseEntity<MessageModel> testingGetById(@RequestParam(value = "idUser", required = false) Integer idUser){
        ResponseEntity responseEntity = userService.getById(idUser);
        return responseEntity;
    }

    @GetMapping("/getDataLeads")
    public ResponseEntity<?> dataLeads(@RequestParam(value = "programs", required = false) String programs) {
        ResponseEntity responseEntity = userService.dataLeads(programs);
        return responseEntity;
    }

    @PostMapping("/simpanTautan")
    public ResponseEntity<MessageModel> simpanTautan(@RequestBody TautanSimpanPojo tautanSimpanPojo){
        ResponseEntity responseEntity = userService.simpanTautan(tautanSimpanPojo);
        return responseEntity;
    }

    @PostMapping("/editTautan")
    public ResponseEntity<MessageModel> editTautan(@RequestBody TautanEditPojo tautanEditPojo){
        ResponseEntity responseEntity = userService.editTautan(tautanEditPojo);
        return responseEntity;
    }

    @GetMapping("getByIdTautan")
    public ResponseEntity<MessageModel> getByIdTautan(@RequestParam(value = "idUser", required = false) Integer idUser){
        ResponseEntity responseEntity = userService.getByIdTautan(idUser);
        return responseEntity;
    }

    @GetMapping("/getDataTautan")
    public ResponseEntity<List<TautanDataPojo>> getDataTautan(@RequestParam(value = "programs", required = false) String programs) {
        List<TautanDataPojo> usersWithPrograms = userService.getDataTautan(programs);
        return ResponseEntity.ok(usersWithPrograms);
    }
}
