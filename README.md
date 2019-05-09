# message-system

Application uses:
1.Embedded Tomcat
2.Embedded H2
3.In-memory ActiveMQ
4.Lombok
5.Flyway
6.WebMvcTest
7.Swagger2


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
   GET http://${server_location}/message/read/Patil

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
    GET http://${server_location}/message/sent/Tushar

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
    GET http://${server_location}/message/details/1

    Response:
    [
         {
               "sender": "Tushar",
               "receiver": "Patil",
               "subject": "Hi There",
               "body": "Looking forward to work with you"
         }
    ]