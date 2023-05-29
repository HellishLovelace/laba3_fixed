package com.example.students;



import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudDataAccessObject {
    private File file;
    private ObjectMapper objectMapper;

    public StudDataAccessObject(String fileName) {
        file = new File(fileName);
        objectMapper = new ObjectMapper();
    }

    public List<Stud> getAllStudents() {
        List<Stud> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Stud student = objectMapper.readValue(line, Stud.class);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    public boolean addStudent(Stud student) {
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