package person.aslam.kutumbaservices;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import person.aslam.kutumbaservices.conf.ApplicationConfiguration;
import person.aslam.kutumbaservices.endpoint.ApplicationResource;

/**
 * Created by Aslam on 10/8/16.
 */
public class ApplicationStartup extends Application<ApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new ApplicationStartup().run(args);
    }

    @Override
    public String getName() {
        return "Kutumba-Services";
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
    }

    @Override
    public void run(ApplicationConfiguration configuration, Environment environment) {
        final ApplicationResource resource = new ApplicationResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
    }

}
