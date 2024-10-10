package sarik.dev.app_spring_boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sarik.dev.app_spring_boot.model.Student;

import java.util.*;

@RestController
@RequestMapping("/students")
public class PersonController {

    // Talabalar ro'yxati:
    private final List<Student> students = new ArrayList<>(Arrays.asList(new Student(1, "Sardor", "Sardorov", new Date(), "+998976662756"), new Student(2, "Bobur", "Boburov", new Date(), "+998976664756"), new Student(3, "Bahrom", "Bahromov", new Date(), "+998978762756")));

    // CRUD operatsiyalari

    /**
     * Talabani qo'shish.
     * Ushbu metod HTTP POST so'rovi orqali talabani ob'ektini qabul qiladi va ro'yxatga qo'shadi.
     *
     * @param student Talaba ob'ekti (ismi, familiyasi, tug'ilgan sanasi, telefon raqami).
     * @return Muvaffaqiyatli qo'shilgani haqida xabar.
     */
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        student.setId(students.size() + 1);
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added!");
    }

    /**
     * Barcha talabalarni olish.
     * Ushbu metod HTTP GET so'rovi orqali barcha talabalar ro'yxatini qaytaradi.
     *
     * @return Barcha talabalar ro'yxati.
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(students);
    }

    /**
     * ID bo'yicha talabani olish.
     * Ushbu metod berilgan ID orqali talaba ob'ektini qaytaradi.
     *
     * @param id Talabaning noyob identifikatori.
     * @return Talaba ob'ekti agar topilsa, aks holda NOT FOUND statusi.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * ID bo'yicha talabani yangilash.
     * Ushbu metod berilgan ID ga mos keladigan talabani yangilaydi.
     *
     * @param id      Talabaning noyob identifikatori.
     * @param student Yangilangan talaba ob'ekti.
     * @return Yangilanganligi yoki topilmaganligi haqida xabar.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        for (Student currentStudent : students) {
            if (Objects.equals(currentStudent.getId(), id)) {
                currentStudent.setFirstName(student.getFirstName());
                currentStudent.setLastName(student.getLastName());
                currentStudent.setBirthDate(student.getBirthDate());
                currentStudent.setPhoneNumber(student.getPhoneNumber());
                return ResponseEntity.ok("Student updated successfully.");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
    }

    /**
     * ID bo'yicha talabani o'chirish.
     * Ushbu metod berilgan ID ga mos keladigan talabani ro'yatdan o'chiradi.
     *
     * @param id Talabaning noyob identifikatori.
     * @return O'chirilganligi yoki topilmaganligi haqida xabar.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        for (Student student : students) {
            if (Objects.equals(student.getId(), id)) {
                students.remove(student);
                return ResponseEntity.ok("Talaba muvaffaqiyatli o'chirildi.");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
    }
}