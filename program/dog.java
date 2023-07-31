package program;

import java.util.ArrayList;

public class dog extends pets{
    
    public dog(String name, String birthday){
        this.name=name;
        this.birthday=birthday;
        this.command=new ArrayList<String>();
    }
}
