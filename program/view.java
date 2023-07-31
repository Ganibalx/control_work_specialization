package program;
import java.util.Scanner;

public class view {
    private Scanner s = new Scanner(System.in);
    private controller c = new controller();

    public void start(){
        boolean flag = true;
        System.out.println("Добро пожаловать в реестр домашних животных!");  
        while(flag){
            System.out.println("Вы находитесь в главном меню, для управления используйте цифры с клавиатуры.\nДоступные команды:\n1-показать всех животных.\n2-добавить питомца.\n0-выход" );
            try {
                switch (this.s.nextLine()){
                case "1": 
                all_pets(); 
                break;
                case "2":
                add_pet();    
                break;
                case "0":
                flag = false;
            }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        s.close();
    }

    private void all_pets() throws Exception{
        if(this.c.get_pets() == null){
            System.out.println("В реестре еще нет животных!");
        }else{
            int j=1;
            for(pets i:this.c.get_pets()){
                System.out.println(j+" "+i.get_name()+" "+i.get_birthday());
                j++;
            }            
                System.out.println("\nДоступные команды:\n0-Вернуться в предыдущее меню.\nномер животного - посмотреть каким командам обучен.");
                    try {
                        int znach = this.s.nextInt();
                        if(znach==0){
                            
                        }else{
                            pets_command(znach);
                        }                                       
                    } catch (Exception e) {
                        throw new Exception("Введена не корректная команда в меню просмотра животных!");
                    }
            
        } 
    }

    private void pets_command(int znach) throws Exception{
        System.out.println(this.c.get_pets().get(znach-1).get_command()+this.s.nextLine());
    
        
            System.out.println("\nДоступные команды:\n0-Вернуться в предыдущее меню.\n1-добавить команду.");
            try {                  
                String vibor = this.s.nextLine();
                switch(vibor){
                    case "0":                    
                    break;
                    case "1":
                    System.out.println("Введите новую команду:");
                    this.c.get_pets().get(znach-1).add_comand(this.s.nextLine());
                }
            } catch (Exception e) {
                throw new Exception("Введена не корректная команда при выборе животного");
            }
    }

    private void add_pet() throws Exception{
        System.out.println("Какой вид животного хотите добавить?\n1-Собака.\n2-Кошка.\n3-Хомяк.\n0-Вернуться в предыдущее меню.");                
                switch(this.s.nextLine()){
                    case "0":                    
                    break;
                    case "1":
                    try (counter count = new counter()) {
                        System.out.println("Введите имя:");
                        String nd = s.nextLine();
                        System.out.println("Введите дату рождения:");
                        String bd = s.nextLine();
                        this.c.add_pets(new dog(nd, bd));
                        count.add();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }                    
                    break;
                    case "2":
                    try (counter count = new counter()) {
                        System.out.println("Введите имя:");
                        String nc = s.nextLine();
                        System.out.println("Введите дату рождения:");
                        String bc = s.nextLine();
                        this.c.add_pets(new cat(nc, bc));
                        count.add();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }                    
                    break;
                    case "3":
                    try (counter count = new counter()) {
                        System.out.println("Введите имя:");
                        String nh = s.nextLine();
                        System.out.println("Введите дату рождения:");
                        String bh = s.nextLine();
                        this.c.add_pets(new hamster(nh, bh));
                        count.add();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }                    
                    break;
                    default:
                    throw new Exception("Таких животных не учитываем");
                }
        
            
    }
}
