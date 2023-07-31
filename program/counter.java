package program;

public class counter implements AutoCloseable{
    private int count;
    private boolean isopen;

    public counter(){
        this.count = 0;
        this.isopen = true;
    }

    public void add() throws Exception{
        if (this.isopen == false){
            throw new Exception("Ресурс не открыт");
        }else{
            this.count++;        
        }
    }


    public void close(){
        this.isopen = false;
    }

   
}