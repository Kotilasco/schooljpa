package com.erd.schooljpa;

import com.erd.schooljpa.entity.*;
import com.erd.schooljpa.entity.Class;
import com.erd.schooljpa.repository.GuardianRepository;
import com.erd.schooljpa.repository.GuardianTypeRepository;
import com.erd.schooljpa.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class SchooljpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchooljpaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
    StudentRepository studentRepository,
    GuardianRepository guardianRepository,
    GuardianTypeRepository guardianTypeRepository
    ){
        return args -> {

            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();

            Student student = new Student(
                    firstName,
                    faker.name().nameWithMiddle(),
                    lastName,
                    LocalDate.now(),
                    "Male",
                    LocalDate.now().minusWeeks(2)
            );
            Faker faker1 = new Faker();
            String givenName = faker1.name().firstName();
            String surname = faker1.name().lastName();
            String email = String.format("%s.%s@kuly.com", surname, givenName);
            Guardian guardian = new Guardian(
                    givenName,
                    surname,
                    email,
                    faker1.phoneNumber().toString()
            );

            Faker faker2 = new Faker();
            GuardianType guardianType = new GuardianType(
                    faker2.name().fullName()
            );

            student.addStudentGuardian(
                   new StudentGuardian(
                           new StudentGuardianId(
                                   1L,
                                   1L,
                                   1L
                           ),
                           student,
                           guardianType,
                           guardian
                   )
            );
            Class aclass = new Class(
                    "Software"
            );

            Class wclass = new Class(
                    "Eng"
            );

            student.addStudentClass(
                    new StudentClass(
                            new StudentClassId(
                                    1L,
                                    1L
                            ),
                            student,
                            aclass
                    )
            );
            student.addStudentClass(
                    new StudentClass(
                            new StudentClassId(
                                    1L,
                                    2L
                            ),
                            student,
                            wclass
                    )
            );

            studentRepository.save(student);


            guardianRepository.findById(1L).ifPresentOrElse(
                    s ->{
                        System.out.println(s.getEmail());
                        System.out.println(s.getClass());
                    },
                    (() -> System.out.println("not present"))

            );
        };
    }

}
