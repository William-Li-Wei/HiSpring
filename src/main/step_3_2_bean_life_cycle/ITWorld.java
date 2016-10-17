package main.step_3_2_bean_life_cycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by William on 10/17/2016.
 */
public class ITWorld implements InitializingBean, DisposableBean {
    private String message;


    @Override
    public void destroy() throws Exception {
        System.out.println("没电了，电脑又都归于混沌...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("起初，工程师创造个人电脑...");
        System.out.println("电脑是混沌的，屏幕黑暗，工程师的灵运行在电路板上...");
        System.out.println("工程师说：要有系统，于是就有了系统...");
        System.out.println("工程师看系统是好的，就把系统安装在磁盘上，通过磁盘驱动器读取...");
        System.out.println("电脑启动时读取磁盘内的系统到内存上，工程师分配第一个磁盘驱动器为A，事就这样成了...");
        System.out.println("工程师就定义里面的磁盘为A盘，工程师看A盘是好的...");
        System.out.println("工程师说，为了方便，要有第二块磁盘驱动器，工程师称第一个磁盘为A，第二个磁盘为B，工程师看着是好的...");
        System.out.println("工程师说，要有硬盘，可以存储数据，快速安全...");
        System.out.println("并要装在机箱内，使人们看不到，事就这样成了...");
        System.out.println("工程师看硬盘是好的，有磁盘，有硬盘，各归其位，工程师称硬盘为C盘，工程师看C盘是好的...");
        System.out.println("于是工程师创造Windows，工程师让Windows运行在硬盘上，所以Windows的默认安装路径是C盘，工程师按兼容的思考升级Windows，乃是之后Windows默认安装路径都是C盘...");
        System.out.println("工程师看这一切是好的，于是就休息了...");
        System.out.println("—— 出自知乎问题 \"为什么Windows中第一个硬盘分区是C:\" 下cOMMANDO的回答");
        System.out.println("—— https://www.zhihu.com/question/20592179/answer/15579614\n");
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
