package zci.training.school.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zci.training.school.dto.FullSchoolResponse;
import zci.training.school.entity.School;
import zci.training.school.openfeign.StudentClient;
import zci.training.school.repository.SchoolRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;

    public void saveSchool(School school) {
        repository.save(school);
    }

    public List<School> findAllSchools() {
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId).orElse(School.builder().name("NOT_FOUND").email("NOT_FOUND").build());
        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder().name(school.getName()).email(school.getEmail()).students(students).build();
    }
}
