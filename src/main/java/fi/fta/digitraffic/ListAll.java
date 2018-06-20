package fi.fta.digitraffic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.iterable.S3Objects;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class ListAll
{
    public static final Logger log = LoggerFactory.getLogger(ListAll.class.getName());

    public static void main( String[] args )
    {
        // Tämä sovellus listaa kaikki digitraffic-aurora S3 bucketin bridge-vibration polun objektit ja antaa niille Public READ ACL-oikeuden

        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        final String bucket_name="digitraffic-aurora";
        final String prefix = "bridge-vibration";

        // Looppaa yli kaikkien objektien ja anna READ oikeus
        int count=0;
        for ( S3ObjectSummary summary : S3Objects.withPrefix(s3, bucket_name, prefix) ) {
            count++;
            // debug run (normal run takes about 1 hour) if (count > 100) System.exit(1);
            System.out.println(String.format("'%s'", summary.getKey()));
        }


    }
}
