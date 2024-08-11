package com.example.puasa.repoclass;

import com.example.puasa.pojo.UsersDataLeadsPojo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserRepositoryClass {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UsersDataLeadsPojo> dataLeads(String programs)
    {
        StringBuilder qb = new StringBuilder();

        if(programs !=null ){
            qb.append(" and p2.programs = :programs \n");
        }

        String sisipan = qb.toString();

        //untuk sisipan yang ditengah

        String QueryText="SELECT u2.id_user as idUser, u2.nama_lengkap as nama, u2.email, u2.no_hp as noHp, p2.programs as programs \n" +
                "from unsia.users u2 \n" +
                "LEFT JOIN unsia.programs p2   \n" +
                "ON u2.id_programs = p2.id_programs  " +
                "WHERE 1=1 \n" +sisipan;

        Query query = entityManager.createNativeQuery(QueryText);
        if(programs !=null){
            query.setParameter("programs",programs);
        }



        List hasil= query.getResultList();
        List<UsersDataLeadsPojo> result = new ArrayList<>();

        Iterator itr = hasil.iterator();
        while(itr.hasNext()){
            UsersDataLeadsPojo browse = new UsersDataLeadsPojo();
            Object[] obj = (Object[]) itr.next();
            Integer idUser = (Integer) obj[0];
            String nama = String.valueOf(obj[1]);
            String email = String.valueOf(obj[2]);
            String noHp= String.valueOf(obj[3]);
            String program= String.valueOf(obj[4]);

            browse.setIdUser(idUser);
            browse.setNama(nama);
            browse.setEmail(email);
            browse.setNoHp(noHp);
            browse.setProgram(program);
            result.add(browse);
        }
        return result;
    }
}
