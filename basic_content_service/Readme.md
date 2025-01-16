Grok prompts
generate a full swagger implementation for a blog post using spring boot
generate a complete pom
--Sub that in for the prior pom
generate a full main class for the service
replace com.example with com.bcs.app
mvn clean
mvn clean install
mvn spring-boot:run
https://x.com/i/grok/share/Bc4cnjnfilthZkcgHaPUIB6me

Next steps 
add in database logic
Grok
Take what had been generated thus far and add in mysql database storage for posts

Take what has been generated and add in the following line to put the properties outside of the project. 
        SpringApplication app = new SpringApplication(BlogPostApiApplication.class);
        app.setDefaultProperties(Collections.singletonMap("spring.config.location", 
                                                        "file:../../aws-resources/localhost-mac-java.properties"));
        app.run(args);
Also, inside the generated properties, it will set the ddl to auto regenerate the database on each build. Just make a note of that.

To have it mirror the scheme from the dotnet example 
Grok
Generate to match this schema BlogPost...
https://x.com/i/grok/share/SkuwoaP5lPyKpyuSLccScnSvN
