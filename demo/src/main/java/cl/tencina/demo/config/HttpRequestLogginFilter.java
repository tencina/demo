package cl.tencina.demo.config;

import cl.tencina.demo.model.Historial;
import cl.tencina.demo.service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Component
public class HttpRequestLogginFilter extends AbstractRequestLoggingFilter {

    @Autowired
    private HistorialService historialService;

    @Override
    protected void beforeRequest(HttpServletRequest httpServletRequest, String s) {
        Historial historial = new Historial();
        historial.setRequest(httpServletRequest.getRequestURI().toString());
        historial.setQuery(httpServletRequest.getQueryString());
        historialService.insert(historial);
    }

    @Override
    protected void afterRequest(HttpServletRequest httpServletRequest, String s) {
    }
}
