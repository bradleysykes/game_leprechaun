package gae;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class PackageClassFinder {
	public PackageClassFinder() {}
	
	public List<Class> getClassesForPackage(String pckgname) throws ClassNotFoundException {
         // This will hold a list of directories matching the pckgname. There may be more than one if a package is split over multiple jars/paths
         ArrayList<File> directories = new ArrayList<File>();
         try {
             ClassLoader cld = Thread.currentThread().getContextClassLoader();
             if (cld == null) {
                 throw new ClassNotFoundException("Can't get class loader.");
             }
             String path = "\\"+ pckgname.replace('.', '\\');
             // Ask for all resources for the path
             Enumeration<URL> resources = cld.getResources(path);
             while (resources.hasMoreElements()) {
                 directories.add(new File(URLDecoder.decode(resources.nextElement().getPath(), "UTF-8")));
             }
         } catch (NullPointerException x) {
             throw new ClassNotFoundException(pckgname + " does not appear to be a valid package (Null pointer exception)");
         } catch (UnsupportedEncodingException encex) {
             throw new ClassNotFoundException(pckgname + " does not appear to be a valid package (Unsupported encoding)");
         } catch (IOException ioex) {
             throw new ClassNotFoundException("IOException was thrown when trying to get all resources for " + pckgname);
         }

         ArrayList<Class> classes = new ArrayList<Class>();
         // For every directory identified capture all the .class files
         for (File directory : directories) {
             if (directory.exists()) {
                 // Get the list of the files contained in the package
                 String[] files = directory.list();
                 for (String file : files) {
                     // we are only interested in .class files
                     if (file.endsWith(".class")) {
                         // removes the .class extension
                       try
                       {
                         classes.add(Class.forName(pckgname+"."+file.substring(0, file.length()-6)));                      
                       }
                       catch (NoClassDefFoundError e)
                       {
                    	 System.out.println("couldn't find class def");
                         // do nothing. this class hasn't been found by the loader, and we don't care.
                       }
                     }
                 }
             } else {
                 throw new ClassNotFoundException(pckgname + " (" + directory.getPath() + ") does not appear to be a valid package");
             }
         }
         return classes;
     }  
}
