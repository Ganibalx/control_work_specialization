package program;

import java.util.ArrayList;

public class hamster extends pets{
    
    public hamster(String name, String birthday){
        this.name=name;
        this.birthday=birthday;
        this.command=new ArrayList<>();
    }
}
