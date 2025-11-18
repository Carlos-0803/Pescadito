package com.example.Pescadito.Service;
import com.example.Pescadito.Model.Combinado;
import com.example.Pescadito.Repository.CombinadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombinadoService {
    private final  CombinadoRepository combinadoRepository;

    public CombinadoService(CombinadoRepository combinadoRepository){
        this.combinadoRepository = combinadoRepository;
    }

    public List<Combinado> listarTodas(){
        return combinadoRepository.findAll();
    }

    public Optional<Combinado> buscarPorID(Long id){
        return combinadoRepository.findById(id);
    }

    public Combinado crearCombinado(Combinado combinado){
        return  combinadoRepository.save(combinado);
    }

    public Combinado actualizarCombinado(Long id, Combinado combinado){
        combinado.setId(id);
        return combinadoRepository.save(combinado);
    }

    public void eliminarCombinado(Long id){
        combinadoRepository.deleteById(id);
    }
}

