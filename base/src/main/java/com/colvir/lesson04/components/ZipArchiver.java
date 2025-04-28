package com.colvir.lesson04.components;

import com.colvir.lesson04.model.ArchiveFilePath;
import com.colvir.lesson04.services.Archiver;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class ZipArchiver implements Archiver {

    @Override
    public void archive(ArchiveFilePath archiveFilePath) throws IOException {
        File srcFile = new File(archiveFilePath.sourceFilePath());
        try (FileInputStream srcFis = new FileInputStream(srcFile);
             FileOutputStream destFos = new FileOutputStream(archiveFilePath.destFilePath())) {
            writeZip(destFos, srcFile, srcFis);
        }
    }

    private static void writeZip(FileOutputStream destFos, File srcFile, FileInputStream srcFis) throws IOException {
        try (ZipOutputStream zipOs = new ZipOutputStream(destFos)) {
            zipOs.putNextEntry(new ZipEntry(srcFile.getName()));

            byte[] buf = new byte[1024];
            int length;
            while ((length = srcFis.read(buf)) >= 0) {
                zipOs.write(buf, 0, length);
            }
        }
    }
}
