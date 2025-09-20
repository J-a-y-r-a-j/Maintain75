package project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.time.LocalDate;

@Controller
public class Thyme {

    JDBC j2 = new JDBC();
    Subject s2 = new Subject();
    Main m2 = new Main();

    @GetMapping("/")
    public String home(Model model) {
        LocalDate tod = LocalDate.now();

        double printovr = m2.dispatt();
        double printgoing = m2.going();
        double printleave = m2.leave();

        model.addAttribute("day", tod.getDayOfWeek());
        model.addAttribute("printovr", printovr);
        model.addAttribute("printgoing", printgoing);
        model.addAttribute("printleave", printleave);

        return "index";
    }

    @PostMapping("/going")
    public String going(Model model) throws SQLException {
        j2.fetchattendance();
        s2.attendingday(j2.subjects,false);
        j2.writeallattendance();

        model.addAttribute("message", "Changes Written to DB");
        return "redirect:/";
    }

    @PostMapping("/skipping")
    public String skipping(Model model) throws SQLException {
        j2.fetchattendance();
        s2.leaveday(j2.subjects);
        j2.writeallattendance();

        model.addAttribute("message", "Changes Written to DB");
        return "redirect:/";
    }
}
