FROM postgres:9.4


# RUN ["mkdir", "/docker-entrypoint-initdb.d"]
ADD make_app_user.sql /docker-entrypoint-initdb.d/

# Adjust PostgreSQL configuration so that remote connections to the
# database are possible. 
#RUN echo "host all  all    0.0.0.0/0  md5" >> /etc/postgresql/9.3/main/pg_hba.conf

# Add VOLUMEs to allow backup of config, logs and databases
#VOLUME  ["/etc/postgresql", "/var/log/postgresql", "/var/lib/postgresql"]

#CMD ["/usr/lib/postgresql/9.3/bin/postgres", "-D", "/var/lib/postgresql/9.3/main", "-c", "config_file=/etc/postgresql/9.3/main/postgresql.conf"]


EXPOSE 5432
