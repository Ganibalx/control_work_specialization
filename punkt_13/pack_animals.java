package punkt_13;

import java.util.List;

abstract class pack_animals extends animals{
    protected List<String> commands;

    protected List<String> get_commands(){
        return this.commands;
    }
}
