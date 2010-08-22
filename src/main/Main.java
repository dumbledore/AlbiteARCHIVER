package main;

import org.albite.archiver.Archiver;

public class Main {

    public static void main(String[] args) {
        
        if (args.length > 0) {
            if (args[0].equals("h") || args[0].equals("/h") || args[0].equals("?") || args[0].equals("/?") || args[0].equals("help")) {
                System.out.println("ALBite Archive Builder");
                System.out.println();
                System.out.println("=== Usage ===");
                System.out.println();
                System.out.println("builder");
                System.out.println("  current directory to export.alb");
                System.out.println();
                System.out.println("builder out");
                System.out.println("  current directoty to file <out>");
                System.out.println();
                System.out.println("builder in out");
                System.out.println("  directory <in> to file <out>");
                return;
            }
        }
        
        String workingDirectoryName;
        String archiveFileName;
        
        if (args.length < 2) {
            workingDirectoryName = System.getProperty("user.dir");
        } else {
            workingDirectoryName = args[0];
        }

        if (args.length == 0) {
            archiveFileName = "export.alb";
        }  else {
            if (args.length == 1) {
                archiveFileName = args[0];
            } else { // > 1
                archiveFileName = args[1];
            }
        }
        
        Archiver.archive(workingDirectoryName, archiveFileName, true);
    }
}