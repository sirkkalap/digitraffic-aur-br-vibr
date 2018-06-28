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
