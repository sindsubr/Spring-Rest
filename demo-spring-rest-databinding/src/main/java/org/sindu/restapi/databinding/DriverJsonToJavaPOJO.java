package org.sindu.restapi.databinding;

import java.io.File;
import java.io.IOException;

import org.sindu.restapi.databinding.entity.Student;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DriverJsonToJavaPOJO {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		Student student = mapper.readValue(new File("data/sample.json"), Student.class);
		System.out.println(student.getLastName());
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(new File("data/output.json"), student);
	}

}
