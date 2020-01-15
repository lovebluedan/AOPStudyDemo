package com.mzs.aopstudydemo;

import android.graphics.Point;
import android.nfc.Tag;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.function.LongToDoubleFunction;

import kotlin.jvm.Throws;

/**
 * Create by ldr
 * on 2020/1/8 9:26.
 */
@Aspect
public class TestAnnoAspectJava {
    private static final String TAG = "TestAnnoAspectJava";

    @Pointcut("execution(* com.mzs.aopstudydemo.MainJavaActivity.test())")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint point) {
        System.out.println("@Before");
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around");
        joinPoint.proceed();
    }

    @After("pointcut()")
    public void after(JoinPoint point) {
        System.out.println("@After");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint point, Object returnValue) {
        System.out.println("@AfterReturning");
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("@afterThrowing");
        System.out.println("ex = " + ex.getMessage());
    }


    //--------------------------------------------------------------------------------------------------


    @Pointcut("execution(* com.mzs.aopstudydemo.MainJavaActivity.threadTest())")
    public void pointcutThreadTest() {
    }

    @Around("pointcutThreadTest()")
    public void calculateFunctionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("pointcut1 ------------------@Around");
        long beginTime = System.currentTimeMillis();
        joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("pointcut1 ------------------运行时间:" + (endTime - beginTime));
    }

    //--------------------------------------------------------------------------------------------------

    @Pointcut("execution(* com.mzs.aopstudydemo.MainJavaActivity.stepOn*(..))")
    public void pointcutOn() {
    }

    @After("pointcutOn()")
    public void beforeSystem(JoinPoint point) {
        System.out.println("point.getKind()" + point.getKind());
        System.out.println("point.getSignature()" + point.getSignature());
        System.out.println("point.getSourceLocation()" + point.getSourceLocation());
        System.out.println("point.getStaticPart()" + point.getStaticPart());
        System.out.println("point.getTarget()" + point.getTarget());
        System.out.println("point.getThis()" + point.getThis());
        System.out.println("point.toShortString()" + point.toShortString());
        System.out.println("point.toLongString()" + point.toLongString());
        System.out.println("point.toString()" + point.toString());
        Object[] o = point.getArgs();
        if (o != null) {
            if (o.length != 0) {
                System.out.println("point.getArgs()" + o.length);
            }
        } else {
            System.out.println("point.getArgs()" + point.getArgs());
        }
    }

    //--------------------------------------------------------------------------------------------------

    public static Boolean isLoagin = false;


    @Pointcut("execution(@com.mzs.aopstudydemo.CheckLogin * *(..))")
    public void checkLogin() {
    }

    @Around("checkLogin()")
    public void checkLoginPoint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //1. 获取函数的签名信息，获取方法信息
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        //2. 检查是否存在我们定义的CheckLogin注解
        CheckLogin annotation = method.getAnnotation(CheckLogin.class);
        boolean isSkip = annotation.isSkip();//判断是要跳过检查
        if (annotation != null) {
            if (isSkip) {
                Log.i(TAG, "isSkip=true 这里不需要检查登录状态~~~~~~");
                proceedingJoinPoint.proceed();
            } else {
                if (isLoagin) {
                    Log.i(TAG, "您已经登录过了~~~~");
                    proceedingJoinPoint.proceed();
                } else {
                    Log.i(TAG, "请先登录~~~~~");
                }
            }
        }
    }
}
