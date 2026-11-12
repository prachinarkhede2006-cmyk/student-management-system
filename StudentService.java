package com.example.studentmanagement.service;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service
public class StudentService {
 private final StudentRepository repo;
 public StudentService(StudentRepository repo){this.repo=repo;}
 public List<Student> all(){return repo.findAll();}
 public Student one(Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found"));}
 public Student create(Student s){
  if(repo.existsByEmail(s.getEmail())) throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");
  s.setId(null); return repo.save(s);
 }
 public Student update(Long id,Student s){
  Student old=one(id);
  if(!old.getEmail().equals(s.getEmail()) && repo.existsByEmail(s.getEmail()))
   throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");
  old.setName(s.getName()); old.setEmail(s.getEmail()); old.setCourse(s.getCourse()); return repo.save(old);
 }
 public void delete(Long id){repo.delete(one(id));}
}