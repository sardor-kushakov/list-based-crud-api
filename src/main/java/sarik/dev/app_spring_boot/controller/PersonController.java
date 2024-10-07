package sarik.dev.app_spring_boot.controller;

import org.springframework.web.bind.annotation.*;
import sarik.dev.app_spring_boot.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class PersonController {

    // Student list:
    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Sardor", "Sardorov", new Date(), "+998976662756"),
            new Student(2, "Bobur", "Boburov", new Date(), "+998976664756"),
            new Student(3, "Bahrom", "Bahromov", new Date(), "+998978762756")));

    // CRUD

    // Create - student
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student) {
        student.setId(students.get(students.size() - 1).getId() + 1);
        students.add(student);
        return "Successfully added!";
    }

    // Read - all students
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getStudent() {
        return students;
    }

    // Read - one student
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") long id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(new Student());
    }

    // Update - one student
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        boolean updated = false;
        for (Student currentStudent : students) {
            if (currentStudent.getId() == id) {
                currentStudent.setFirstName(student.getFirstName());
                currentStudent.setLastName(student.getLastName());
                currentStudent.setBirthDate(student.getBirthDate());
                currentStudent.setPhoneNumber(student.getPhoneNumber());
                updated = true;
                break;
            }
        }
        return updated ? "Student updated" : "Student not found";
    }

    // Delete - one student
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Integer id) {
        boolean deleted = false;
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                deleted = true;
                break;
            }
        }
        return deleted ? "Student deleted" : "Student not found";
    }
}
