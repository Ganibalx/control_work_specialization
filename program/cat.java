package program;

import java.util.ArrayList;

public class cat extends pets{
    
    public cat(String name, String birthday){
        this.name=name;
        this.birthday=birthday;
        this.command=new ArrayList<>();
    }
}
