package com.example.sample.api;

import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

// https://github.com/swagger-api/swagger-core/wiki/Swagger-Core-Jersey-2.X-Project-Setup-1.5

public class SwaggerBootstrap extends HttpServlet {
	private static final long serialVersionUID = -6959677770116395759L;

	@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        String contextPath = config.getServletContext().getContextPath();
      
        //equivalen to @Info but overrides so all need to be set here ...
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("Hello API");
        beanConfig.setDescription("Hello Service");
        beanConfig.setLicense("Apache 2.0");
        beanConfig.setLicenseUrl("http://www.apache.org/licenses/LICENSE-2.0");
        //beanConfig.setSchemes(new String[]{"http"});
        //beanConfig.setHost("localhost:8002");
        beanConfig.setBasePath(contextPath+"/v1");
        String packageName = getClass().getPackage().getName();
        beanConfig.setResourcePackage(packageName);
        beanConfig.setScan(true);
    }
}
