package com.example.students;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudController extends HttpServlet {
    private StudDataAccessObject studentDAO;
    private ObjectMapper objectMapper;

    public StudController() {
        studentDAO = new StudDataAccessObject("students.json");
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Stud> students = studentDAO.getAllStudents();
        String json = objectMapper.writeValueAsString(students);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String group = req.getParameter("group");
        int age = Integer.parseInt(req.getParameter("age"));
        String subject = req.getParameter("subject");

        Stud student = new Stud(firstName, lastName, group, age, subject);
        boolean success = studentDAO.addStudent(student);

        String json = objectMapper.writeValueAsString(success);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}

