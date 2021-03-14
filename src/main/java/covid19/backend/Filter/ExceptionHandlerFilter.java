package covid19.backend.Filter;

import covid19.backend.Models.CustomErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException eje) {
            setErrorResponse(HttpStatus.UNAUTHORIZED,"Error: Token expired please log back in", response, eje);
        }catch (SignatureException se) {
            setErrorResponse(HttpStatus.UNAUTHORIZED,"Mismatch: Token does not match locally computed signature", response, se);
        }catch (MalformedJwtException me) {
            setErrorResponse(HttpStatus.UNAUTHORIZED,"Error: Malformed auth header provided ", response, me);
        }  catch (RuntimeException e) {
            System.out.println(e);
            setErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Some other error occurred please check logs", response, e);
        }
    }

    public void setErrorResponse(HttpStatus status, String errorMsg, HttpServletResponse response, Throwable ex) {
        response.setStatus(status.value());
        response.setContentType("application/json");
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(status,errorMsg, ex);
        try {
            String json = customErrorResponse.convertToJson();
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
