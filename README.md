# StackExchange scala-spark Analyzer

https://archive.org/details/stackexchange

This project handles stackexchange archives data in Apache Spark with proper framework design
concepts. By an example of implementation any project in Spark-Scala can be in production pipeline.


# Modules

    |--api
       |--LoaderHelper
       |--ModellerHelper
       |--visualizerHelper
       |--JobMediator
    |--io
       |--ioSchema
       |--loader
       |--writer
    |--Modeller
       |--ModellerSchema
    |--visualizer
       |--VisualizerSchema
    |--jobs

# Description

* A production-based Scala ETL pipeline for scalable data analysis.

As a supports state-of-the-art dataflow engines such as 
[Apache Spark](https://spark.apache.org/) as backend processor.
