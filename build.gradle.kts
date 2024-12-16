plugins {
    id("java")
    application
}

group = "carsalessystem"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0")

    // Mockito dependencies for mocking
    testImplementation("org.mockito:mockito-core:3.9.0")

    // Optional: Add if you're using Mockito with inline mocking (needed for mocking final classes or methods)
    testImplementation("org.mockito:mockito-inline:3.9.0")
}

tasks.test {
    useJUnitPlatform()
}

application {
    // Specify the main class without the file extension
    mainClass.set("carsalessystem.CarSalesSystem") // Adjusted to the correct package and class name
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "carsalessystem.CarSalesSystem" // Specify the main class in the manifest
    }
    from({
        configurations.runtimeClasspath.get().filter { it.exists() }.map { if (it.isDirectory) it else zipTree(it) }
    })
}