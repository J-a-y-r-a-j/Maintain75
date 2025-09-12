package project;


import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(" ")
public class Vaadin extends VerticalLayout {
    public Vaadin(){
        add(new Text("Test"));
    }
}
