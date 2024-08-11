package com.example.puasa.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "programs", schema = "unsia")
public class Programs implements Serializable {

    @Id
    @Column(name = "id_programs", nullable = false)
    private Integer idPrograms;

    @Column(name = "programs", nullable = false)
    private String programs;
}
