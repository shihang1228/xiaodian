������ĿĿ¼�ṹ

mvn archetype:generate -DarchetypeGroupId=org.apachetypes \
		       -DarchetypeArtifactId=maven-archetype-webapp \
		       -DgroupId=com.baldurtech \
		       -DartifactId=xiaodian

���� mvn compile
��� mvn clean
���� mvn tomcat:run
��� mvn package
���� mvn test

��ղ����� mvn clean tomcat:run
