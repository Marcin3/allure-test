package com.szkolenie.appium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.szkolenie.appium.framework.ComplexPerson;

public class DataTest {
	
	@Test
	public void dataTest() {
		final Gson gson = new Gson();
		final Gson secondGson = new GsonBuilder().setPrettyPrinting().create();
		final Person person = gson.fromJson("{\"name\": \"Marek\"}", Person.class);
		final Person secondPerson = secondGson.fromJson("{\"name\": \"Marek\"}", Person.class);
		
		System.out.println(person.getName());
		System.out.println(gson.toJson(person));
		System.out.println(secondPerson.getName());
		System.out.println(secondGson.toJson(secondPerson));
	}
	
	@Test
	public void dataCompilePersonTest() throws FileNotFoundException {
		final Gson secondGson = new GsonBuilder().setPrettyPrinting().create();
		final BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/test/resources/data.json"));
		final ComplexPerson complexPerson = secondGson.fromJson(bufferedReader, ComplexPerson.class);
		
		System.out.println(secondGson.toJson(complexPerson));
		System.out.println(secondGson.toJson(complexPerson.getPersonal().getAge()));
		System.out.println(complexPerson.getPersonal().getAge());
	}
	
	class Person {
		private String name;
		
		String getName() {
			return this.name;
		}
	}
}
