echo "Welcome to Batch Exeuction"
d:
cd D:\SynechronWeekendBatch\Eclipse_WS\actitime
set path=%path%;D:\maven\apache-maven-3.6.1\bin
set classpath=D:\SynechronWeekendBatch\Eclipse_WS\actitime\target\*;.
mvn test
