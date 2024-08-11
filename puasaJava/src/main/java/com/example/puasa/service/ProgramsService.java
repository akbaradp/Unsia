package com.example.puasa.service;

import com.example.puasa.Entity.Programs;
import com.example.puasa.Entity.Users;
import com.example.puasa.Utils.MessageModel;
import com.example.puasa.pojo.UserSimpanPojo;
import com.example.puasa.repository.ProgramsRepository;
import com.example.puasa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProgramsService {

@Autowired
private ProgramsRepository programsRepository;

    public ResponseEntity<MessageModel> getAll() {
        MessageModel msg = new MessageModel();
        try {
            List<Programs> data = programsRepository.findAll();
            if (data.isEmpty()) {
                msg.setStatus(true);
                msg.setMsg("Data Tidak Ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            } else {
                msg.setStatus(true);
                msg.setMsg("Success");
                msg.setData(data);
                return ResponseEntity.ok().body(msg);
            }
        }catch (Exception e){
            msg.setStatus(false);
            msg.setMsg(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }
    }

    public ResponseEntity<MessageModel> simpanPrograms(Programs programs) {
        MessageModel msg = new MessageModel();
        try {
            Programs data = programsRepository.save(programs);
            msg.setStatus(true);
            msg.setMsg("Success");
            msg.setData(data);
            return ResponseEntity.ok().body(msg);
        } catch (Exception e) {
            msg.setStatus(false);
            msg.setMsg(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }
    }
}
