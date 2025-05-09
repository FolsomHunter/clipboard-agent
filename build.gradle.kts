plugins {
    java
    id("com.gradleup.shadow") version "9.0.0-beta9"
}

group = "dev.xdark"
version = "1.0"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(20))

repositories.mavenCentral()
dependencies.implementation("org.ow2.asm:asm:9.7.1")

tasks.jar.configure {
    val mainClass = "dev.xdark.clipboardagent.ClipboardAgent"
    manifest.attributes(
        "Premain-Class" to mainClass,
        "Agent-Class" to mainClass,
        "Can-Retransform-Classes" to true
    )
}

tasks.shadowJar.configure {
    relocate("org.objectweb.asm", "dev.xdark.clipboardagent.org.objectweb.asm")
    minimize()
    archiveFileName.set("clipboard-agent.jar")
}

// Remove generated standard jar task (e.g., clipboard-agent-1.0.jar)
tasks.jar {
    enabled = false
}

tasks.build.configure {
    dependsOn(tasks.shadowJar)
}
