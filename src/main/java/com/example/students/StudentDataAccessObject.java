package com.example.students;



import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataAccessObject {
    private File file;
    private ObjectMapper objectMapper;

    public StudentDataAccessObject(String fileName) {
        file = new File(fileName);
        objectMapper = new ObjectMapper();
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = objectMapper.readValue(line, Student.class);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    public boolean addStudent(Student student) {
        try (FileWriter writer = new FileWriter(file, true)) {
            String json = objectMapper.writeValueAsString(student);
            writer.write(json + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}