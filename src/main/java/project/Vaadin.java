package project;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.sql.SQLException;
import java.time.LocalDate;

@Route("")
public class Vaadin extends VerticalLayout{
            LocalDate tod = LocalDate.now();
            Main m2 =  new Main();
            Subject s2 = new Subject();
            JDBC j2 = new JDBC();
            double printovr = m2.dispatt();
            //String currsess = s2.sessionnumber(j2.subjects);
            double printgoing = m2.going();
            //String gosess = s2.sessionnumber(j2.subjects);
            double printleave = m2.leave();
            //String lesess = s2.sessionnumber(j2.subjects);


    public Vaadin(){
        setSizeFull();
        Div container = new Div();
        container.setWidthFull();
        container.getStyle()
                .set("display", "flex")
                .set("flex-direction", "column")
                .set("align-items", "center")
                .set("justify-content", "flex-start")
                .set("min-height", "0vh");
        Span day = new Span("IT IS " + tod.getDayOfWeek().plus(3));
            day.getStyle()
                .set("color", "white")
                .set("font-size", "36px")
                .set("font-weight", "bold")
                .set("text-align","center");


        Span curratt = new Span("CURRENT ATTENDANCE "+printovr);
            curratt.getStyle()
                    .set("color", "white")
                    .set("font-size", "30px")
                    .set("text-align","center");

        Span goatt = new Span("ATTENDANCE IF YOU GO "+printgoing);
        goatt.getStyle()
                .set("color", "white")
                .set("font-size", "30px")
                .set("text-align","center");


        Span leatt = new Span("ATTENDANCE IF YOU SKIP "+printleave);
        leatt.getStyle()
                .set("color", "white")
                .set("font-size", "30px")
                .set("text-align","center");

        Button goingbut = new Button("Going", event ->{
            j2.fetchattendance();
            s2.attendingday(j2.subjects,false);
            System.out.println(j2.subjects);
            try {
                j2.writeallattendance();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Notification.show("Changes Written to DB");
        });
            goingbut.getStyle()
                    .set("background-color", "transparent")
                    .set("color", "blue")
                    .set("position", "absolute")
                    .set("top", "410px")
                    .set("left", "1050px")
                    .set("font-size", "24px")
                    .set("padding", "15px 30px")
                    .set("border", "2px solid gray");

        Button lebutt = new Button("Skipping", event ->{
            j2.fetchattendance();
            s2.leaveday(j2.subjects);
            try{
                j2.writeallattendance();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Notification.show("Changes Written to DB");
        });
        lebutt.getStyle()
                .set("background-color", "transparent")
                .set("color", "red")
                .set("position", "absolute")
                .set("top", "366px")
                .set("left", "420px")
                .set("font-size", "24px")
                .set("padding", "15px 30px")
                .set("border", "2px solid gray");
        UI.getCurrent().getPage().executeJs(
                "document.body.style.backgroundImage = \"url('/images/attendancepill.jpg')\";" +
                        "document.body.style.backgroundSize = 'cover';" +
                        "document.body.style.backgroundRepeat = 'no-repeat';" +
                        "document.body.style.backgroundPosition = 'center';"
        );
        container.add(day);
        container.add(curratt);
        container.add(goatt);
        container.add(leatt);
        container.add(goingbut);
        container.add(lebutt);
        add(container);
    }
}
