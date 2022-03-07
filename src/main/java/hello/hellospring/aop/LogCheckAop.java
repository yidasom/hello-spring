package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogCheckAop {

//    @Pointcut("execution(* hello.hellospring..*(..)) || execution(* hello.hellospring..*(..))")
//    private void pointCut() {
//    }

//  @Around("pointCut()")
//    @Around("execution(* hello.hellospring..*(..))")
//    public Object execute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        try {
//            Object result = proceedingJoinPoint.proceed();
//            System.out.println(result);
//            return result;
//        } finally {
//            System.out.println("success ?!!!");
//        }
//
//    }
}
