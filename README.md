# CarWash

A client-server app created for a Car Wash. 

There are two computers, one in the front desk to be used by the customers(client) and one in the cashe to be used by the employee(server). 

In the front desk there is a touch screen of min dimensions 1024x768, in which the customer enters the car's licence plate and then chooses one of the services. If he submits his info, then it will all be sent to the server, the main computer.

In the main computer, the user can choose to delete the request, or enter it in the receipt book which keeps track of all the info, as well as the time the customer checked in and the time the cashier printed the receipt.

CLIENT app

![client1](https://user-images.githubusercontent.com/74301312/127504101-0234a5c9-7fa0-49e2-8a54-45313631ed60.PNG)

SERVER app

![server1](https://user-images.githubusercontent.com/74301312/127504208-49463be3-a0a7-4fe7-9823-c07b53286bd1.PNG)

the customer enters the licence plate number

![client2](https://user-images.githubusercontent.com/74301312/127504158-15829aa1-d4d9-4521-a48f-b541c897a32d.PNG)

a new window with the services catalog opens

![client3](https://user-images.githubusercontent.com/74301312/127504498-2a943055-8fde-4ef9-b680-9599e6b94181.PNG)

if the customer chooses to go on the previous window the licence plate number is saved

![client4](https://user-images.githubusercontent.com/74301312/127504820-4d68f520-4559-4225-9b1c-59c0f8f20472.PNG)

the customer chooses a service and the vehicle type

![client5](https://user-images.githubusercontent.com/74301312/127504907-615bd66d-117e-4a02-b266-9d0cfae5198f.PNG)

![client6](https://user-images.githubusercontent.com/74301312/127504997-b0d6e5ce-e657-4c73-8891-1c066ae3be89.PNG)

if the info is submitted a confirmation dialog pops up

![client7](https://user-images.githubusercontent.com/74301312/127505052-d2fed805-e773-45e3-905e-d86b81529fba.PNG)

all the info is sent to the server as well as the check in time

![server2](https://user-images.githubusercontent.com/74301312/127505135-0cb00ba8-5473-41b7-9c04-b6e791a645de.PNG)

![server3](https://user-images.githubusercontent.com/74301312/127505384-1eb505c5-bc1b-44ab-a9e0-7032562c1e7c.PNG)

the user can delete a service and then it will be removed from the table

![server4](https://user-images.githubusercontent.com/74301312/127505446-ebd5d572-97fd-45ed-a59a-e83c391887d2.PNG)

the user can enter a service in the receipt book

![receiptBook1](https://user-images.githubusercontent.com/74301312/127505585-54f7407b-9928-4f26-a6f5-4feb154aa39b.PNG)

![server5](https://user-images.githubusercontent.com/74301312/127505523-84ed164a-91fb-4663-9653-d7e942985232.PNG)

the receipt book will be updated

![receiptBook2](https://user-images.githubusercontent.com/74301312/127505594-8c014610-97b0-4c66-9085-d89806710d54.PNG)

The user can't exit the server while there are pending service requests that are not deleted or saved in the receipt book.

If the server terminates unexpectedly then all pending service requests will be saved in the receipt book.



