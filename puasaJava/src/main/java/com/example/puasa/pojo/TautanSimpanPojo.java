package com.example.puasa.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class TautanSimpanPojo {
    private String namaProgram;
    private Integer idPrograms;
    private String namaInstansi;
    private String namaKegiatan;
    private String alamat;
    private String namaPic;
    private String namaPicpt;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Asia/Jakarta")
    private Date tanggalMulai;
    private Date tanggalSelesai;
    private String status;


}
