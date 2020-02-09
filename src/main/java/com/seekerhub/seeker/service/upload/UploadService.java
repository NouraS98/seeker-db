package com.seekerhub.seeker.service.upload;

import com.seekerhub.seeker.model.FileUpload;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {

    FileUpload upload(String space, String fileName, MultipartFile file) throws IOException;

    FileUpload delete(String space, String key);
}
