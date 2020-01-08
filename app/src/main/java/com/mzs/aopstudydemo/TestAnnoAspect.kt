//package com.mzs.aopstudydemo
//
//import android.util.Log
//import org.aspectj.lang.JoinPoint
//import org.aspectj.lang.ProceedingJoinPoint
//import org.aspectj.lang.annotation.*
//import java.util.*
//
///**
// * Create by ldr
// * on 2020/1/7 16:45.
// */
//@Aspect
//class TestAnnoAspect {
//
//    @Pointcut("execution(* com.mzs.aopstudydemo.MainActivity.test())")
//    public fun pointcut() {
//
//    }
//
//    @Before("pointcut()")
//    fun before(point: JoinPoint) {
//        println("@Before")
//    }
//
//    @Throws
//    @Around("pointcut()")
//    fun around(joinPoint: ProceedingJoinPoint) {
//        println("@Around")
//    }
//
//    @After("pointcut()")
//    fun after(point: JoinPoint) {
//        println("@After")
//    }
//
//    @AfterReturning("pointcut()")
//    fun afterReturning(point: JoinPoint, returnValue: Object) {
//        println("@AfterReturning")
//    }
//
//    @AfterThrowing(value = "pointcut()", throwing = "ex")
//    fun afterThrowing(ex: Throwable) {
//        println("@AfterThrowing")
//        println("ex = ${ex.message}")
//    }
//
//}
