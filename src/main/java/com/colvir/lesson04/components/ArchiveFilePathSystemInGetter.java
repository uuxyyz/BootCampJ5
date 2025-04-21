package com.colvir.lesson04.components;

import com.colvir.lesson04.model.ArchiveFilePath;
import com.colvir.lesson04.services.ArchiveFilePathGetter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Scanner;

@Service
public class ArchiveFilePathSystemInGetter implements ArchiveFilePathGetter {

    public static final String POM_XML_FN = "/pom.xml";
    public static final String ZIP_FILE_EXT = ".zip";

    @Override
    public ArchiveFilePath getFilePath() {
        System.out.print("Введите путь к файлу, который нужно заархивировать: ");
        String srcFilePath = new Scanner(System.in).nextLine();
        if (srcFilePath.isEmpty()) {
            srcFilePath = new File("").getAbsolutePath() + POM_XML_FN;
        }

        System.out.print("Введите путь к результирующему файлу: ");
        String destFilePath = new Scanner(System.in).nextLine();
        if (destFilePath.isEmpty()) {
            destFilePath = srcFilePath + ZIP_FILE_EXT;
        }

        return new ArchiveFilePath(srcFilePath, destFilePath);
    }
}
