package pos.backend.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pos.backend.model.Course;
import pos.backend.repository.CourseRepository;

@Service
public class CourseManager {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public List<Course> getCourseWithMatchingTitle(String matchingTitle){
        return courseRepository.findByTitleContaining(matchingTitle);
    }
    
}

