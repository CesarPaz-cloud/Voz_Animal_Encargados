package com.cibertec.demo.service;

import com.cibertec.demo.model.Encargado;
import com.cibertec.demo.repository.EncargadosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EncargadoServiceImp implements EncargadoService{

    @Autowired
    private EncargadosRepository encargadosRepository;

    @Override
    public List<Encargado> listarEncargados() {
        return encargadosRepository.findAll();
    }

    @Override
    public void guardarEncargos(Encargado encargado) {
        encargadosRepository.save(encargado);
    }

    @Override
    public Encargado obtenerEncargados(long id) {
        Optional<Encargado> opcional = encargadosRepository.findById(id);
        Encargado encargado;
        if (opcional.isPresent()){
            encargado = opcional.get();
        }else {
            throw new RuntimeException("Encargado no encontrado por el Id"+ id);
        }
        return encargado;
    }

    @Override
    public void eliminarEncargados(long id) {
        encargadosRepository.deleteById(id);
    }
}
