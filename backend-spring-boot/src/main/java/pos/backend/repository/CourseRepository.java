package pos.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pos.backend.model.Course;



public interface CourseRepository extends JpaRepository<Course, Integer> {
  
  @Query(
    value = "SELECT * FROM courses c WHERE c.title LIKE '%' || :matchingString || '%'", 
    nativeQuery = true)
  List<Course> findByTitleContaining(String matchingString);

}