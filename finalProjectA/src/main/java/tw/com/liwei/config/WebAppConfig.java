package tw.com.liwei.config;

import java.util.ArrayList;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan("tw.com.liwei")
public class WebAppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public  ViewResolver  internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
//		resource.setBasename("messages");
//		return resource;
//	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSize(81920000);
		return resolver;
	}
	@Override 
	// 應用系統必須透過ResourceHandlerRegistry的輔助，以便處理靜態檔案：
	// 只要請求路徑是以/css/開頭的任何請求，都轉到/WEB-INF/views/css/去尋找
	// 只要請求路徑是以/image/開頭的任何請求，都轉到/WEB-INF/views/images/去尋找
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	     registry.addResourceHandler("/css/**")
	             .addResourceLocations("/WEB-INF/views/css/");
	     registry.addResourceHandler("/image/**")
	             .addResourceLocations("/WEB-INF/views/images/");
	}
//	@Bean 
//	public MappingJackson2JsonView jsonView() {
//	    MappingJackson2JsonView view = new MappingJackson2JsonView();
//	    view.setPrettyPrint(true);
//	    return view;
//	}
//
//	@Bean
//	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
//	    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
//	    resolver.setContentNegotiationManager(manager);
//	    ArrayList<View> views = new ArrayList<>();
//	    views.add(jsonView());
//	    resolver.setDefaultViews(views);
//	    return resolver;
//	}
	
}
