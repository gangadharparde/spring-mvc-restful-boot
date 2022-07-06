//------- Ignore thi sfile
/*
 * package com.gd.config; import org.springframework.context.annotation.Bean;
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
 * import org.springframework.web.servlet.mvc.method.annotation.
 * RequestMappingHandlerMapping;
 * 
 * @Configuration public class MvcConfig extends WebMvcConfigurationSupport{
 * 
 * @Bean public RequestMappingHandlerMapping requestMappingHandlerMapping() {
 * RequestMappingHandlerMapping handlerMapping =
 * super.requestMappingHandlerMapping();
 * handlerMapping.setUseSuffixPatternMatch(false);
 * handlerMapping.setUseTrailingSlashMatch(false); return handlerMapping; } }
 * 
 */
// In urls the dot is probably being truncated. or escaped. You can probably do
// something like this:
// https://stackoverflow.com/questions/54595497/spring-boot-getmapping-to-a-url-ending-with-jsp
// https://stackoverflow.com/questions/54595497/spring-boot-getmapping-to-a-url-ending-with-jsp
//
//	@GetMapping("/{pageName:.+}")
//	public String dotJspInPathHandle(@PathVariable("pageName") String pageName) {
//		//if (pageName.contains(".jsp")) {
//			return "login";
//		//}
//	}
