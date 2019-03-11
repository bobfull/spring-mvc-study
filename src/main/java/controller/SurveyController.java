package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import survey.AnsweredData;
import survey.Question;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/survey")
public class SurveyController {

    @GetMapping
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        List<Question> questions = createQuestions();

        mav.addObject("questions", questions);
        mav.setViewName("survey/surveyForm");
        return mav;
    }

    private List<Question> createQuestions() {
        Question q1 = new Question("역할", Arrays.asList("서버", "프론트", "풀스택"));
        Question q2 = new Question("도구", Arrays.asList("이클립스", "인텔리제이", "서브라임"));
        Question q3 = new Question("하고 싶은 말");

        return Arrays.asList(q1, q2, q3);
    }


    @PostMapping
    public String submit(@ModelAttribute("ansData") AnsweredData data){
        return "survey/submitted";
    }

}
