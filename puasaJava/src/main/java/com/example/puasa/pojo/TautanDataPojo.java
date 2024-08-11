package com.example.puasa.pojo;
import lombok.Data;


import java.util.Date;

@Data
public class TautanDataPojo {
    private String namaProgram;
    private Date tanggalMulai;
    private Date tanggalSelesai;
    private Integer idPrograms;
    private String programs;
    private String status;

    // Konstruktor yang digunakan oleh JPQL
    public TautanDataPojo(String namaProgram, Date tanggalMulai, Date tanggalSelesai, Integer idPrograms, String programs, String status) {
        this.namaProgram = namaProgram;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.idPrograms = idPrograms;
        this.programs = programs;
        this.status = status;
    }
}


