#futumap

# Run: 
```mvn spring-boot:run```

#Connect to db:
```heroku pg:psql postgresql-curved-78776 --app worker-details```

#Update or create with Flyway
### change application.properties
```spring.jpa.hibernate.ddl-auto=create```

#View server logs
```heroku logs --tail -a worker-details```
