package com.example.puasa.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", schema = "unsia")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "tanggal_lahir")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalLahir;

    @Column(name = "email")
    private String email;

    @Column(name = "no_hp")
    private String noHp;

    @Column(name = "nama_instansi")
    private String namaInstansi;

    @Column(name = "jabatan")
    private String jabatan;

    @Column(name = "nama_instagram")
    private String namaInstagram;

    @Column(name = "nama_facebook")
    private String namafacebook;

    @Column(name = "id_programs")
    private Integer idPrograms;

    @Column(name = "nama_program")
    private String namaProgram;

    @Column(name = "nama_kegiatan")
    private String namaKegiatan;

    @Column(name = "nama_pic")
    private String namaPic;

    @Column(name = "tanggal_mulai")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalMulai;

    @Column(name = "tanggal_selesai")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalSelesai;

    @Column(name = "status", length = 2)
    private String status;

    @Column(name = "nama_picpt")
    private String namaPicpt;

    @Column(name = "link")
    private String link;

    @Column(name = "qr_code")
    private String qrCode;

}



