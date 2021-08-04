package cl.tencina.demo.repository;

import cl.tencina.demo.model.Historial;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HistorialRepository extends PagingAndSortingRepository<Historial, Long> {

}
