package com.fattorini.luca.cv.entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.fattorini.luca.cv.annotations.Born;
import com.fattorini.luca.cv.annotations.Company;
import com.fattorini.luca.cv.annotations.Contact;
import com.fattorini.luca.cv.annotations.Country;
import com.fattorini.luca.cv.annotations.CurriculumVitae;
import com.fattorini.luca.cv.annotations.Description;
import com.fattorini.luca.cv.annotations.Framework;
import com.fattorini.luca.cv.annotations.Hobby;
import com.fattorini.luca.cv.annotations.Knowledge;
import com.fattorini.luca.cv.annotations.Living;
import com.fattorini.luca.cv.annotations.Name;
import com.fattorini.luca.cv.annotations.Period;
import com.fattorini.luca.cv.annotations.Phone;
import com.fattorini.luca.cv.annotations.Project;
import com.fattorini.luca.cv.annotations.Title;
import com.fattorini.luca.cv.annotations.Training;
import com.fattorini.luca.cv.exception.NoSkillException;


/**
 * 
 * @author luca-fattorini
 * 
 */
@CurriculumVitae
public class Curriculum {

	/**
	 * personal datas
	 */
	@Name(name = "Luca", surname = "Fattorini")
	@Born(at = "18/05/1987", in = "Milan")
	@Living(in = "Comazzo", cap = "26833", number = 2)
	@Phone(cel = "+39/3391031296", tel = "02/9061277")
	@Contact(mail = "fattorini.luca@gmail.com")
	@Country(nationality = "Italy")
	private PersonalData personalData;

	/**
	 * educations
	 */
	@Title("Dottore in Comunicazione Digitale")
	@Training(start = 2006, end = 2010, name = "Universita degli studi di Milano", grade = 100)
	protected Education degree;

	@Title("Perito Informatico")
	@Training(start = 2000, end = 2006, name = "Itis A.Volta", grade = 76)
	protected Education highSchool;

	/**
	 * work experiences
	 */
	@Company("Fincons S.p.a.")
	@Period(start = "01/10/2013")
	@Project({ "Prysm", "Itas" })
	public Experience researchAndDevelop;

	@Company({ "Aubay S.p.a.", "Il Sole 24 Ore" })
	@Period(start = "01/05/2013", end = "30/09/2013")
	@Project({ "Quotidiano della Casa", "Quotidiano del Diritto" })
	protected Experience consultantDeveloper;

	@Company({ "Freelance", "Moleskine", "Prezzofelice", "Neveitalia" })
	@Period(start = "01/02/2013")
	@Project({ "Tha Hand of The Architect", "The Hand of The Designer", "Prezzofelice", "Neveitalia" })
	protected Experience freelanceDeveloper;

	@Company({ "Eidon S.r.l.", "RCS Media Group" })
	@Period(start = "01/11/2011", end = "30/04/2013")
	@Project({ "CMS Sport", "iLive", "Maya - The Crossing", "Report Your Love", "iLive Premium", "inapp" })
	protected Experience eidonDeveloper;

	/**
	 * languages
	 */
	@Knowledge(Level.enough)
	protected Language english;

	@Knowledge(Level.academic)
	protected Language french;

	/**
	 * skills
	 */
	@Knowledge(Level.great)
	@Framework({ "Robo Guice", "AndroidAnnotations", "OrmLite" })
	protected Skill android;

	@Knowledge(Level.good)
	@Framework({ "Guice", "Struts", "Hibernate", "Jersey", "Jsp" })
	protected Skill java;

	@Knowledge(Level.enough)
	@Framework({ "Cake", "Twig" })
	protected Skill php;

	@Knowledge(Level.enough)
	@Framework({ "Mono", "Xamarin" })
	protected Skill cSharp;

	@Knowledge(Level.academic)
	@Framework({ "Sinatra", "Rails", "Erb" })
	protected Skill ruby;

	@Knowledge(Level.enough)
	@Framework({ "jQuery", "ajax" })
	protected Skill frontend;

	/**
	 * personal attidudes
	 */
	@Hobby({ "videogames", "logic", "technoloy", "open source", "films", "sport" })
	@Description("Dynamic, flexible, albeit methodical, patient. Interpersonal skills and creative. leadership and aptitude for problem solving. I'm a fan of RPGs, I love math, logic, and what ensues. I like to experiment and learn.")
	private PersonalAttitudes attitudes;

	/**
	 * utility for interview
	 * 
	 * @param level
	 * @return List<String>
	 * @throws NoSkillException
	 */
	public List<String> getSkillByKnoledge(Level level) throws NoSkillException {
		List<String> skills = new ArrayList<>();
		try {
			for (Field field : getClass().getDeclaredFields()) {
				if (field.isAnnotationPresent(Knowledge.class))
					if (field.getAnnotation(Knowledge.class).value().equals(level))
						if (field.getType().equals(Skill.class))
							skills.add(field.getName());
			}
			return skills;
		} catch (IllegalArgumentException e) {
			throw new NoSkillException();
		}
	}
}
