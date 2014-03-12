package com.cencolshare.util;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.util.StringUtils;

public class S3UploadUtil {

  String accessKey = "addkey";
  String secretKey = "addkey";
  String bucketName = "addbucketname";
  
  protected AWSCredentials credentials;
  protected AmazonS3 connection;
  private static S3UploadUtil instance;
  
  public S3UploadUtil() {
    credentials = new BasicAWSCredentials(accessKey, secretKey);
    connection = new AmazonS3Client(credentials);
    connection.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
  }
  
  public static S3UploadUtil getInstance() {
    if(null == instance) {
      instance = new S3UploadUtil();
    }
    return instance;
  }
  
  public List<Bucket> getBuckets() {
    List<Bucket> buckets = connection.listBuckets();
    for (Bucket bucket : buckets) {
            System.out.println(bucket.getName() + "\t" + StringUtils.fromDate(bucket.getCreationDate()));
    }
    return buckets;
  }
  
  public int uploadFile(ByteArrayInputStream stream, String filename) {
	ObjectMetadata meta = new ObjectMetadata();
    //connection.putObject(bucketName, filename, stream, meta);
	PutObjectRequest por = new PutObjectRequest(bucketName, filename, stream, meta);
	por.setCannedAcl(CannedAccessControlList.PublicRead);
	connection.putObject(por);
    return 0;
  }
  
  public void getFiles(String bucketName) {
    ObjectListing objects = connection.listObjects(bucketName);
    do {
            for (S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
                    System.out.println(objectSummary.getKey() + "\t" +
                            objectSummary.getSize() + "\t" +
                            StringUtils.fromDate(objectSummary.getLastModified()));
            }
            objects = connection.listNextBatchOfObjects(objects);
    } while (objects.isTruncated());
  }
  
}
