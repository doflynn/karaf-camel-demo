# Karaf-Camel Demo
Apache Karaf demo with Apache Camel 

## POM Hierarchy
* camel-demo: parent POM


## Build
The *camel-demo* project uses maven for its build and project management.  A parent-child model is used 
via maven's  `mvn clean install`

## Karaf Commands
Install camel into karaf 
* `feature:repo-add camel 2.20.1`
* `feature:install camel`

Install camel-demo into karaf
* `feature:repo-add mvn:com.lodentech.camel-demo/camel-demo-feature/0.0.1-SNAPSHOT/xml`
* `feature:install camel-demo`

