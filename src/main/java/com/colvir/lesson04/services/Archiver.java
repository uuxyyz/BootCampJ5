package com.colvir.lesson04.services;

import com.colvir.lesson04.model.ArchiveFilePath;

import java.io.IOException;

public interface Archiver {
    void archive(ArchiveFilePath archiveFilePath) throws IOException;
}
