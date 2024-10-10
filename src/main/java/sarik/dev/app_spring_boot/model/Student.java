package sarik.dev.app_spring_boot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Talaba ob'ekti.
 * Ushbu klass talabalar haqida ma'lumotlarni saqlaydi.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id; // Talabaning noyob identifikatori
    private String firstName; // Talabaning ismi
    private String lastName; // Talabaning familiyasi
    private Date birthDate; // Talabaning tug'ilgan sanasi
    private String phoneNumber; // Talabaning telefon raqami
}
