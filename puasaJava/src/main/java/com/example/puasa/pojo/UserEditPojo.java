package com.example.puasa.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class UserEditPojo {
    private Integer idUser;
    private String namaLengkap;
    private String alamat;
    private Date tanggalLahir;
    private String email;
    private String noHp;
    private String namaInstansi;
    private String jabatan;
    private String namaInstagram;
    private String namaFacebook;
    private Integer idPrograms;
}
