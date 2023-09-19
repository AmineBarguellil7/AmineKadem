package tn.esprit.aminekadem.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
@Slf4j
public class ExecutionAspect {
    @Around("execution(* tn.esprit.aminekadem.Generic.IGenericServiceImpl.update(..))")
    public Object loginMethod(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start(); //arreter execution de la fct
        //	    List<Object> obj = new ArrayList<Object>(); // si le type de retour est une liste
//		obj = (List<Object>) pjp.proceed();
        pjp.proceed();
        Object obj=(Object) pjp.proceed();
        stopWatch.stop();
        String methodName = pjp.getSignature().getName();
        log.info("The runtime of the method ( "+ methodName + " ) = " + stopWatch.getTotalTimeMillis() + " milliseconds.");
        return obj;
    }


    //@Around("execution(* tn.esprit.kaddemproject.generic.IGenericServiceImp.retrieveAll(..))")
    public List<Object> executionTime2(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        List<Object> result = new ArrayList<>();
        result=	(List<Object>) pjp.proceed();

        stopWatch.stop();

        String methodName = pjp.getSignature().getName();

        log.info("The runtime of the method ( {} ) =  {}  milliseconds.",methodName,stopWatch.getTotalTimeMillis());

        return result;
    }

}
