package com.cibertec.demo.service;



import com.cibertec.demo.model.Encargados;

import java.util.List;

public interface EncargadoService {
    List<Encargados> listarEncargados();
    void guardarEncargos(Encargados encargados);
    Encargados obtenerEncargados(long id);
    void eliminarEncargados (long id);
}
