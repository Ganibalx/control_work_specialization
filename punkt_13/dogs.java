package punkt_13;

import java.util.List;

public class dogs extends pets{
    private List<String> commands;

    public dogs(String name, String birthday, List<String> commands){
        this.name=name;
        this.birthday=birthday;
        this.commands=commands;
    }

    public List<String> get_commands(){
        return this.commands;
    }
}
