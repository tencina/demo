package cl.tencina.demo.service;

import cl.tencina.demo.model.Historial;
import cl.tencina.demo.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistorialService {

    @Autowired
    HistorialRepository historialRepository;

    public Historial insert(Historial historial){
        return historialRepository.save(historial);
    }

    public List<Historial> findAll(Integer inicio, Integer cantidad){
        Pageable paging = PageRequest.of(inicio, cantidad, Sort.by("id"));
        Page<Historial> result = historialRepository.findAll(paging);
        if(result.hasContent()) {
            return result.getContent();
        } else {
            return new ArrayList<Historial>();
        }
    }

}
