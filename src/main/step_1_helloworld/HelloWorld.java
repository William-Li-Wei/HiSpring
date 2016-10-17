package main.step_1_helloworld;

/**
 * Created by William on 10/17/2016.
 */
public class HelloWorld {
    private String message;

    public void setMessage(String message){
        System.out.println(" ... setting message: " + message);
        this.message  = message;
    }
    public String getMessage(){
        System.out.println(" ... getting message: " + this.message);
        return this.message;
    }
}
