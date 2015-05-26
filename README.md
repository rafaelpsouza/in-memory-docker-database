# In Memory Docker Database


In the Java world the most popular approach to test with in memory databases is using H2 or HSQLDB. These databases work well and can emulate some database syntax and features, but like most emulations, this is superficial, imperfect and doesn't cover important database features.

In Memory Docker Database is a Java library that allow you to easily launch a docker container with a real database instance (like postgres, mysql and so on). This database will be running [in memory][1] and the process to do that is lightweight and quick, what is really useful for test purposes.

## Overview

![Alt text](https://cacoo.com/diagrams/KJIYGq2xh7iCL33h-D6350.png?t=2)


[1]: http://www.martinfowler.com/bliki/InMemoryTestDatabase.html
