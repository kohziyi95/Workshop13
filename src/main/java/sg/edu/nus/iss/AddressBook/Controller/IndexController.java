package sg.edu.nus.iss.AddressBook.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.AddressBook.Model.Person;

@Controller
@RequestMapping(path="/demo", produces=MediaType.TEXT_HTML_VALUE)
public class IndexController {
    
    @GetMapping("/getAllPerson")
    public String getAllPerson(Model model){
        List<Person> allPerson = new ArrayList<Person>();
        
        Person p = new Person();
        p.setId(1);
        p.setFirstName("Zi Yi");
        p.setLastName("Koh");
        p.setGender('M');
        allPerson.add(p);

        Person p2 = new Person();
        p2.setId(2);
        p2.setFirstName("Jane");
        p2.setLastName("Tan");
        p2.setGender('F');
        allPerson.add(p2);

        model.addAttribute("person", p);
        model.addAttribute("allPerson", allPerson);


        return "getallperson";
    }

    @GetMapping("/searchPerson")
    public String searchPerson(@RequestParam(required=true) String firstName, Model model){
        List<Person> allPerson = new ArrayList<Person>();
        Person pResult = null;
        
        Person p = new Person();
        p.setId(1);
        p.setFirstName("Zi Yi");
        p.setLastName("Koh");
        p.setGender('M');
        allPerson.add(p);

        Person p2 = new Person();
        p2.setId(2);
        p2.setFirstName("Jane");
        p2.setLastName("Tan");
        p2.setGender('F');
        allPerson.add(p2);

        if (firstName.equals("Zi Yi")){
            pResult = p;
        }

        if (firstName.equals("Jane")){
            pResult = p2;
        }
        

        model.addAttribute("person", p);
        model.addAttribute("allPerson", allPerson);
        model.addAttribute("result", pResult);
        return "searchperson";
    }

    @GetMapping("/getSomeone/{firstName}")
    public String getSomeone(@PathVariable(name="firstName") String firstName, Model model){

        
        Person p = new Person();
        if (firstName.equals("Zi Yi")){
            p.setId(1);
            p.setFirstName("Zi Yi");
            p.setLastName("Koh");
            p.setGender('M');
        }
        
        if (firstName.equals("Jane")){
            p.setId(2);
            p.setFirstName("Jane");
            p.setLastName("Tan");
            p.setGender('F');
        }

        model.addAttribute("person", p);

        return "pathvar";
    }
    

}
