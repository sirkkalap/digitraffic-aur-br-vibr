# digitraffic-aur-br-vibr

## Building and running
```bash
mvn package
time java -jar target/aurora-br-vibr-1.0-SNAPSHOT-jar-with-dependencies.jar >2018-04-25-listing.txt
```
Note: Running time will be around an hour or so.

## Copying the result to S3 index.txt
See also: http://digitraffic.liikennevirasto.fi/en/experimental/

```bash
aws s3 cp 2018-06-28-listing.txt s3://digitraffic-aurora/bridge-vibration/index.txt
```

## Configuring AWS credentials

To access (read and write) the AWS S3 bucket it is requiored to have awscli configured.

You need the AWS Access Key ID. It need to be from a Security credential under a account with permissions to read and write the S3
bucket. For example my accout has the permission with policy name "DigitrafficAuroraS3ListRW" (managed policy from group
 "DigitrafficAuroraS3ListGetPut").
 
 See IAM -> Users -> <USER> -> Permissions and IAM -> Users -> <USER> -> Security credentials for details. Create a new access key, if needed.
 
 ```
 aws configure
 AWS Access Key ID: xxxxxxxxxxxxxxxx
 Secret access key: xxxxxxxxxxxxxxxxxxxxxxxxxxxx
 Default region name: eu-west-1
 Default output format: None
 aws s3 ls s3://digitraffic-aurora/bridge-vibration/index.txt
 2019-01-02 13:35:43   36917036 index.txt
 ```
 