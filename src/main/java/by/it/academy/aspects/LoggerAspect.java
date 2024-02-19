package by.it.academy.aspects;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    private static final String LOG_REQUEST_PATTERN = "{} -> {}:{}-{}";
    private static final String LOG_RESPONSE_PATTERN = "{} -> {}:{}:{}";

    @Pointcut("execution(* by.it.academy.controllers..*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void logRequest(JoinPoint joinPoint){
        HttpServletRequest request = getHttpServletRequest();
        log.info(LOG_REQUEST_PATTERN,
                request.getMethod(),
                joinPoint.getArgs(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI());
    }

    @AfterReturning(value = "pointCut()", returning = "response")
    public void logResponse(JoinPoint joinPoint, Object response){
        HttpServletRequest request = getHttpServletRequest();
        log.info(LOG_RESPONSE_PATTERN,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI(),
                response);
    }

    private static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}
