package com.upc.ninera360.controllers;

import com.upc.ninera360.dtos.UserProfileDTO;
import com.upc.ninera360.entities.UserProfile;
import com.upc.ninera360.services.UserProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios") // Ruta para tu módulo
public class UserProfileController {

    @Autowired
    private UserProfileService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public UserProfileDTO registrar(@RequestBody UserProfileDTO dto) {
        UserProfile entidad = modelMapper.map(dto, UserProfile.class);
        UserProfile guardado = userService.guardar(entidad);
        return modelMapper.map(guardado, UserProfileDTO.class);
    }

    @GetMapping
    public List<UserProfileDTO> listar() {
        return userService.listarTodo().stream()
                .map(user -> modelMapper.map(user, UserProfileDTO.class))
                .collect(Collectors.toList());
    }
}
