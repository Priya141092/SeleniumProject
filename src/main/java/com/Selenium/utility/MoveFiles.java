package com.Selenium.utility;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.*;
import java.io.IOException;

public class MoveFiles {

	String sourceFolder = ".//ExtentReports";
    String targetFolder = ".//OlderReports";
    
    public void movefilesmethod()
    {
    try {
        Path sourcePath = Paths.get(sourceFolder);
        Path targetPath = Paths.get(targetFolder);

        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourcePath, "*.html");
        for (Path path : directoryStream) {
            if (Files.isRegularFile(path)) {
                String fileName = path.getFileName().toString();
                Path targetFilePath = targetPath.resolve(fileName);

                Files.move(path, targetFilePath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Moved file " + fileName + " to " + targetFilePath.toString());
            }
        }
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
	
	
    }	
}


      

