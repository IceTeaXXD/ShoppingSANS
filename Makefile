uff:
	@mvn clean package
	@java --add-opens java.base/java.lang=ALL-UNNAMED -jar ./target/ShoppingSans-1.0-SNAPSHOT-jar-with-dependencies.jar