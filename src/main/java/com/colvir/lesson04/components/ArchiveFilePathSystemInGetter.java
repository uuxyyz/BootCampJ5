package com.colvir.lesson04.components;

import com.colvir.lesson04.model.ArchiveFilePath;
import com.colvir.lesson04.services.ArchiveFilePathGetter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Scanner;

@Service
public class ArchiveFilePathSystemInGetter implements ArchiveFilePathGetter {
    @Override
    public ArchiveFilePath getFilePath() {
        System.out.print("Введите путь к файлу, который нужно заархивировать: ");
        String srcFilePath = new Scanner(System.in).nextLine();
        if (srcFilePath.isEmpty()) {
            srcFilePath = new File("").getAbsolutePath() + "/pom.xml";
        }

        System.out.print("Введите путь к результирующему файлу: ");
        String destFilePath = new Scanner(System.in).nextLine();
        if (destFilePath.isEmpty()) {
            destFilePath = srcFilePath + ".zip";
        }

        return new ArchiveFilePath(srcFilePath, destFilePath);
    }
}
