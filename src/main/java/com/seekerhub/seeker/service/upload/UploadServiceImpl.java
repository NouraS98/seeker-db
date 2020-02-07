package com.seekerhub.seeker.service.upload;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.seekerhub.seeker.model.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {

    private final String ENDPOINT = "digitaloceanspaces.com";
    private final String REGION = "fra1";
    private final String CDN = "cdn";
    @Autowired
    private AmazonS3 amazonS3;

    @Override
    @Transactional
    public FileUpload upload(String space, String fileName, MultipartFile file) throws IOException {
        File convFile = convertMultiPartToFile(file);
        PutObjectRequest putObjectRequest = new PutObjectRequest(space, fileName.replace(" ", "_"), convertMultiPartToFile(file)).withCannedAcl(CannedAccessControlList.PublicRead);
        amazonS3.putObject(putObjectRequest);
        removeFileFromServer(convFile.getPath());
        return FileUpload.builder().key(fileName).url(constructUrl(space, fileName)).success(true).build();
    }

    @Override
    @Transactional
    public FileUpload delete(String space, String key) {
        DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(space, key);
        amazonS3.deleteObject(deleteObjectRequest);
        return FileUpload.builder().success(true).build();
    }

    private String constructUrl(String space, String filename) {
        return "https://" + space + "." + REGION + "." + CDN + "." + ENDPOINT + "/" + filename;
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private void removeFileFromServer(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }
}
