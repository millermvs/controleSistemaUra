package br.com.lognetbr.filters;

import java.io.IOException;
import java.util.Set;

import org.springframework.web.filter.GenericFilterBean;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends GenericFilterBean {

    private final String secretKey;

    // Endpoints que NÃO precisam de token
    private static final Set<String> PUBLIC_ENDPOINTS = Set.of(
        "/api/v1/usuario/criar",
        "/api/v1/usuario/autenticar"
    );

    public JwtAuthFilter(String secretKey) {
        this.secretKey = secretKey;
    }

    private boolean isPublic(HttpServletRequest request) {
        String path = request.getRequestURI();
        return PUBLIC_ENDPOINTS.contains(path);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Libera OPTIONS e os endpoints públicos
        if ("OPTIONS".equalsIgnoreCase(request.getMethod()) || isPublic(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Acesso não autorizado.");
            return;
        }

        try {
            final String token = authHeader.substring(7);
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();

            request.setAttribute("claims", claims);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido ou expirado.");
        }
    }
}
