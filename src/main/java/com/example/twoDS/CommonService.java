package com.example.twoDS;

import com.example.twoDS.authorDB.Author;
import com.example.twoDS.authorDB.AuthorRepository;
import com.example.twoDS.personDB.Person;
import com.example.twoDS.personDB.PersonRepository;
import com.example.twoDS.studentDB.Student;
import com.example.twoDS.studentDB.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Author> getAuthors(){
        return  authorRepository.findAll();
    }

    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "True";
    }


    public String addPerson(Person person) {
        personRepository.save(person);
        return "True";
    }

    public List<Person> getPersons() {
        return  personRepository.findAll();
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public String addStudent(Student student) {
        studentRepository.save(student);
        return "true";
    }
}
