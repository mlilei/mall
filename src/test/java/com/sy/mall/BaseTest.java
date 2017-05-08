package com.sy.mall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 李磊
 * on 2017/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    @Test
    public void test() {
        LOGGER.info("SUCCESS");
    }
}
