from airflow import DAG

from airflow.contrib.operators.spark_submit_operator import SparkSubmitOperator
from airflow.utils import timezone


DEFAULT_DATE = timezone.datetime(2017, 1, 1)

args = {
    'owner': 'airflow',
    'start_date': DEFAULT_DATE
}
dag = DAG('test_dag_id', default_args=args)

_config = {
    'packages': 'com.databricks:spark-xml_2.11:0.4.1',
    'total_executor_cores': 4,
    'executor_cores': 4,
    'executor_memory': '22g',
    'name': '{{ task_instance.task_id }}',
    'num_executors': 1,
    'verbose': True,
    'application': '/home/xargus/Documents/MyGit/stackexchange-spark-scala-analyser/target/scala-2.11/stackexchange-spark-scala-analyser-assembly-0.1.jar',
    'driver_memory': '3g',
    'java_class': 'com.promptscalaspark.stackexchange.jobs.StackExchangeBatchJob',
    'application_args': [
        '-input_path', '/home/xargus/Documents/MyGit/stackexchange-spark-scala-analyser/src/main/resources/StackExchangeTestData/*/',
        '--output_path', '/home/xargus/Desktop/writerTest'
    ]
}

#./spark-submit --master local --class com.promptscalaspark.stackexchange.jobs.StackExchangeBatchJob
# --packages com.databricks:spark-xml_2.11:0.4.1
# /home/xargus/Documents/MyGit/stackexchange-spark-scala-analyser/target/scala-2.11/stackexchange-spark-scala-analyser-assembly-0.1.jar
# --input_path '/home/xargus/Documents/MyGit/stackexchange-spark-scala-analyser/src/main/resources/StackExchangeTestData/*/'
# --output_path /home/xargus/Desktop/writerTest

operator = SparkSubmitOperator(
    task_id='spark_submit_job',
    dag=dag,
    **_config
)