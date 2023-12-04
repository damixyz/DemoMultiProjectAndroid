import java.net.URI

plugins {
    id("org.gradle.kotlin.kotlin-dsl") version ("2.4.1")
}

group = "org.example"
version = "unspecified"

repositories {
    google()
    mavenCentral()
    if (project.hasProperty("centralRepo")) {
        maven {
            name = "MavenCentral"
            url = project.properties["centralRepo"] as URI
            isAllowInsecureProtocol = true
        }
    } else {
        mavenCentral()
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

gradlePlugin {
    plugins.register("DependenciesPlugin") {
        id = "DependenciesPlugin"
        implementationClass = "DependenciesPlugin"
    }

}

tasks.test {
    useJUnitPlatform()
}
