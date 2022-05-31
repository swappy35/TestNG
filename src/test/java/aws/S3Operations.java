package aws;

import java.io.File;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.Region;

public class S3Operations {

	public static void main(String[] args) {
		AWSCredentials credentials = new BasicAWSCredentials("AKIA3H4BN4DJJWQIQBGZ", "plg96oMT2jEryj8jjMzmR4eVE8v2LNGzipKZutk5");
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.US_EAST_1)
				.build();
		
		//----------- Create Bucket ----------------
//		s3client.createBucket("swap35-2-bucket");
//		System.out.println("Bucket Created");
		
		
		//----------- List of Buckets --------------
		List<Bucket> buckets = s3client.listBuckets();
		
		for(Bucket bucket : buckets){
			System.out.println(bucket.getName());
		}
		
		
		//------------ Delete Bucket ---------------
//		s3client.deleteBucket("swap35-2-bucket");
//		System.out.println("bucket deleted");
		
		//
		s3client.putObject("swap35-bucket", "chromedriver.exe", new File("c:\\Grid\\chromedriver.exe"));
	}

}
