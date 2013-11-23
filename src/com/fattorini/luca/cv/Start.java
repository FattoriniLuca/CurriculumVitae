package com.fattorini.luca.cv;
import java.lang.reflect.InvocationTargetException;

import com.fattorini.luca.cv.entity.Curriculum;
import com.fattorini.luca.cv.entity.Level;
import com.fattorini.luca.cv.exception.NoSkillException;


public class Start {
	public static void main(String... args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException,  NoSkillException {
		
		Curriculum cv = new Curriculum();
		System.out.println(cv.getSkillByKnoledge(Level.enough));
	}
}
