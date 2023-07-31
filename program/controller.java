package program;

import java.util.ArrayList;
import java.util.List;

public class controller {
    private List<pets> array_pets = new ArrayList<>();

    public List<pets> get_pets(){
        return this.array_pets;
    }

    public void add_pets(pets pet){
        this.array_pets.add(pet);
    }
}
