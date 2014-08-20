创建项目目录结构

mvn archetype:generate -DarchetypeGroupId=org.apachetypes \
		       -DarchetypeArtifactId=maven-archetype-webapp \
		       -DgroupId=com.baldurtech \
		       -DartifactId=xiaodian

编译 mvn compile
清空 mvn clean
运行 mvn tomcat:run
打包 mvn package
测试 mvn test

清空并运行 mvn clean tomcat:run
