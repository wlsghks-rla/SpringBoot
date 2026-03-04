package com.example.demo.aop;

import com.example.demo.board.web.ReplyRestController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // advice
@Component // 컨테이너에 빈 등록
public class BeforeAdvice {

    private final ReplyRestController replyRestController;

    BeforeAdvice(ReplyRestController replyRestController) {
        this.replyRestController = replyRestController;
    } 
 
   @Pointcut("execution(* com.example..*Impl.*(..))")  // 필터링
   public void  allpointcut() {} 
 
 
   @Before("allpointcut()") // 포인트 컷 하기 전에
   public void beforeLog(JoinPoint jp) { 
     String methodName = jp.getSignature().getName(); 
     System.out.println("[사전처리] beforeLog" + methodName );
     
     // 매개변수 출력
     Object[] param = jp.getArgs();
     if(param != null && param.length > 0 ) {
    	 System.out.println("매개변수: " + param[0]);
     }
   } 
}
