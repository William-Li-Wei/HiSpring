package step_3_1_bean_scope;

import junit.framework.TestCase;
import main.step_1_helloworld.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Bean （豆子 o(^▽^)o）
 *
 * Spring 的骨架就是 bean。 它是由 IOC 容器创造，组装和管理的对象。
 * IOC 容器读取配置文件，并根据配置文件中定义的内容和规则来创造和管理 bean。
 * 在配置文件中，bean 是通过标签 <bean></bean> 定义的
 * 这一节将通过以下几个方面去了解关于 bean 的更多内容：
 *      1. Scope - 作用域
 *      2. Life Cycle - 生命周期
 *      3. Post Processors - 后置处理器
 *      4. Definition Inheritance - 定义继承
 *      5. Dependency Injection - 依赖注入
 *      6. Auto-Wiring - 自动装配
 *
 * Created by William on 9/27/2016.
 */
public class BeanScopeTest extends TestCase {
    ApplicationContext context = new ClassPathXmlApplicationContext("./main/step_3_1_bean_scope/Beans.xml");

    /**
     * Scope - bean 的作用域
     * Spring 支持一下5中作用域，其中后三种只在 web 应用中使用
     *      1.1 singleton       每个IOC容器只会实例化一个bean
     *      1.2 prototype       每次 getBean（） 的时候都会实例化一个新的bean
     *      1.3 request         对每个 Http Request 实例化一个
     *      1.4 session         对每个 Http Session 实例化一个
     *      1.5 global-session  对每个 global Http Session 实例化一个
     */


    @Test
    public void testSingleton() {
        // singleton
        HelloWorld worldA = (HelloWorld) context.getBean("theWorld");
        worldA.setMessage("I am the world!");
        HelloWorld worldB = (HelloWorld) context.getBean("theWorld");
        worldA.setMessage("I am another world!");

        // 可以看到先后两个 bean worldA 和 worldB 其实是同一个对象
        assertEquals(worldA, worldB);
        assertEquals(worldA.getMessage(), worldB.getMessage());
    }


    @Test
    public void testPrototype() {
        // prototype
        HelloWorld worldC = (HelloWorld) context.getBean("aWorld");
        worldC.setMessage("I am a world!");
        HelloWorld worldD = (HelloWorld) context.getBean("aWorld");
        worldD.setMessage("I am another world!");

        // 可以看出两个 bean worldC 和 worldD 是两个不同的对象
        assertThat(worldC, not(equals(worldD)));
        assertThat(worldC.getMessage(), not(equals(worldD.getMessage())));
    }
}
