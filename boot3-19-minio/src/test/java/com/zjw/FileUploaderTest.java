package com.zjw;

import io.minio.*;
import io.minio.errors.MinioException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileUploaderTest {

    /**
     * 创建桶并上传文件
     */
    @Test
    public void createBucketAndUpload() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        String endpoint = "http://minio-termux:9000";
        String accessKey = "minioadmin";
        String secretKey = "minioadmin";
        String bucketName = "hello-minio";
        /* 文档参考：
            https://min.io/docs/minio/linux/administration/identity-access-management/policy-based-access-control.html#minio-policy-document
         */
        String config = """
                {
                   "Version" : "2012-10-17",
                   "Statement" : [
                      {
                         "Action" : [ "s3:GetObject" ],
                         "Effect" : "Allow",
                         "Principal" : "*",
                         "Resource" : "arn:aws:s3:::%s/*"
                      }
                   ]
                }
                """.formatted(bucketName);
        try {
            // Create a minioClient with the MinIO server , its access key and secret key.
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(endpoint)
                            .credentials(accessKey, secretKey)
                            .build();

            // Make 'hello-minio' bucket if not exist.
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {
                // Make a new bucket called 'hello-minio'.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketName).config(config).build());
            } else {
                System.out.println("Bucket '" + bucketName +"' already exists.");
            }

            // Upload 'D:/系统文件夹/Pictures/地球/2020-10-02_114212.png' as object name '2020-10-02_114212.png' to bucket
            // 'hello-minio'.
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(bucketName)
                            .object("2020-10-02_114212.png")
                            .filename("D:/系统文件夹/Pictures/地球/2020-10-02_114212.png")
                            .build());
            System.out.println(
                    "'D:/系统文件夹/Pictures/地球/2020-10-02_114212.png' is successfully uploaded as "
                            + "object '2020-10-02_114212.png' to bucket 'hello-minio'.");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }
    }
}