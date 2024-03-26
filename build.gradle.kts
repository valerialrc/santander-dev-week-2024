plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2023.0.0"

// https://start.spring.io/#!type=gradle-project-kotlin&language=java&platformVersion=3.2.4&packaging=jar&jvmVersion=21&groupId=com.example&artifactId=santander-dev-week-2024&name=santander-dev-week-2024&description=API%20Rest%20com%20Java%2021%20e%20Spring%20Boot%203&packageName=com.example.sdw-2024&dependencies=web,data-jdbc,h2,cloud-feign

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
