package shop.mtcoding.blog._core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String origin = request.getHeader("Origin");
        log.debug("Origin : " + origin);

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:5500");
//        response.setHeader("Access-Control-Expose-Headers", "Authorization"); // 응답할 때 이 헤더 응답해줄게
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Key, Content-Type, Accept, Authorization"); // 요청할 때 이 헤더 허용해줄게
        response.setHeader("Access-Control-Allow-Credentials", "true"); // 쿠키의 세션값 허용

        // Preflight 요청을 허용하고 바로 응답하는 코드
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(200);
        } else {
            chain.doFilter(req, res);
        }
    }
}