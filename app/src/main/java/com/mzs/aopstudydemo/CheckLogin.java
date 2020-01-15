package com.mzs.aopstudydemo;

import androidx.annotation.Nullable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Create by ldr
 * on 2020/1/10 9:39.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckLogin {
    boolean isSkip() default false;//增加额外的信息，决定要不要跳过检查
}
