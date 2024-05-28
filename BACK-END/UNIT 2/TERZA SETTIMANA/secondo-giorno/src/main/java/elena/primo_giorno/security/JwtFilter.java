package elena.primo_giorno.security;

import elena.primo_giorno.exception.DipendenteNonTrovatoException;
import elena.primo_giorno.exception.UnathorizedException;
import elena.primo_giorno.model.Dipendente;
import elena.primo_giorno.service.DipendenteService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private DipendenteService dipendenteService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new UnathorizedException("Unauthorized: Token missing or invalid format!");
        }

        String token = authHeader.substring(7);

        try {
            jwtTool.verifyToken(token);
            int userId = jwtTool.getIdFromToken(token);

            Optional<Dipendente> userOptional = dipendenteService.getDipendenteeById(userId);

            if (userOptional.isPresent()) {
                Dipendente user = userOptional.get();

                Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                throw new DipendenteNonTrovatoException("Dipendente not found");
            }

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            throw new UnathorizedException("Unauthorized: Token verification failed!");
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return new AntPathMatcher().match("/auth/**", request.getServletPath());
    }
}
