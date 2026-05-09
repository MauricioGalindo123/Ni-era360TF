package com.upc.ninera360.entities;

import jakarta.persistence.*;
import lombok.*;
import com.upc.ninera360.security.entities.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre", length = 250)
    private String nombre;

    @Column(name = "dni") // INT en tu diagrama
    private Integer dni;

    @Column(name = "direccion", length = 250)
    private String direccion;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "correo", length = 250)
    private String correo;

    // Relación con la tabla de seguridad (user_id)
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}