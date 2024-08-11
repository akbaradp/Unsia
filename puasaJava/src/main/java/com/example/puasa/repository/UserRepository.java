package com.example.puasa.repository;

import com.example.puasa.Entity.Users;
import com.example.puasa.pojo.TautanDataPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    //Pelajari lagi besok
//    @Query("SELECT u FROM UsersDataLeadsPojo u JOIN u.program p WHERE p.name = :programName")
//    List<UsersDataLeadsPojo> findByProgramName(@Param("programName") String programName);

    @Query("SELECT new com.example.puasa.pojo.TautanDataPojo(u.namaProgram, u.tanggalMulai, u.tanggalSelesai, p.idPrograms, p.programs, u.status) " +
            "FROM Users u " +
            "JOIN Programs p ON u.idPrograms = p.idPrograms " +
            "WHERE (:programs IS NULL OR p.programs = :programs)")
    List<TautanDataPojo> getDataTautan(@Param("programs") String programs);

}
