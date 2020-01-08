package com.mzs.aopstudydemo;

import android.graphics.Point;
import android.os.SystemClock;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/**
 * Create by ldr
 * on 2020/1/8 9:26.
 */
@Aspect
public class TestAnnoAspectJava {

//    @Pointcut("execution(* com.mzs.aopstudydemo.MainJavaActivity.test())")
//    public void pointcut() {
//    }
//    @Pointcut("execution(* com.mzs.aopstudydemo.MainJavaActivity.threadTest())")
//    public void pointcut1(){
//    }
//    @Pointcut("execution(* com.mzs.aopstudydemo.MainJavaActivity.onCreate(..))")
//    public void pointcut2(){
//    }

    @Pointcut("execution(* com.mzs.aopstudydemo.MainJavaActivity.stepOn*(..))")
    public void pointcutOn(){
    }

    @After("pointcutOn()")
    public void beforeSystem(JoinPoint point){
        System.out.println("point.getKind()"+point.getKind());
        System.out.println("point.getSignature()"+ point.getSignature());
        System.out.println("point.getSourceLocation()"+ point.getSourceLocation());
        System.out.println("point.getStaticPart()"+ point.getStaticPart());
        System.out.println("point.getTarget()"+ point.getTarget());
        System.out.println("point.getThis()"+ point.getThis().getClass().getSimpleName());
        System.out.println("point.toShortString()"+ point.toShortString());
        System.out.println("point.toLongString()"+ point.toLongString());
        System.out.println("point.toString()"+ point.toString());
        Object[] o = point.getArgs();
        if (o !=null){
            if (o.length != 0){
                System.out.println("point.getArgs()"+ o.length);
            }
        }else{
            System.out.println("point.getArgs()"+ point.getArgs());
        }
    }
//
//    @Around("pointcut2()")
//    public void around2(ProceedingJoinPoint joinPoint) throws Throwable{
//        System.out.println("onCreate ------------------@Around");
//        long beginTime = System.currentTimeMillis();
//        joinPoint.proceed();
//        long endTime = System.currentTimeMillis();
//        System.out.println("onCreate ------------------运行时间:"+(endTime-beginTime));
//    }
//
//    @Around("pointcut1()")
//    public void around1(ProceedingJoinPoint joinPoint) throws Throwable{
//        System.out.println("pointcut1 ------------------@Around");
//        long beginTime = System.currentTimeMillis();
//        joinPoint.proceed();
//        long endTime = System.currentTimeMillis();
//        System.out.println("pointcut1 ------------------运行时间:"+(endTime-beginTime));
//    }
//
//
//    @Before("pointcut()")
//    public void before(JoinPoint point) {
//        System.out.println("@Before");
//    }
//
//    @Around("pointcut()")
//    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("@Around");
//        joinPoint.proceed();
//    }
//
//    @After("pointcut()")
//    public void after(JoinPoint point) {
//        System.out.println("@After");
//    }
//
//    @AfterReturning("pointcut()")
//    public void afterReturning(JoinPoint point, Object returnValue) {
//        System.out.println("@AfterReturning");
//    }
//
//    @AfterThrowing(value = "pointcut()", throwing = "ex")
//    public void afterThrowing(Throwable ex) {
//        System.out.println("@afterThrowing");
//        System.out.println("ex = " + ex.getMessage());
//    }


}
