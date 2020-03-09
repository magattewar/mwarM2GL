package com.magattewar.mwarm2gl;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * nom : WAR
 * prenom : Magatte
 * classe : M2GL
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Mwarm2glApplication.class);
	}

}
