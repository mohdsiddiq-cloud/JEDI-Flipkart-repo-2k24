package com.flipfit.app;

import com.flipfit.restcontroller.*;
import com.flipfit.service.*;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        //  e.jersey().register(new EmployeeRESTController(e.getValidator()));

        System.out.println("HERE");
        e.jersey().register(new HelloController());


        System.out.print("/n/n/n AdminWorking /n/n/n");
        e.jersey().register(new AdminController(new FlipFitAdminServiceOperation()));

        System.out.print("/n/n/n CustomerWorking /n/n/n");
        e.jersey().register(new CustomerController(new FlipFitUserServiceOperations()));

        System.out.print("/n/n/n GymOwnerWorking /n/n/n");
        e.jersey().register(new GymOwnerController(new FlipFitGymOwnerServiceOperation()));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}