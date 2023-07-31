package program;

import java.util.List;

public class pets{
    protected String name;
    protected String birthday;
    protected List<String> command;

    protected String get_name(){
        return this.name;
    }

    protected String get_birthday(){
        return this.birthday;
    }

    protected String get_command(){
        return this.command.toString();
    }

    protected void add_comand(String command){
        this.command.add(command);
    }
}
