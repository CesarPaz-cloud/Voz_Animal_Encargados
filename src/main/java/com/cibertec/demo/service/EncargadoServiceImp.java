package com.cibertec.demo.service;

import com.cibertec.demo.model.Encargados;
import com.cibertec.demo.repository.EncargadosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EncargadoServiceImp implements EncargadoService{

    @Autowired
    private EncargadosRepository encargadosRepository;

    @Override
    public List<Encargados> listarEncargados() {
        return encargadosRepository.findAll();
    }

    @Override
    public void guardarEncargos(Encargados encargados) {
        encargadosRepository.save(encargados);
    }

    @Override
    public Encargados obtenerEncargados(long id) {
        Optional<Encargados> opcional = encargadosRepository.findById(id);
        Encargados encargados;
        if (opcional.isPresent()){
            encargados = opcional.get();
        }else {
            throw new RuntimeException("Encargado no encontrado por el Id"+ id);
        }
        return encargados;
    }

    @Override
    public void eliminarEncargados(long id) {
        encargadosRepository.deleteById(id);
    }
}
