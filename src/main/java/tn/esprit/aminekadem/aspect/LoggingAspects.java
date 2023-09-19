package tn.esprit.aminekadem.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component //pour creer une instance
@Slf4j
public class LoggingAspects {
    @Before("execution(* tn.esprit.aminekadem.service.ContratService.*(..))") //first *:type de retour
    public void loginmethod(JoinPoint joinPoint) {
        log.info("in method: "+joinPoint.getSignature().getName());
    }
    @Before("execution(* tn.esprit.aminekadem.Generic.*.*(..))") //first *:type de retour
    public void loginmethodGeneric(JoinPoint joinPoint) {
        log.info("in method: "+joinPoint.getSignature().getName());
    }
}
