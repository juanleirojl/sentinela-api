package br.com.jl.sentinela.core.springfox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicate;

import br.com.jl.sentinela.api.Erro;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket api() {
		var typeResolver = new TypeResolver();
    	
    	return new Docket(DocumentationType.SWAGGER_2)
    	        .select()
    	        .apis(apis())
    	        .paths(paths())
    	        .build()
    	        .useDefaultResponseMessages(false)
    	        
    	        .globalResponseMessage(RequestMethod.GET, globalGetResponseMessages())
				.globalResponseMessage(RequestMethod.POST, globalPostPutResponseMessages())
				.globalResponseMessage(RequestMethod.PUT, globalPostPutResponseMessages())
				.globalResponseMessage(RequestMethod.DELETE, globalDeleteResponseMessages())
				.additionalModels(typeResolver.resolve(Erro.class))
				
    	        .apiInfo(apiInfo())

    	
    	        .tags(new Tag("Categorias", "Gerencia as categorias"),
					  new Tag("Tipo Categorias", "Gerencia os tipo de categorias"),
					  new Tag("Lançamentos", "Gerencia os Lançamentos")
    	        		);
    	
    }


	private Predicate<String> paths() {
		Predicate<String> ant = PathSelectors.ant("/api/**");
		return ant;
	}
    
    
    private Predicate<RequestHandler> apis() {
    	return RequestHandlerSelectors.basePackage("br.com.jl.sentinela");
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Sentinela")
                .description("Projeto de Controle Financeiro e Investimento")
                .version("1.0.0")
                //.license("Apache License Version 2.0")
                //.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact( "Juan Leiro", "http://jl.com.br", "juan.leiro@gmail.com"))
                .build();
    }
    
    
    
    @SuppressWarnings("serial")
    private List<ResponseMessage> globalGetResponseMessages() {
		return new ArrayList<ResponseMessage>() {{
				add(new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno do servidor")
					.responseModel(new ModelRef("Erro"))
					.build());
				add(new ResponseMessageBuilder()
					.code(HttpStatus.NOT_ACCEPTABLE.value())
					.message("Recurso não possui representação que poderia ser aceita pelo consumidor")
					.build()
			);
		}};
	}
    
    private List<ResponseMessage> globalPostPutResponseMessages() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(HttpStatus.BAD_REQUEST.value())
					.message("Requisição inválida (erro do cliente)")
					.responseModel(new ModelRef("Erro"))
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno no servidor")
					.responseModel(new ModelRef("Erro"))
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.NOT_ACCEPTABLE.value())
					.message("Recurso não possui representação que poderia ser aceita pelo consumidor")
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
					.message("Requisição recusada porque o corpo está em um formato não suportado")
					.responseModel(new ModelRef("Erro"))
					.build()
			);
	}
	
	private List<ResponseMessage> globalDeleteResponseMessages() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(HttpStatus.BAD_REQUEST.value())
					.message("Requisição inválida (erro do cliente)")
					.responseModel(new ModelRef("Erro"))
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno no servidor")
					.responseModel(new ModelRef("Erro"))
					.build()
			);
	}
}
