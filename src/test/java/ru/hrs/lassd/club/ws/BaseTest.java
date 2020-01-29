package ru.hrs.lassd.club.ws;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import ru.hrs.lassd.club.ws.config.Config;
import ru.hrs.lassd.club.ws.config.Data;


@ContextConfiguration(classes = Config.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseTest {


    @Before
    public void beforeTest(){

    }



//    @Autowired private RequestHelper requestHelper;
    @Autowired private Config config;
    @Autowired protected Data data;
//    @Autowired protected Utils utils;

}
