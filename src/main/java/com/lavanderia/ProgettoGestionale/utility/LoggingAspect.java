package com.lavanderia.ProgettoGestionale.utility;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.lavanderia.ProgettoGestionale..*(..))") // Sostituisci con il tuo package
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        Object[] methodArgs = joinPoint.getArgs();

        logger.info("Chiamato metodo: {} con parametri: {}", methodName, Arrays.toString(methodArgs));

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // Esegue il metodo originale
        long elapsedTime = System.currentTimeMillis() - startTime;

        logger.info("Metodo {} terminato in {} ms con risultato: {}", methodName, elapsedTime, result);
        return result;
    }
}
