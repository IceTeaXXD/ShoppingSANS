package com.shoppingsans.Chart;

import java.awt.Component;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarFile;

public class JarClassLoader {
    private URLClassLoader classLoader;
    JarFile jarFile;

    public JarClassLoader(String jarPath) throws Exception {
        File file = new File(jarPath);
        URL url = file.toURI().toURL();
        classLoader = new URLClassLoader(new URL[] { url }, this.getClass().getClassLoader());
        jarFile = new JarFile(file);
    }

    public void loadClass(String className) throws Exception {
        Class<?> clazz = classLoader.loadClass(className);
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("main")) {
                method.invoke(null, new Object[] { new String[] {} });
            }
        }
    }

    public void printAllClass() {
        jarFile.stream().forEach(entry -> {
            System.out.println(entry.getName());
        });
    }

    public void printMethodInClass(String classname) throws Exception {
        Class<?> clazz = classLoader.loadClass(classname);
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    public Component loadClassObject(String className) throws Exception {
        Class<?> clazz = classLoader.loadClass(className);
        return (Component) clazz.newInstance();
    }
}
