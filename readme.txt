1. The application is built on JDK 17 and spring boot 3.4.3
2. I have used maven as build tool.
3. I have used .h2 database provided by the spring boot because I didn't have other databases installed in my PC.

Steps to deploy the application
1. Deploy the .jar file in the server 
2. take the provided .sql file and import it to the database.
3. Application will run on port 8080


Test the application using postman 

1.  API to register players in the game.  Please save parameters such as device ID, user name, platform (iOS, Android, etc.), creation date
URL ->  http://localhost:8080/api/player/register
 JSON POST request body -> {
  "deviceId": "player2",
  "userName": "Jill",
  "platform": "Andoid",
  "creationDate": "2025-04-11T11:00:15",
  "country": "US"
}

2.API to save player progression data.This will include parameters like level, rank, currency (gold, cash, gem), rewards collected (name and ID of reward)
 URL ->  http://localhost:8080/api/player/progress
 Request body:
{
  "deviceId": "player2",
  "level": 3,
  "rank": 15,
  "currency": "gem",
  "rewardName": "Professional Pack3",
  "rewardId": "reward-001",
  "country": "US"
}

3. Submit Scores ( played , game Id , score , timestamp )
URL ->http://localhost:8080/api/player/submit
Body
{
  "deviceId": "player2",
  "gameId": "game_02",
  "score": 5000,
  "country": "US"
}

4. Get Top X Players w.r.t (global, per game) 
URL ->  http://localhost:8080/api/player/top/global?count=10  
GET request

5. Get Top X Player w.r.t (country, per game)
URL -> http://localhost:8080/api/player/top/game?gameId=game_02&count=5
GET request

6. Schedule Game Events (name, start time, end time, configuration (this includes rewards, eligibility))
URL -> http://localhost:8080/api/events/schedule
Request Body
{
  "name": "Spring Tournament",
  "startTime": "2025-04-15T10:00:00",
  "endTime": "2025-04-18T23:59:00",
  "configuration": "{\"rewards\": [\"gold\", \"gem\"], \"eligibility\": \"level > 5\"}"
}

7. GET Available (valid events w.r.t time) Events 
URL  -> http://localhost:8080/api/events

8. UPDATE Game Events

URL -> http://localhost:8080/api//update/{id}




