package idv.hsiehpinghan.stareproject.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("stareProjectSpringConfiguration")
@ComponentScan(basePackages = { "idv.hsiehpinghan.stareproject" })
public class SpringConfiguration {
	// private Logger logger = Logger.getLogger(this.getClass().getName());
}
