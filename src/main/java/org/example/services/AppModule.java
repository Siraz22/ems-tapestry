package org.example.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.commons.MappedConfiguration;
import org.apache.tapestry5.commons.OrderedConfiguration;
import org.apache.tapestry5.http.services.Request;
import org.apache.tapestry5.http.services.RequestFilter;
import org.apache.tapestry5.http.services.RequestHandler;
import org.apache.tapestry5.http.services.Response;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.ImportModule;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.modules.Bootstrap4Module;
import org.example.dao.EmployeeDAO;
import org.example.dao.impl.EmployeeDAOImpl;
import org.example.services.impl.EmployeeServiceImpl;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.UUID;

/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to
 * configure and extend Tapestry, or to place your own service definitions.
 */
@ImportModule(Bootstrap4Module.class)
public class AppModule {

    public static void bind(ServiceBinder binder) {
        binder.bind(EmployeeService.class, EmployeeServiceImpl.class).withId("EmployeeServiceImpl");
        binder.bind(EmployeeDAO.class, EmployeeDAOImpl.class).withId("EmployeeDAOImpl");
    }

    public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration) {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,fr,de");
        configuration.add(SymbolConstants.FILE_CHECK_INTERVAL, "10 m");
        configuration.add(SymbolConstants.ENABLE_PAGELOADING_MASK, false);
    }
}
