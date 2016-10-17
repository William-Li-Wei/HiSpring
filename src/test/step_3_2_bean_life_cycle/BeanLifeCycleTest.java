package step_3_2_bean_life_cycle;

import junit.framework.TestCase;
import main.step_3_2_bean_life_cycle.ITWorld;
import main.step_3_2_bean_life_cycle.NormalWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
 * Created by William on 9/27/2016.
 */
public class BeanLifeCycleTest extends TestCase {
    AbstractApplicationContext context = new ClassPathXmlApplicationContext("./main/step_3_2_bean_life_cycle/Beans.xml");

    /**
     * Life Cycle - bean 的生命周期
     * 在一个 bean 的周期中，当它被初始化或销毁时，可能需要进行一些特殊的处理，比如分别调用 init 函数和 destroy 函数.
     * 周期中还有很多其他地方可以使用各种毁掉方法，但这里只针对 init 和 destroy 阶段，各演示两种相应回到函数的方法。
     *
     * 对于 init 和 destroy， 都有两种不同的方法去实现
     *      1. 在配置文件中使用 “init-method” 和 "destroy-method" 进行配置。 如下面 world
     *      2. 在 Java 类中实现 InitializingBean 和 DisposableBean 借口， 如下面 world2， 对应 Java 类 Helloworld2
     *
     * 如果很多 bean 都统一用各自的init方法来进行初始化，对每一个bin都要声明 init-method=“init”， 有点麻烦，
     * 于是也可以 <beans default-init-method="init" ></beans> 级别的标签中使用 default-init-method 和 default-destroy-method 进行声明，
     * 各个类再去实现自己的 init 和 destroy 方法即可， 但方法名应该和上述 default-init 中的方法名一致
     */


    @Test
    public void testBeanLifeCycle() {
        NormalWorld world = (NormalWorld) context.getBean("normalWorld");
        assertEquals("I'm AWAKE!!!", world.getMessage());


        ITWorld world2 = (ITWorld) context.getBean("itWorld");
        assertEquals("I'm AWAKE!!!", world2.getMessage());

        // 这里关闭容器进程和资源，触发 bean 的 destroy 方法
        context.registerShutdownHook();
    }
}
