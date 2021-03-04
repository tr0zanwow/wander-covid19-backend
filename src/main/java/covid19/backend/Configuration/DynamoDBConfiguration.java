package covid19.backend.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfiguration {

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(buildAmazonDynamoDB());
    }

    private AmazonDynamoDB buildAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
        .standard()
        .withEndpointConfiguration(
            new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-2.amazonaws.com", "us-east-2")
        )
        .withCredentials(
            new AWSStaticCredentialsProvider(
                new BasicAWSCredentials("AKIA22O7X2LMWD6V5C4Q", "AezTFn/bjJh4IGg0Wey1q3p8Z+iERThoARKs+Inb")
            )
        )
        .build();
    }
}
