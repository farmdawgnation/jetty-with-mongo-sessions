# Jetty with Mongo Sessions

To try out Jetty with Mongo Sessions using this REPO do the following:

1. Spin up sbt and run `package`
2. Run `docker-compose up -d`
3. Visit http://localhost:8080/jetty-with-mongo-sessions/
4. Observe no exceptions in the jetty log: `docker-compose logs -f jetty`

If you remove the session identifier rule, you'll see a bunch of exceptions in the jetty log.
