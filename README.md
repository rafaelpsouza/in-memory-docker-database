# In Memory Docker Database


In the Java world the most popular approach to test with in memory databases is using H2 or HSQLDB. These databases work well and can emulate some database syntax and features, but like most emulations, this is superficial, imperfect and doesn't cover important database features.

In Memory Docker Database is a Java library that allow you to easily launch a docker container with a real database instance (like postgres, mysql and so on). This database will be running [in memory][1] and the process to do that is lightweight and quick, what is really useful for test purposes.


## Overview

![Alt text](https://cacoo.com/diagrams/KJIYGq2xh7iCL33h-D6350.png?t=5)


## Setup

#### Enable Docker remote REST API:
```
$ echo "DOCKER_OPTS='-H tcp://0.0.0.0:2375 -H unix:///var/run/docker.sock'" > /etc/default/docker
$ service docker restart
```
[Read here more about it!][2]


#### Maven dependencies:

```
<repositories>
	<repository>
    	<id>in-memory-docker-database-mvn-repo</id>
        <url>https://raw.github.com/rafaelpsouza/in-memory-docker-database/mvn-repo/</url>
        <snapshots>
        	<enabled>true</enabled>
          	<updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
</repositories>
```


```
<dependency>
    <groupId>br.eng.rafaelsouza</groupId>
    <artifactId>in-memory-docker-database</artifactId>
    <version>1.0-SNAPSHOT</version>
	<scope>test</scope>
</dependency>
```

[1]: http://www.martinfowler.com/bliki/InMemoryTestDatabase.html
[2]: http://infoslack.com/devops/exploring-docker-remote-api/

    
