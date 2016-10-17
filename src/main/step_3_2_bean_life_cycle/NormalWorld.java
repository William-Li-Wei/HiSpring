package main.step_3_2_bean_life_cycle;

/**
 * Created by William on 10/17/2016.
 */
public class NormalWorld {
    private String message;


    public void init() {
        System.out.println(" ... initializing the normal world");
    }

    public void destroy() {
        System.out.println(" ... destroying the normal world");
    }


    public void setMessage(String message){
        System.out.println(" ... setting message: " + message);
        this.message  = message;
    }
    public String getMessage(){
        System.out.println(" ... getting message: " + this.message);
        return this.message;
    }
}
