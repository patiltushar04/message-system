# message-system

Application uses:
>>>Embedded Tomcat
>>>Embedded H2
>>>In-memory ActiveMQ
>>>Lombok
>>>Flyway


>>>Use case 1#Send message
    Request:
    POST http://${server_location}/message/send

    POST data:
    {
        "sender":"Tushar",
        "receiver": "Patil",
        "subject": "Hi There",
        "body": "Looking forward to work with you"
    }

    Response:
    Message sent successfully

>>>Use case 2#list incoming messages for a user
   Request:
   GET http://localhost:8081/message/read/Patil

   Response:
    [
         {
               "sender": "Tushar",
               "receiver": "Patil",
               "subject": "Hi There",
               "body": "Looking forward to work with you"
         }
    ]

>>>Use case 3#list sent messages by a user
    Request:
    GET http://localhost:8081/message/sent/Tushar

    Response:
    [
         {
               "sender": "Tushar",
               "receiver": "Patil",
               "subject": "Hi There",
               "body": "Looking forward to work with you"
         }
    ]

>>>Use case 4#Get message details by identified
    Request:
    GET http://localhost:8081/message/details/1

    Response:
    [
         {
               "sender": "Tushar",
               "receiver": "Patil",
               "subject": "Hi There",
               "body": "Looking forward to work with you"
         }
    ]