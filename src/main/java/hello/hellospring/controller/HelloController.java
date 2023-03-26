package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 웹어플리케이션에 '/hello'라고 들어오면 Mapping된 메소드를 호출해준다.
    // 여기서는 index.html에 hello라는 단어의 하이퍼링크를 /hello로 달아줬기때문에 hello링크를 클릭했을 때를 말한다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
        // 컨트롤러에서 리턴값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리한다.
        // resources:templates/ +{ViewName} + .html  }
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello "+name; // hello spring
    }
    // responsebody : 응답부에 hello name을 직접 넣어주겠다
    // html 태그 없이 데이터 문자 그 자체

    // json 방식
    // {'name':'spring'}
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}