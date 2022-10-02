package pos.backend.controller;

import pos.backend.manager.CourseManager;
import pos.backend.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/public/course")
public class CourseController {


    @Autowired
    CourseManager courseManager;


    @GetMapping("/all")
    List<Course> getAllCourses(){
        return courseManager.getAllCourses();
    }

    @GetMapping("/match/{matchingTitle}") // use like this GET => /api/public/course/match/Artificial
    List<Course> getCoursesWithMatchingTitle(@PathVariable String matchingTitle){
        return courseManager.getCourseWithMatchingTitle(matchingTitle);
    }

    @GetMapping("/match") // use like this GET => /api/public/course/match?request=Artificial
    List<Course> getCoursesWithMatchingTitleWithQuery(@RequestParam String request){
        return courseManager.getCourseWithMatchingTitle(request);
    }

}

