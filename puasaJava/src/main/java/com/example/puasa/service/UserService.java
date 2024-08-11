package com.example.puasa.service;

import com.example.puasa.Entity.Users;
import com.example.puasa.Utils.MessageModel;
import com.example.puasa.pojo.*;
import com.example.puasa.repoclass.UserRepositoryClass;
import com.example.puasa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryClass userRepositoryClass;

    public ResponseEntity<MessageModel> getAll() {
        MessageModel msg = new MessageModel();
        try {
            List<Users> data = userRepository.findAll();
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

    public ResponseEntity<MessageModel>getById(Integer idUser){
        MessageModel msg = new MessageModel();
        try{
            Map<String, Object> result = new HashMap<>();
            Optional<Users> data =  userRepository.findById(idUser);
            if(data.isEmpty()){
                msg.setStatus(true);
                msg.setMsg("Data tidak Ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else{
                msg.setStatus(true);
                msg.setMsg("SUCCESS");
                result.put("Data", data);
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            }
        }catch(Exception e){
            msg.setStatus(false);
            msg.setMsg(msg.getMsg());
            return ResponseEntity.ok().body(msg);
        }
    }

    public ResponseEntity<MessageModel> simpanNamaKegiatan(UserSimpanPojo userSimpanPojo) {
        MessageModel msg = new MessageModel();
        try {
            Users users = new Users();
            users.setNamaLengkap(userSimpanPojo.getNamaLengkap());
            users.setAlamat(userSimpanPojo.getAlamat());
            users.setTanggalLahir(userSimpanPojo.getTanggalLahir());
            users.setEmail(userSimpanPojo.getEmail());
            users.setNoHp(userSimpanPojo.getNoHp());
            users.setNamaInstansi(userSimpanPojo.getNamaInstansi());
            users.setJabatan(userSimpanPojo.getJabatan());
            users.setNamaInstagram(userSimpanPojo.getNamaInstagram());
            users.setNamafacebook(userSimpanPojo.getNamaFacebook());
            users.setIdPrograms(userSimpanPojo.getIdPrograms());

            Users data = userRepository.save(users);
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


    public ResponseEntity<MessageModel> editNamaKegiatan(UserEditPojo userEditPojo) {
        MessageModel msg = new MessageModel();
        try {
            Users users = userRepository.findById(userEditPojo.getIdUser())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            users.setIdUser(userEditPojo.getIdUser());
            users.setNamaLengkap(userEditPojo.getNamaLengkap());
            users.setAlamat(userEditPojo.getAlamat());
            users.setTanggalLahir(userEditPojo.getTanggalLahir());
            users.setEmail(userEditPojo.getEmail());
            users.setNoHp(userEditPojo.getNoHp());
            users.setNamaInstansi(userEditPojo.getNamaInstansi());
            users.setJabatan(userEditPojo.getJabatan());
            users.setNamaInstagram(userEditPojo.getNamaInstagram());
            users.setNamafacebook(userEditPojo.getNamaFacebook());
            users.setIdPrograms(userEditPojo.getIdPrograms());

            Users data = userRepository.save(users);
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


    public ResponseEntity<?> dataLeads(String programs) {
        Map<String, Object> response = new HashMap<>();
        try {
//            UsersDataLeadsPojo users = new UsersDataLeadsPojo();
            List<UsersDataLeadsPojo> user = userRepositoryClass.dataLeads(programs);

            if (user.isEmpty()) {
                response.put("status", true);
                response.put("msg", "Data tidak ditemukan");
                response.put("data", null);
            } else {
                response.put("msg", "SUCCESS");
                response.put("data", user);
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", false);
            response.put("msg", "Terjadi kesalahan: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    public ResponseEntity<MessageModel> simpanTautan(TautanSimpanPojo tautanSimpanPojo) {
        MessageModel msg = new MessageModel();
        try {
            Users users = new Users();
            users.setNamaProgram(tautanSimpanPojo.getNamaProgram());
            users.setIdPrograms(tautanSimpanPojo.getIdPrograms());
            users.setNamaInstansi(tautanSimpanPojo.getNamaInstansi());
            users.setNamaKegiatan(tautanSimpanPojo.getNamaKegiatan());
            users.setAlamat(tautanSimpanPojo.getAlamat());
            users.setNamaPic(tautanSimpanPojo.getNamaPic());
            users.setNamaPicpt(tautanSimpanPojo.getNamaPicpt());
            users.setTanggalMulai(tautanSimpanPojo.getTanggalMulai());
            users.setTanggalSelesai(tautanSimpanPojo.getTanggalSelesai());
            users.setStatus(tautanSimpanPojo.getStatus());

            Users data = userRepository.save(users);
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

    public ResponseEntity<MessageModel> editTautan(TautanEditPojo tautanEditPojo) {
        MessageModel msg = new MessageModel();
        try {
            Users users = userRepository.findById(tautanEditPojo.getIdUser())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            users.setIdUser(tautanEditPojo.getIdUser());
            users.setIdPrograms(tautanEditPojo.getIdPrograms());
            users.setNamaInstansi(tautanEditPojo.getNamaInstansi());
            users.setNamaKegiatan(tautanEditPojo.getNamaKegiatan());
            users.setAlamat(tautanEditPojo.getAlamat());
            users.setNamaPic(tautanEditPojo.getNamaPic());
            users.setNamaPicpt(tautanEditPojo.getNamaPicpt());
            users.setTanggalMulai(tautanEditPojo.getTanggalMulai());
            users.setTanggalSelesai(tautanEditPojo.getTanggalSelesai());
            users.setLink(tautanEditPojo.getLink());
            users.setQrCode(tautanEditPojo.getQrCode());

            Users data = userRepository.save(users);
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

    public ResponseEntity<MessageModel>getByIdTautan(Integer idUser){
        MessageModel msg = new MessageModel();
        try{
            Map<String, Object> result = new HashMap<>();
            Optional<Users> data =  userRepository.findById(idUser);
            if(data.isEmpty()){
                msg.setStatus(true);
                msg.setMsg("Data tidak Ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else{
                msg.setStatus(true);
                msg.setMsg("SUCCESS");
                result.put("Data", data);
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            }
        }catch(Exception e){
            msg.setStatus(false);
            msg.setMsg(msg.getMsg());
            return ResponseEntity.ok().body(msg);
        }
    }

//    public List<TautanDataPojo> getDataPrograms() {
//        return userRepository.getDataPrograms();
//    }

    public List<TautanDataPojo> getDataTautan(String programs) {
        return userRepository.getDataTautan(programs);
    }

}