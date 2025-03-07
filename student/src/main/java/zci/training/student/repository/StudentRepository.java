package zci.training.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zci.training.student.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllBySchoolId(Integer schoolId);

}
