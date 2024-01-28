package com.example.twoDS;

import com.example.twoDS.authorDB.Author;
import com.example.twoDS.personDB.Person;
import com.example.twoDS.studentDB.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommonController {

    @Autowired
    private CommonService commonService;

    @GetMapping("/getAllAuthor")
    public List<Author> getAuthors(){
        return  commonService.getAuthors();
    }
    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody Author author){
        return  commonService.addAuthor(author);
    }

    @GetMapping("/getAllPerson")
    public List<Person> getPersons(){
        return  commonService.getPersons();
    }

    @PostMapping("/addPerson")
    public String addPerson(@RequestBody Person person){
        return  commonService.addPerson(person);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getStudent(){
        return  commonService.getStudents();
    }
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        return  commonService.addStudent(student);
    }
}