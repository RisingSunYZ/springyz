package annotation;

import com.anotation.transactional.MainConfigTransaction;
import com.anotation.transactional.sd.TestSdTransactional;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/13 9:27
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class TestTransaction {

    ApplicationContext app = new AnnotationConfigApplicationContext(MainConfigTransaction.class);


    @Test
    public void test(){
        TestSdTransactional bean = app.getBean(TestSdTransactional.class);
//        bean.add();
        bean.addAspect();
    }

}
