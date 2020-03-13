package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.exceptions.RolException;

import java.util.List;

public interface RolService {

    List<RolDTO> getAll();

    RolDTO getRolById(Long id) throws RolException;

    RolDTO getRolByNombre(String nombre) throws RolException;
}
