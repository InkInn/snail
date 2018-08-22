package patterns.commandChain;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassUtils {
    public static List<Class> getSonClass(Class fatherClass){
        List<Class> returnClassList = new ArrayList<>();
        String packageName = fatherClass.getPackage().getName();
        List<Class> packClasses = getClasses(packageName);
        for (Class packClass : packClasses) {
            if(fatherClass.isAssignableFrom(packClass) && !fatherClass.equals(packClass)){
                returnClassList.add(packClass);
            }
        }
        return returnClassList;
    }


    private static List<Class> getClasses(String packageName){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.','/');
        Enumeration<URL> resources = null;
        try {
            resources = classLoader.getResources(path);
        }catch (IOException e){
            e.printStackTrace();
        }
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()){
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<>();
        for (File dir : dirs) {
            classes.addAll(findClasses(dir,packageName));
        }
        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName){
        List<Class> classes = new ArrayList<>();
        if(!directory.exists()){
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file,packageName + "." + file.getName()));
            }else if(file.getName().endsWith(".class")){
                try {
                    classes.add(Class.forName(packageName + "." + file.getName().substring(0,file.getName().length() - 6)));
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
        return classes;
    }
}
