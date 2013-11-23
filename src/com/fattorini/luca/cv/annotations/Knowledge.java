package com.fattorini.luca.cv.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.fattorini.luca.cv.entity.Level;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Knowledge {
	Level value();
}
