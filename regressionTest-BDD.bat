echo " Welcome to Batch Executioin  - Project Module"
cd D:\SynechronWeekendBatch\Eclipse_WS\actitime
d:
set path=%path%;D:\maven\apache-maven-3.6.1\bin
set classpath=D:\SynechronWeekendBatch\Eclipse_WS\actitime\target\*;.
mvn test -Dcucumber.filter.tags="@onlygoogle and @batch"
