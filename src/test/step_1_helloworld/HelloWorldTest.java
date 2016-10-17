package step_1_helloworld;

import junit.framework.TestCase;
import main.step_1_helloworld.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 一个都从 HelloWorld 开始
 * Created by William on 9/27/2016.
 */
public class HelloWorldTest extends TestCase {
    /**
     * Spring 的核心——容器
     * 这个Helloworld是这样工作的：
     * 1. 得到一个容器
     * 2. 由容器读取 xml 配置文件，
     * 3. 并根据配置文件中关于 Bean 的设置来实例化对象
     */
    @Test
    public void testHelloWorld() {
        // 得到容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        // 通过容器得到实例化的 bean
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

        // 在配置文件中设置了 message property
        assertEquals(obj.getMessage(), "Hello World!");

        // 用 set 方法改变 message
        obj.setMessage("A wonderful World!");
        assertEquals(obj.getMessage(), "A wonderful World!");
    }
}
