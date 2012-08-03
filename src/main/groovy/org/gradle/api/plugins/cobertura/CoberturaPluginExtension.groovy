package org.gradle.api.plugins.cobertura

import org.gradle.api.Project

class CoberturaPluginExtension {
    public static final NAME = "cobertura"

    List<String> dirs
    File datafile
    File reportDir
    String instrumentationDir
    String format = 'html'
    Set<File> sourceDirs
    List<String> includes = ['**/*.java', '**/*.groovy', '**/*.scala']
    List<String> excludes = []
    List<String> ignores = []

    Project project

    CoberturaPluginExtension(Project project) {
        this.project = project
        dirs = [project.sourceSets.main.output.classesDir.path]
        datafile = new File("${project.buildDir.path}/cobertura", 'cobertura.ser')
        reportDir = new File("${project.reporting.baseDir.path}/cobertura")
        instrumentationDir = "${project.buildDir.path}/instrumented"
    }
}
