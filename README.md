# StackExchange scala-spark Analyzer

https://archive.org/details/stackexchange

This project handles stackexchange archives data in Apache Spark with proper framework design
concepts. By an example of implementation any project in Spark-Scala can be in production pipeline.



# Modules <img align="right" width="290" height="160" src="https://github.com/prompt-spark/stackexchange-spark-scala-analyser/blob/master/PROMPT_logo_1.png?raw=true">


	└── src
	    ├── main
	    │   ├── resources
	    │   │   ├── AirflowSparkSubmitStackExchange.py
	    │   │   ├── schemaInformation
	    │   │   │   └── StackExchangeData.md
	    │   │   │
	    │   │   └── StackExchangeTestData
	    │   │       ├── 3dprinting.stackexchange.com
	    │   │       │   ├── Badges.xml
	    │   │       │   ├── Comments.xml
	    │   │       │   ├── PostHistory.xml
	    │   │       │   ├── PostLinks.xml
	    │   │       │   ├── Posts.xml
	    │   │       │   ├── Tags.xml
	    │   │       │   ├── Users.xml
	    │   │       │   └── Votes.xml
	    │   │       │
	    │   │       └── raspberrypi.meta.stackexchange.com
	    │   │           ├── Badges.xml
	    │   │           ├── Comments.xml
	    │   │           ├── PostHistory.xml
	    │   │           ├── PostLinks.xml
	    │   │           ├── Posts.xml
	    │   │           ├── Tags.xml
	    │   │           ├── Users.xml
	    │   │           └── Votes.xml
	    │   │
	    │   └── scala
	    │       └── com
	    │           └── promptscalaspark
	    │               └── stackexchange
	    │                   ├── api
	    │                   │   ├── d3.js
	    │                   │   ├── LoaderHelper.scala
	    │                   │   └── ModellerHelper.scala
	    │                   │
	    │                   ├── functionalModel
	    │                   │   └── PostUserRelationalModel.scala
	    │                   │
	    │                   ├── io
	    │                   │   ├── ioSchema
	    │                   │   │   └── StackExchangeInputSchema.scala
	    │                   │   │
	    │                   │   ├── loader
	    │                   │   │   ├── BadgesXmlDataLoader.scala
	    │                   │   │   ├── CommentsXmlDataLoader.scala
	    │                   │   │   ├── PostHistoryXmlDataLoader.scala
	    │                   │   │   ├── PostLinksXmlDataLoader.scala
	    │                   │   │   ├── PostXmlDataLoader.scala
	    │                   │   │   ├── TagsXmlDataLoader.scala
	    │                   │   │   ├── UsersXmlDataLoader.scala
	    │                   │   │   └── VotesXmlDataLoader.scala
	    │                   │   │
	    │                   │   └── writer
	    │                   │       └── DSWriter.scala
	    │                   │
	    │                   ├── jobs
	    │                   │   ├── StackExchangeBatchJob.scala
	    │                   │   ├── StackExchangeElasticSearchJob.scala
	    │                   │   ├── StackExchangeMLJob.scala
	    │                   │   └── StackExchangeStreamingJob.scala
	    │                   │
	    │                   ├── modeller
	    │                   │   ├── ModellerSchema
	    │                   │   │   ├── PostsModellerSchema.scala
	    │                   │   │   └── UserModellerSchema.scala
	    │                   │   │
	    │                   │   ├── PostsModeller.scala
	    │                   │   └── UserModeller.scala
	    │                   │
	    │                   └── visualiser
	    │                       ├── preVisualiser.scala
	    │                       ├── StackExchangeDashboardPosts.html
	    │                       └── StackExchangeDashboardUsers.html
	    │
	    └── test
	        └── scala
	            └── com
	                └── promptscalaspark
	                    └── stackexchange
	                        ├── functionalModel
	                        │   └── PostUserRelationalModelSpec.scala
	                        │
	                        ├── io
	                        │   ├── loader
	                        │   │   ├── BadgesXmlDataLoaderSpec.scala
	                        │   │   ├── CommentsXmlDataLoaderSpec.scala
	                        │   │   ├── PostHistoryXmlDataLoaderSpec.scala
	                        │   │   ├── PostLinksXmlDataLoaderSpec.scala
	                        │   │   ├── PostsXmlDataLoaderSpec.scala
	                        │   │   ├── TagsXmlDataLoaderSpec.scala
	                        │   │   ├── UsersXmlDataLoaderSpec.scala
	                        │   │   └── VotesXmlDataLoaderSpec.scala
	                        │   │
	                        │   └── writer
	                        │       ├── DSWriterSpec.scala
	                        │       └── ParquetWriterSpec.scala
	                        │
	                        ├── jobs
	                        │   ├── StackExchangeBatchJobSpec.scala
	                        │   ├── StackExchangeElasticSearchJobSpec.scala
	                        │   ├── StackExchangeMLJobSpec.scala
	                        │   └── StackExchangeStreamingJobSpec.scala
	                        │
	                        ├── modeller
	                        │   ├── PostsModellerSpec.scala
	                        │   └── UserModellerSpec.scala
	                        │
	                        └── SparkSpec.scala


# Description

* A production-based Scala ETL pipeline for scalable data analysis.

As a supports state-of-the-art dataflow engines such as 
[Apache Spark](https://spark.apache.org/) as backend processor.
