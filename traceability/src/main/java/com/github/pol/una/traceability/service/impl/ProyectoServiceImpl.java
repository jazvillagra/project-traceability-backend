package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.ProyectoDTO;
import com.github.pol.una.traceability.entities.Proyecto;
import com.github.pol.una.traceability.exceptions.ProjectException;
import com.github.pol.una.traceability.mapper.impl.ProyectoMapper;
import com.github.pol.una.traceability.repository.ProyectoRepository;
import com.github.pol.una.traceability.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author jheisecke
 */
@Service
public class ProyectoServiceImpl  implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;
    @Autowired
    private ProyectoMapper mapper;

    @Override
    public ProyectoDTO saveProject(ProyectoDTO proyectoDTO) {
        proyectoRepository.save(mapper.mapToEntity(proyectoDTO));
        return proyectoDTO;
    }

    @Override
    public List<ProyectoDTO> getAllProjects() {
        List<Proyecto> listaProyectos = proyectoRepository.findAll();
        List<ProyectoDTO> proyectoDTOS = new ArrayList<>();
        for(Proyecto proy : listaProyectos){
            ProyectoDTO proyectoDTO = mapper.mapToDto(proy);
            proyectoDTOS.add(proyectoDTO);
        }
        return proyectoDTOS;
    }

    @Override
    public ProyectoDTO getProjectById(Long id) throws ProjectException {
        Optional<Proyecto> proyecto = proyectoRepository.findById(id);
        if(proyecto.isPresent()) {
            return mapper.mapToDto(proyecto.get());
        } else {
            throw new ProjectException("notFound", "No se encontró el proyecto "+id);
        }
    }

    @Override
    public void deleteProject(Long id) throws ProjectException {
        Optional<Proyecto> proyecto = proyectoRepository.findById(id);
        if(proyecto.isPresent()) {
            proyectoRepository.delete(proyecto.get());
        } else {
            throw new ProjectException("notFound", "No se encontró el proyecto "+id);
        }
    }

}