FROM mysql
# Copy the database initialize script:
# Contents of /docker-entrypoint-initdb.d are run on mysqld startup
#ADD  Dump/ /docker-entrypoint-initdb.d/
# Default values for passwords and database name. Can be overridden on docker run
# ENV MYSQL_ROOT_PASSWORD=my-secret-pw # Not defaulted for security reasons!
ENV MYSQL_DATABASE=skylife
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=12341234