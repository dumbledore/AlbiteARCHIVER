/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.albite.archiver;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author albus
 */
public class ALBFileFilter implements FileFilter {
    private boolean printOutput;

    public ALBFileFilter(boolean printOutput) {
        this.printOutput = printOutput;
    }
    
    public boolean accept(File file) {
        Printer.print("Inspecting " + file.getName() + "...", printOutput);
        //Ignore directories
        if(file.isDirectory()) {
            Printer.println("ignored.", printOutput);
            return false;
        }

        //Ignore jar files if present
        if (Archiver.getJarURI() != null) {
            if (file.toURI().equals(Archiver.getJarURI())) {
                Printer.println("ignored.", printOutput);
                return false;
            }
        }

        //Ignore alb files so one would not recompress the file
        if (file.getName().toLowerCase().endsWith(Archiver.FILE_EXTENSION)) {
            Printer.println("ignored.", printOutput);
            return false;
        }

        //File is OK for archiving
        Printer.println("OK", printOutput);
        return true;
    }
}
