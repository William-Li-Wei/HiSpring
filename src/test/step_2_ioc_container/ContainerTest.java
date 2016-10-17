package step_2_ioc_container;

import junit.framework.TestCase;
import main.step_1_helloworld.HelloWorld;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Spring 容器
 *
 * 前面提到容器是 Spring 的核心。它根据 xml 创建对象，把它们关联起来，配置它们，并管理它们的整个生命周期。
 * Spring 提供两种容器：
 *      BeanFactory 和 ApplicationContext
 *      1. BeanFactory 是最简单的容器，它为 DI提供最基本的支持。
 *      2. ApplicationContext 包含 BeanFactory 的所有功能，是一种更高级的容器。通常情况下更建议使用 ApplicationContext.
 *      ps. 在一些对速度快和数据量大方面有需求的轻量级应用，可以选用 BeanFactory.
 * Created by William on 9/27/2016.
 */
public class ContainerTest extends TestCase {
    String beanName = "helloWorld";     // 配置文件中的 helloworld bean
    String msg = "Hello World!";        // 配置文件中 helloworld 的 message 属性

    /**
     * XmlBeanFactory 容器
     */
    @Test
    public void testBeanFactory() {
        XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("Beans.xml"));
        HelloWorld obj = (HelloWorld) factory.getBean(beanName);
        assertEquals(msg, obj.getMessage());
    }

    /**
     * ClassPathXmlApplicationContext 容器
     * 默认在 src 目录下寻找配置文件， 如 new ClassPathXmlApplicationContext("Beans.xml");
     * 此处使用 ./main/step_2_ioc_container/Beans.xml 处的配置文件
     */
    @Test
    public void testClassPathXmlApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("./main/step_2_ioc_container/Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean(beanName);
        assertEquals(msg, obj.getMessage());
    }

    /**
     * FileSystemXmlApplicationContext 容器
     * 在指定的文件系统路径下寻找配置文件
     */
    @Test
    public void testFileSystemXmlApplicationContext() {

        ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\Wei\\Documents\\Rhino\\Projects\\HiSpring\\src\\Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean(beanName);
        assertEquals(msg, obj.getMessage());
    }

    /**
     * TODO： 还有一些其他容器
     */
}