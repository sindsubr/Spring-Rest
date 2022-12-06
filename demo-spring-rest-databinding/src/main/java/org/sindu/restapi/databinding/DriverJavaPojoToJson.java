package org.sindu.restapi.databinding;

import java.io.File;
import java.io.IOException;

import org.sindu.restapi.databinding.entity.Student;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DriverJavaPojoToJson {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		Student student = new Student(1, "Sai Adhvik", "sabi", true);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(new File("data/output.json"), student);
	}

}
