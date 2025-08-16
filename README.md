# AutomationCucmber
Easy way to learn Automation in all phases of application Web,API and Java.
./gradlew <>:bootRun -PskipSpotless=true '--args=--threads 4'
   implementation 'software.amazon.awssdk:s3'
        implementation 'software.amazon.awssdk:kms'
        implementation 'software.amazon.awssdk:sfn'
        implementation 'software.amazon.awssdk:lambda'
        implementation 'software.amazon.awssdk:sns'
        implementation 'software.amazon.awssdk:sqs'
        implementation 'software.amazon.awssdk:netty-nio-client'
        implementation 'software.amazon.awssdk:apache-client'
        implementation "io.rest-assured:rest-assured:${restAssuredVersion}"
        implementation "io.rest-assured:json-path:${restAssuredVersion}"
        implementation "io.rest-assured:xml-path:${restAssuredVersion}"
        implementation "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:${jacksonVersion}"
        implementation "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${jacksonVersion}"

## Running tests

To execute the sample ETL test, install the required Python dependencies and run:

```bash
pytest tests/test_sample_etl.py
```

To run the regression suite, including hallucination checks maintained by @smike and @a11y, use:

```bash
pytest -m regression
```

For a quick smoke check of the sample health API endpoint, run:

```bash
pytest -m smoke
```
